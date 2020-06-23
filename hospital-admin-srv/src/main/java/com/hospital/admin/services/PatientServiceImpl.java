package com.hospital.admin.services;

import com.hospital.admin.domain.HospitalPatient;
import com.hospital.admin.domain.Note;
import com.hospital.admin.domain.Patient;
import com.hospital.admin.mappers.PatientMapper;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.PatientNoteDTO;
import com.hospital.admin.repositories.DoctorRepository;
import com.hospital.admin.repositories.HospitalPatientRepository;
import com.hospital.admin.repositories.NoteRepository;
import com.hospital.admin.repositories.PatientRepository;
import lombok.var;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements IPatientService {
    private final PatientRepository _patientRepository;
    private final DoctorRepository _doctorRepository;
    private final NoteRepository _noteNoteRepository;
    private final HospitalPatientRepository _hospitalPatientRepository;
    private ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository, NoteRepository noteNoteRepository, HospitalPatientRepository hospitalPatientRepository) {
        _patientRepository = patientRepository;
        _doctorRepository = doctorRepository;
        _noteNoteRepository = noteNoteRepository;
        _hospitalPatientRepository = hospitalPatientRepository;
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
        _hospitalPatientRepository.save(new HospitalPatient(patientDTO.getHospitalId(), patient.getId()));
        return patientDTO;
    }

    @Override
    public PatientNoteDTO saveNotePatient(PatientNoteDTO patientDTO) {

        var patient = _patientRepository.findById(patientDTO.getPatientId()).get();
        var doctor = _doctorRepository.findById(patientDTO.getDoctorId()).get();
        var note = new Note(patientDTO.getNote(), patient);
        _noteNoteRepository.save(note);
        var patients = new HashSet<Patient>();
        patients.add(patient);
        doctor.setPatients(patients);
        _doctorRepository.save(doctor);
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
