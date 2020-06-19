package com.hospital.admin.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Patient extends Audit {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name = "id")
    private UUID id;

    private String Name;
    private String LastName;

    private Timestamp BirthDate;
    private String Address;
    private String Photo;

    @ManyToMany(mappedBy = "patients")
    private Set<Doctor> doctors = new HashSet<>();

    public Patient(String name) {
        this.Name = name;
    }
}


