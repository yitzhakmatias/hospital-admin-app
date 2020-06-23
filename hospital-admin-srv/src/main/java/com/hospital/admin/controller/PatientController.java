package com.hospital.admin.controller;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.PatientNoteDTO;
import com.hospital.admin.services.IDoctorService;
import com.hospital.admin.services.IPatientService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/patient")
@RestController
public class PatientController {

    private final IPatientService patientService;
    private final IDoctorService doctorService;

    public PatientController(IPatientService patientService, IDoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping({"/{patientId}"})
    public ResponseEntity<PatientDTO> GetById(@PathVariable("patientId") UUID id) {
        var patient = patientService.GetPatientById(id);
        if (patient != null)
            return new ResponseEntity<>(patient, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<PatientDTO> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        return new ResponseEntity<>(patientService.savePatient(patientDTO), HttpStatus.ACCEPTED);
    }
    @PostMapping("/addnote")
    public ResponseEntity<PatientNoteDTO> addNoteToPatient(@Valid @RequestBody PatientNoteDTO patientDTO) {
        return new ResponseEntity<>(patientService.saveNotePatient(patientDTO), HttpStatus.ACCEPTED);
    }

    @PutMapping("/update/{id}")// POST -create a new Patient
    public ResponseEntity updatePatient(@PathVariable("id") UUID id, @Valid @RequestBody PatientDTO patientDTO) {
        log.debug("handle post...");
        patientDTO.setId(id);
        val saveDto = patientService.updatePatient(patientDTO);
        var headers = new HttpHeaders();
        headers.add("Location", "/api/v1/patient/" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")// POST -create a new Patient
    public ResponseEntity deletePatient(@PathVariable(value = "id") UUID uuid) {
        log.debug("Delete patient...");
        patientService.delete(uuid);
        var headers = new HttpHeaders();
        headers.add("Location", "/api/v1/patient/" + uuid);
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @GetMapping("collections")
    List<PatientDTO> ListPatients() {

        return patientService.GetPatientList();

    }


}
