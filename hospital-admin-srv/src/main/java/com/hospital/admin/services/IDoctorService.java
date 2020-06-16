package com.hospital.admin.services;

import com.hospital.admin.model.DoctorDTO;

import java.util.UUID;

public interface IDoctorService {
    DoctorDTO GetDoctorById(UUID id);
}
