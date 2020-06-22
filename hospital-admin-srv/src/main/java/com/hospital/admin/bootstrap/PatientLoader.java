package com.hospital.admin.bootstrap;

import com.hospital.admin.domain.Doctor;
import com.hospital.admin.domain.Note;
import com.hospital.admin.domain.Patient;
import com.hospital.admin.repositories.DoctorRepository;
import com.hospital.admin.repositories.NoteRepository;
import com.hospital.admin.repositories.PatientRepository;
import lombok.val;
import lombok.var;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashSet;

@Component
@Order(3)
public class PatientLoader implements CommandLineRunner {

    private final PatientRepository _patientRepository;
    private final NoteRepository _noteNoteRepository;
    private final DoctorRepository _doctorRepository;

    public PatientLoader(PatientRepository patientRepository, NoteRepository noteNoteRepository, DoctorRepository doctorRepository) {
        _patientRepository = patientRepository;

        _noteNoteRepository = noteNoteRepository;
        _doctorRepository = doctorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadPatient();
    }

    private void loadPatient() {

        if (_patientRepository.count() > 0) {

            val doctors = new HashSet<Doctor>();

            var doctor = _doctorRepository.save(Doctor.builder()
                    .Name("Peter")
                    .LastName("Slayer")
                    .build());

            doctors.add(doctor);


            val patient = _patientRepository.save(Patient.builder()

                    .Name("John")
                    .LastName("Smith")
                    .Address("123 Saint Paul")

                    .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );

            _noteNoteRepository.save(Note.builder().Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit").patient(patient).build());

            _patientRepository.save(Patient.builder()

                    .Name("Lucy")
                    .LastName("Johns")
                    .Address("123 Saint Paul")

                    .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );
            _noteNoteRepository.save(Note.builder().Note("Proin ornare magna eros, eu pellentesque tortor vestibulum ut. Maecenas non massa ")
                    .patient(patient)
                    .build());
        }
        System.out.println("loader: " + _patientRepository.count());
    }
}
