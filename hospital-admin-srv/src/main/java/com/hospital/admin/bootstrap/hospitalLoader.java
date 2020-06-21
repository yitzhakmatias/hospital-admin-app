package com.hospital.admin.bootstrap;

import com.hospital.admin.domain.*;
import com.hospital.admin.repositories.*;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@Order(2)
public class hospitalLoader implements CommandLineRunner {
    private final HospitalRepository _hospitalRepository;
    private final HospitalSpecialityRepository _hoHospitalSpecialityRepository;
    private final DoctorRepository _doctorRepository;
    private final SpecialityRepository specialityRepository;
    private final PatientRepository patientRepository;
    private final HospitalPatientRepository _hoHospitalPatientRepository;
    private final HospitalDoctorRepository hospitalDoctorRepository;

    public hospitalLoader(HospitalRepository hospitalRepository, HospitalSpecialityRepository hoHospitalSpecialityRepository, DoctorRepository doctorRepository, SpecialityRepository specialityRepository, PatientRepository patientRepository, HospitalPatientRepository hoHospitalPatientRepository, HospitalDoctorRepository hospitalDoctorRepository) {
        _hospitalRepository = hospitalRepository;
        _hoHospitalSpecialityRepository = hoHospitalSpecialityRepository;
        _doctorRepository = doctorRepository;
        this.specialityRepository = specialityRepository;
        this.patientRepository = patientRepository;
        _hoHospitalPatientRepository = hoHospitalPatientRepository;
        this.hospitalDoctorRepository = hospitalDoctorRepository;
    }

    @Override

    public void run(String... args) throws Exception {
        loadHospital();
    }

    private void loadHospital() {
        if (_hospitalRepository.count() == 0) {
            var hospital = _hospitalRepository.save(Hospital.builder()
                    .Name("Hospital del Norte")
                    .Photo("https://loremflickr.com/json/g/320/240/hospital")
                    .build()
            );
            var doctor = _doctorRepository.save(Doctor.builder()
                    .Name("Peter")
                    .LastName("Slayer")
                    .build());
            var doctor2 = _doctorRepository.save(Doctor.builder()
                    .Name("Sean")
                    .LastName("Golber")
                    .build());

            hospitalDoctorRepository.save(HospitalDoctor.builder()
                    .DoctorId(doctor.getId())
                    .HospitalId(hospital.getId())
                    .build());
            hospitalDoctorRepository.save(HospitalDoctor.builder()
                    .DoctorId(doctor2.getId())
                    .HospitalId(hospital.getId())
                    .build());

            var speciality = specialityRepository.save(Speciality.builder()
                    .Name("Obstetricia")
                    .Description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin ornare magna")
                    .Photo("https://loremflickr.com/json/g/320/240/hospital")
                    .build()
            );
            _hoHospitalSpecialityRepository.save(HospitalSpeciality.builder()
                    .HospitalId(hospital.getId())
                    .SpecialityId(speciality.getId())
                    .build());
            val patient = patientRepository.save(Patient.builder()

                    .Name("John")
                    .LastName("Smith")
                    .Address("123 Saint Paul")

                    .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );

            _hoHospitalPatientRepository.save(HospitalPatient.builder()
                    .HospitalId(hospital.getId())
                    .PatientId(patient.getId())
                    .build());
            val patient2 = patientRepository.save(Patient.builder()

                    .Name("Milton")
                    .LastName("Freedman")
                    .Address("4444 Saint Paul")
                    .BirthDate(Timestamp.valueOf("2007-09-23 10:10:10.0"))
                    .build()
            );

            _hoHospitalPatientRepository.save(HospitalPatient.builder()
                    .HospitalId(hospital.getId())
                    .PatientId(patient2.getId())
                    .build());
            _hospitalRepository.save(Hospital.builder()
                    .Name("Hospital del Sur")
                    .Photo("https://loremflickr.com/json/g/320/240/hospital")
                    .build()
            );
            _hospitalRepository.save(Hospital.builder()
                    .Name("Hospital Japones")
                    .Photo("https://loremflickr.com/json/g/320/240/hospital")
                    .build()
            );

        }
        System.out.println("loader: " + _hospitalRepository.count());
    }
}
