package com.hospital.admin.services;

import com.hospital.admin.model.PatientDTO;

import java.util.UUID;

public interface IPatientService {
    PatientDTO GetPatientById(UUID id);
}
