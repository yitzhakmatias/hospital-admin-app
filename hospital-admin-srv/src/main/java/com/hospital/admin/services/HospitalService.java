package com.hospital.admin.services;

import com.hospital.admin.domain.Hospital;
import com.hospital.admin.mappers.HospitalMapper;
import com.hospital.admin.model.HospitalDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.repositories.HospitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class HospitalService implements IHospitalServices {
    private final HospitalRepository _hospitalRepository;
    private ModelMapper modelMapper;

    public HospitalService(HospitalRepository hospitalRepository) {
        _hospitalRepository = hospitalRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public HospitalDTO getHospitalById(UUID id) {
        var patient = _hospitalRepository.findById(id);
        return patient.map(HospitalMapper::hospitalToHospitalDto).orElse(null);
    }

    @Override
    public HospitalDTO saveHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = modelMapper.map(hospitalDTO, Hospital.class);
        hospital = _hospitalRepository.save(hospital);
        hospitalDTO.setId(hospital.getId());
        return hospitalDTO;
    }

    @Override
    public HospitalDTO updateHospital(HospitalDTO hospitalDTO) {
        var uuid = hospitalDTO.getId();
        Hospital hospital = _hospitalRepository.getOne(uuid);

        hospital.setName(hospitalDTO.getName());

        hospital.setUpdatedBy(hospitalDTO.getUpdatedBy());
        hospital.setUpdatedTime(hospitalDTO.getUpdatedTime());
        hospital.setUpdatedBy(hospitalDTO.getUpdatedBy());

        hospital = _hospitalRepository.save(hospital);

        return HospitalMapper.hospitalToHospitalDto(hospital);
    }

    @Override
    public void delete(UUID id) {
        Hospital hospital = _hospitalRepository.getOne(id);
        _hospitalRepository.delete(hospital);
    }

    @Override
    public List<HospitalDTO> GetHospitalList() {


        var result = _hospitalRepository.findAll();
        return
                result.stream()
                        .map(source -> modelMapper.map(source, HospitalDTO.class))
                        .collect(Collectors.toList());
    }
}
