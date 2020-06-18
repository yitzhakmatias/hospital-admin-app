package com.hospital.admin.mappers;

import com.hospital.admin.domain.Hospital;
import com.hospital.admin.model.HospitalDTO;
import org.modelmapper.ModelMapper;

public class HospitalMapper {
    public static HospitalDTO hospitalToHospitalDto(Hospital entity) {
        ModelMapper _modelMapper = new ModelMapper();
        return _modelMapper.map(entity, HospitalDTO.class);
    }

    public static Hospital hospitalDtoToHospital(HospitalDTO dto) {
        ModelMapper _modelMapper = new ModelMapper();
        return _modelMapper.map(dto, Hospital.class);
    }
}
