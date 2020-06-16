package com.hospital.admin.services;

import com.hospital.admin.model.DoctorDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Override
    public DoctorDTO GetDoctorById(UUID id) {
        return DoctorDTO.builder().id(id)
                .name("John").lastName("Martinez").build();
    }
}
