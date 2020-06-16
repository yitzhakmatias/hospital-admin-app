package com.hospital.admin.controller;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.services.IDoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/doctor")
@RestController
public class DoctorController {
    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping({"/{doctorId}"})
    public ResponseEntity<DoctorDTO> GetById(@PathVariable("doctorId") UUID id) {
        return new ResponseEntity<>(doctorService.GetDoctorById(id), HttpStatus.OK);
    }
}
