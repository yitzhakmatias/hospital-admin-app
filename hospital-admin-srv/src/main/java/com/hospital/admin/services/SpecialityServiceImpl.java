package com.hospital.admin.services;

import com.hospital.admin.domain.HospitalSpeciality;
import com.hospital.admin.domain.Speciality;
import com.hospital.admin.model.SpecialityDTO;
import com.hospital.admin.repositories.HospitalSpecialityRepository;
import com.hospital.admin.repositories.SpecialityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceImpl implements ISpecialityService {
    private final SpecialityRepository specialityRepository;
    private final HospitalSpecialityRepository hospitalSpecialityRepository;
    private ModelMapper modelMapper;

    public SpecialityServiceImpl(SpecialityRepository speciSpecialityRepository, HospitalSpecialityRepository hospitalSpecialityRepository) {
        specialityRepository = speciSpecialityRepository;
        this.hospitalSpecialityRepository = hospitalSpecialityRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public SpecialityDTO saveSpeciality(SpecialityDTO specialityDTO) {
        Speciality speciality = modelMapper.map(specialityDTO, Speciality.class);
        speciality = specialityRepository.save(speciality);
        specialityDTO.setId(speciality.getId());
        hospitalSpecialityRepository.save(new HospitalSpeciality(specialityDTO.getHospitalId(), speciality.getId()));
        return specialityDTO;
    }
}
