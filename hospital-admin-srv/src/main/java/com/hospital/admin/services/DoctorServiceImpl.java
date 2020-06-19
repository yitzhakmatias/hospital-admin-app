package com.hospital.admin.services;

import com.hospital.admin.domain.Patient;
import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.repositories.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DoctorServiceImpl implements IDoctorService {

    @PersistenceContext
    private EntityManager em;
    private final DoctorRepository _doctorRepository;
    private ModelMapper modelMapper;
    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this._doctorRepository = doctorRepository;
        modelMapper = new ModelMapper();

    }

    @Override
    public DoctorDTO GetDoctorById(UUID id) {
        return DoctorDTO.builder().Id(id)
                .Name("John").LastName("Martinez").build();
    }

    @Override
    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {
        return DoctorDTO.builder()
                .Id(UUID.randomUUID())
                .Name(doctorDTO.getName())
                .LastName(doctorDTO.getLastName())
                .build();
    }

    @Override
    public DoctorDTO updateDoctor(UUID uuid, DoctorDTO doctorDTO) {
        return DoctorDTO.builder()
                .Id(UUID.randomUUID())
                .Name(doctorDTO.getName())
                .LastName(doctorDTO.getLastName())
                .build();
    }

    @Override
    public List<DoctorDTO> GetDoctorList() {
        var result = _doctorRepository.findAll();
        return
                result
                        .stream()
                        .map(source -> modelMapper.map(source, DoctorDTO.class))
                        .collect(Collectors.toList());
    }

}
