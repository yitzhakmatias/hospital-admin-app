package com.hospital.admin.services;

import com.hospital.admin.model.HospitalDTO;

import java.util.List;
import java.util.UUID;

public interface IHospitalServices {
    HospitalDTO getHospitalById(UUID id);
    HospitalDTO saveHospital(HospitalDTO hospitalDTO);
    HospitalDTO updateHospital(HospitalDTO hospitalDTO);
    void delete(UUID id);
    List<HospitalDTO> GetHospitalList();
}
