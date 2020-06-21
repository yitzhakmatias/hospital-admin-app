package com.hospital.admin.services;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.HospitalDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.SpecialityDTO;

import java.util.List;
import java.util.UUID;

public interface IHospitalServices {
    HospitalDTO getHospitalById(UUID id);
    HospitalDTO saveHospital(HospitalDTO hospitalDTO);
    HospitalDTO updateHospital(HospitalDTO hospitalDTO);
    void delete(UUID id);
    List<HospitalDTO> GetHospitalList();
    List<DoctorDTO> GetDoctorsByHospitalId(UUID uuid);
    List<SpecialityDTO> GetSpecialitiesByHospitalId(UUID id);

    List<PatientDTO> GetPatientsByHospitalId(UUID id);
}
