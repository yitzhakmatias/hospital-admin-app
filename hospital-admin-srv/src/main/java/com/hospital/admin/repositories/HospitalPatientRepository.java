package com.hospital.admin.repositories;

import com.hospital.admin.domain.HospitalDoctor;
import com.hospital.admin.domain.HospitalPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@RepositoryRestResource
@Repository
public interface HospitalPatientRepository extends JpaRepository<HospitalPatient, UUID> {
}
