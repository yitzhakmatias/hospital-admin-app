package com.hospital.admin.mappers;

import com.hospital.admin.domain.Patient;
import com.hospital.admin.model.PatientDTO;

import org.modelmapper.ModelMapper;


public class PatientMapper {

    public static PatientDTO patientToPatientDto(Patient entity) {
        ModelMapper _modelMapper = new ModelMapper();
        return _modelMapper.map(entity, PatientDTO.class);
    }

    public static Patient patientDtoToPatient(PatientDTO dto) {
        ModelMapper _modelMapper = new ModelMapper();
        return _modelMapper.map(dto, Patient.class);
    }


}
