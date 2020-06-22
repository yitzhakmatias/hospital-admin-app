package com.hospital.admin.controller;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.HospitalDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.SpecialityDTO;
import com.hospital.admin.services.IHospitalServices;
import com.hospital.admin.services.ISpecialityService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RequestMapping("/api/v1/speciality")
@RestController
public class SpecialityController {
    private final ISpecialityService specialityServices;

    public SpecialityController(ISpecialityService specialityService) {
        this.specialityServices = specialityService;
    }

   /* @GetMapping({"/{hospitalId}"})
    public ResponseEntity<HospitalDTO> GetById(@PathVariable("hospitalId") UUID id) {
        var patient = specialityServices.getHospitalById(id);
        if (patient != null)
            return new ResponseEntity<>(patient, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }*/

    @PostMapping("/add")
    public ResponseEntity<SpecialityDTO> createSpeciality(@Valid @RequestBody SpecialityDTO specialityDTO) {
        return new ResponseEntity<>(specialityServices.saveSpeciality(specialityDTO), HttpStatus.OK);
    }



}
