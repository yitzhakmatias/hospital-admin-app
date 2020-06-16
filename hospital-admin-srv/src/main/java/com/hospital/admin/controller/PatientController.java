package com.hospital.admin.controller;

import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.services.IPatientService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
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

    @PostMapping // POST -create a new Patient
    public ResponseEntity handlePost(@Valid @RequestBody PatientDTO patientDTO) {
        log.debug("handle post...");
        val saveDto = patientService.savePatient(patientDTO);
        var headers = new HttpHeaders();
        headers.add("Location", "/api/v1/patient/" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
