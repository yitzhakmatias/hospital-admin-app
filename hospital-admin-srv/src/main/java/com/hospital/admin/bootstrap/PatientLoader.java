package com.hospital.admin.bootstrap;

import com.hospital.admin.domain.Patient;
import com.hospital.admin.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component
public class PatientLoader implements CommandLineRunner {

    private final PatientRepository _patientRepository;

    public PatientLoader(PatientRepository patientRepository) {
        _patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadPatient();
    }

    private void loadPatient() {
        if (_patientRepository.count() == 0) {
            _patientRepository.save(Patient.builder()
                    .Name("John")
                    .LastName("Smith")
                    .Address("123 Saint Paul")
                    .CreatedTime(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );
            _patientRepository.save(Patient.builder()
                    .Name("Lucy")
                    .LastName("Johns")
                    .Address("123 Saint Paul")
                    .CreatedTime(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );

        }
        System.out.println("loader: "+ _patientRepository.count());
    }
}
