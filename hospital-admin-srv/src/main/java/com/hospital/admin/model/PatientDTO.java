package com.hospital.admin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    @JsonProperty("PatientId")
    @Null
    private UUID Id;
    @NotBlank
    private String Name;
    @NotBlank
    private String LastName;
    @NotBlank
    private Timestamp BirthDate;
    @NotBlank
    private String Address;
    private String Photo;


    private Timestamp CreatedTime;
    private Timestamp UpdatedTime;
    private String CreatedBy;
    private String UpdatedBy;

    private List<NoteDTO> Notes;

    private UUID hospitalId;


}
