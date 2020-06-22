package com.hospital.admin.controller;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.services.IDoctorService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RequestMapping("/api/v1/doctor")
@RestController
public class DoctorController {
    private final IDoctorService doctorService;

    public DoctorController(IDoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping({"/patients/{doctorId}"})
    public ResponseEntity<List<DoctorDTO>> GetPatientsByDoctorId(@PathVariable("doctorId") UUID id) {
        var lst = new ArrayList<DoctorDTO>();
        lst.add(doctorService.GetDoctorById(id));

        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping({"/{doctorId}"})
    public ResponseEntity<DoctorDTO> GetById(@PathVariable("doctorId") UUID id) {
        return new ResponseEntity<>(doctorService.GetDoctorById(id), HttpStatus.OK);
    }

    @PostMapping("/add")// POST -create a new Patient
    public ResponseEntity handlePost(@Valid @RequestBody DoctorDTO doctorDTO) {
        log.debug("handle post...");
        val saveDto = doctorService.saveDoctor(doctorDTO);
        var headers = new HttpHeaders();
        headers.add("Location", "/api/v1/doctor/" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{doctorId}")
    public ResponseEntity updateDoctor(@PathVariable("beerId") UUID uuid, @RequestBody @Validated DoctorDTO doctorDTO) {
        return new ResponseEntity<>(doctorService.updateDoctor(uuid, doctorDTO), HttpStatus.NO_CONTENT);
    }

    @GetMapping("collections")
    List<DoctorDTO> ListPatients() {

        return doctorService.GetDoctorList();

    }
}
