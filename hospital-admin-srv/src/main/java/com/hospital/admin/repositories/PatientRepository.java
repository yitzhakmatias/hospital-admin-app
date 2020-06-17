package com.hospital.admin.repositories;

import com.hospital.admin.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.UUID;

@RepositoryRestResource
@Repository
public interface PatientRepository  extends JpaRepository<Patient, UUID> {

}
