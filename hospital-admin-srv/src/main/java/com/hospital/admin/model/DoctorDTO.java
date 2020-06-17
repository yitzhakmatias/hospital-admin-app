package com.hospital.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDTO {
    @JsonProperty("DoctorId")
    @Null
    private UUID Id;
    @NotBlank
    private String Name;
    @NotBlank
    private String LastName;
    private Date BirthDate;
    @NotBlank
    private String Address;
    private String Photo;
}
