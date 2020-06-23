package com.hospital.admin.services;

import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.PatientNoteDTO;

import java.util.List;
import java.util.UUID;

public interface IPatientService {
    PatientDTO GetPatientById(UUID id);

    PatientDTO savePatient(PatientDTO patientDTO);
    PatientNoteDTO saveNotePatient(PatientNoteDTO patientDTO);

    List<PatientDTO> GetPatientList();

    PatientDTO updatePatient(PatientDTO patientDTO);

    void delete(UUID id);

}
