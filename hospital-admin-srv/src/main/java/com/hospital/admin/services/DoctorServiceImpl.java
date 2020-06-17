package com.hospital.admin.services;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorServiceImpl implements IDoctorService {
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
}
