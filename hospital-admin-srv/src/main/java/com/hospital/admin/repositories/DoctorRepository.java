package com.hospital.admin.repositories;

import com.hospital.admin.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@RepositoryRestResource
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}
