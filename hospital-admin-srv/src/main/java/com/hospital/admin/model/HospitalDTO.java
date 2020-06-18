package com.hospital.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
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
    private String CreatedBy;
    private String UpdatedBy;
    private Timestamp UpdatedTime;
}
