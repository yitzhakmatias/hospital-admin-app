package com.hospital.admin.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Doctor extends Audit {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    private String Name;
    private String LastName;

    private Timestamp BirthDate;
    private String Address;
    private String Photo;


    private String CreatedBy;
    private String UpdatedBy;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "doctor_patient",
            joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"))
    private Set<Patient> patients;

    public Doctor(String name, String lastName, Patient... patients) {
        this.Name = name;
        this.setLastName(lastName);
        this.patients = Stream.of(patients).collect(Collectors.toSet());

    }
}
