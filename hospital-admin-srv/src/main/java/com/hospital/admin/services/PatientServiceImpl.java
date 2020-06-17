package com.hospital.admin.services;

import com.hospital.admin.domain.Patient;
import com.hospital.admin.mappers.PatientMapper;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.repositories.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements IPatientService {
    private final PatientRepository _patientRepository;
    private ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository) {
        _patientRepository = patientRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public PatientDTO GetPatientById(UUID id) {
        var patient = _patientRepository.findById(id);
        return patient.map(PatientMapper::patientToPatientDto).orElse(null);
    }

    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patient = modelMapper.map(patientDTO, Patient.class);
        patient = _patientRepository.save(patient);
        patientDTO.setId(patient.getId());
        return patientDTO;
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO) {
        var uuid = patientDTO.getId();
        Patient patient = _patientRepository.getOne(uuid);

        patient.setName(patientDTO.getName());
        patient.setAddress(patientDTO.getAddress());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setLastName(patientDTO.getLastName());
        patient.setUpdatedBy(patientDTO.getUpdatedBy());
        patient.setUpdatedTime(patientDTO.getUpdatedTime());

        patient = _patientRepository.save(patient);

        return PatientMapper.patientToPatientDto(patient);
    }

    @Override
    public void delete(UUID id) {
        Patient patient = _patientRepository.getOne(id);
        _patientRepository.delete(patient);
    }

    @Override
    public List<PatientDTO> GetPatientList() {


        var result = _patientRepository.findAll();
        return
                result
                        .stream()
                        .map(source -> modelMapper.map(source, PatientDTO.class))
                        .collect(Collectors.toList());
    }
}
