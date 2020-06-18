package com.hospital.admin.repositories;

import com.hospital.admin.domain.Hospital;
import com.hospital.admin.domain.Note;
import com.hospital.admin.domain.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@RepositoryRestResource
@Repository
public interface NoteRepository  extends JpaRepository<Note, UUID> {
    Page<Patient> findByPatientId(UUID patientId, Pageable pageable);

    Optional<Patient> findByIdAndPatientId(UUID id, UUID patientId);
}
