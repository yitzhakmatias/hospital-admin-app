package com.hospital.admin.bootstrap;

import com.hospital.admin.domain.Doctor;
import com.hospital.admin.domain.Hospital;
import com.hospital.admin.domain.Patient;
import com.hospital.admin.repositories.HospitalRepository;
import com.hospital.admin.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
@Component
@Order(2)
public class hospitalLoader implements CommandLineRunner {
    private final HospitalRepository _hospitalRepository;

    public hospitalLoader(HospitalRepository hospitalRepository) {
        _hospitalRepository = hospitalRepository;
    }

    @Override

    public void run(String... args) throws Exception {
        loadHospital();
    }

    private void loadHospital() {
        if (_hospitalRepository.count() == 0) {
            _hospitalRepository.save(Hospital.builder()
                    .Name("Hospital del Norte")
                    .CreatedTime(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );
            _hospitalRepository.save(Hospital.builder()
                    .Name("Hospital del Sur")
                    .CreatedTime(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );
            _hospitalRepository.save(Hospital.builder()
                    .Name("Hospital Japones")
                    .CreatedTime(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );

        }
        System.out.println("loader: "+ _hospitalRepository.count());
    }
}
