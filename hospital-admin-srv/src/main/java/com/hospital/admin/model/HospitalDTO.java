package com.hospital.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hospital.admin.domain.Doctor;
import com.hospital.admin.domain.Note;
import com.hospital.admin.domain.Patient;
import com.hospital.admin.domain.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalDTO {
    @JsonProperty("HospitalId")
    @Null
    private UUID Id;
    @NotBlank
    private String Name;
    private String Photo;
    private String CreatedBy;
    private String UpdatedBy;
    private Timestamp UpdatedTime;

    @Builder.Default
    private Set<Patient> Patients = new HashSet<>();
    @Builder.Default
    private Set<Doctor> Doctors = new HashSet<>();
    @Builder.Default
    private Set<Speciality> Specialities = new HashSet<>();
}
