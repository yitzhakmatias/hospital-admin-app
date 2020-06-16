package com.hospital.admin.controller;

import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.services.IPatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/patient")
@RestController
public class PatientController {

    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping({"/{patientId}"})
    public ResponseEntity<PatientDTO> GetById(@PathVariable("patientId") UUID id) {
        return new ResponseEntity<>(patientService.GetPatientById(id), HttpStatus.OK);
    }
}
