package com.hospital.admin.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class HospitalDoctor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false)
    public UUID HospitalId;
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false)
    public UUID DoctorId;

    public HospitalDoctor(UUID hospitalId, UUID id) {
        this.HospitalId = hospitalId;
        this.DoctorId = id;
    }
}
