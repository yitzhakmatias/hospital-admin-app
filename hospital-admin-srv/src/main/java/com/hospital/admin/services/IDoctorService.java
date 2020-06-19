package com.hospital.admin.services;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.PatientDTO;

import java.util.List;
import java.util.UUID;

public interface IDoctorService {
    DoctorDTO GetDoctorById(UUID id);

    DoctorDTO saveDoctor(DoctorDTO patientDTO);

    DoctorDTO updateDoctor(UUID uuid, DoctorDTO doctorDTO);

    List<DoctorDTO> GetDoctorList();
}
