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
public class HospitalSpeciality {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;
    
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false)
    public UUID HospitalId;
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false)
    public UUID SpecialityId;
    public HospitalSpeciality(UUID HospitalId,UUID SpecialityId){
        this.HospitalId=HospitalId;
        this.SpecialityId=SpecialityId;
    }
}
