package web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    private UUID id;
    private String name;
    private String lastName;
    private Date birthDate;
    private String Address;
    private String Photo;

}
