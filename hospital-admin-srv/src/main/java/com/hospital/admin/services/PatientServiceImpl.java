package com.hospital.admin.services;

import com.hospital.admin.model.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientServiceImpl implements IPatientService {
    @Override
    public PatientDTO GetPatientById(UUID id) {
        return PatientDTO.builder().id(id)
                .name("John").lastName("Martinez").build();
    }
}
