package com.hospital.admin.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Doctor {
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
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp CreatedTime;
    @UpdateTimestamp
    private Timestamp UpdatedTime;
    private String CreatedBy;
    private String UpdatedBy;
}
