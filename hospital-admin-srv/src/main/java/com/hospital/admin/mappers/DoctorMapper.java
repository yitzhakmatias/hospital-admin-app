package com.hospital.admin.mappers;

import com.hospital.admin.domain.Doctor;
import com.hospital.admin.model.DoctorDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DoctorMapper {
    Doctor doctorDtoToDoctor(DoctorDTO dto);

    DoctorDTO doctorToDoctorDto(Doctor dto);
}
