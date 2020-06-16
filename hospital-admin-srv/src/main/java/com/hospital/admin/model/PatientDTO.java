package com.hospital.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    @Null
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private Date birthDate;
    @NotBlank
    private String Address;
    private String Photo;

}
