package com.hospital.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialityDTO {
    @JsonProperty("Id")
    @Null
    private UUID Id;
    @NotBlank
    private String Name;
    private String Description;
    private UUID hospitalId;
}
