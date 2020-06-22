package com.hospital.admin.bootstrap;

import com.hospital.admin.domain.Doctor;
import com.hospital.admin.domain.Note;
import com.hospital.admin.domain.Patient;
import com.hospital.admin.repositories.DoctorRepository;
import com.hospital.admin.repositories.PatientRepository;
import lombok.val;
import lombok.var;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.HashSet;

@Component
@Order(1)
public class DoctorLoader implements CommandLineRunner {
    private final DoctorRepository _doctorRepository;
    private final PatientRepository _patientRepository;

    public DoctorLoader(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        _doctorRepository = doctorRepository;
        _patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadDoctors();
    }

    private void loadDoctors() {

        val patient = Patient.builder()
                .Name("John")
                .LastName("Smith")
                .Address("123 Saint JJJJJ")
                .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                .build();
        _patientRepository.save(patient);

        if (_doctorRepository.count() == 0) {

            var doctor = Doctor.builder()
                    .Name("Peter")
                    .LastName("Slayer")

                    .build();

            val doctors = new HashSet<Doctor>();

            doctors.add(doctor);
            _doctorRepository.save(new Doctor("Peter" , "Jhones",
                    new Patient("John ","Smith",  new Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam finibus odio quis feugiat facilisis.", patient)),
                    new Patient("Aron ","Sandler", new Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna eros, eu pellentesque tortor vestibulum ut. Maecenas non massa sem. Etiam finibus odio quis feugiat facilisis.", patient))));
            ;
        }
    }
}
