package com.hospital.admin.controller;

import com.hospital.admin.model.DoctorDTO;
import com.hospital.admin.model.HospitalDTO;
import com.hospital.admin.model.PatientDTO;
import com.hospital.admin.model.SpecialityDTO;
import com.hospital.admin.services.IHospitalServices;
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
@RequestMapping("/api/v1/hospital")
@RestController
public class HospitalController {
    private final IHospitalServices hospitalServices;

    public HospitalController(IHospitalServices patientService) {
        this.hospitalServices = patientService;
    }

    @GetMapping({"/{hospitalId}"})
    public ResponseEntity<HospitalDTO> GetById(@PathVariable("hospitalId") UUID id) {
        var patient = hospitalServices.getHospitalById(id);
        if (patient != null)
            return new ResponseEntity<>(patient, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalDTO> createHospital(@Valid @RequestBody HospitalDTO hospitalDTO) {
        return new ResponseEntity<>(hospitalServices.saveHospital(hospitalDTO), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")// POST -create a new Patient
    public ResponseEntity updatePatient(@PathVariable("id") UUID id, @Valid @RequestBody HospitalDTO hospitalDTO) {
        log.debug("handle post...");
        hospitalDTO.setId(id);
        val saveDto = hospitalServices.updateHospital(hospitalDTO);
        var headers = new HttpHeaders();
        headers.add("Location", "/api/v1/patient/" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")// POST -create a new Patient
    public ResponseEntity delete(@PathVariable(value = "id") UUID uuid) {
        log.debug("Delete patient...");
        hospitalServices.delete(uuid);
        var headers = new HttpHeaders();
        headers.add("Location", "/api/v1/patient/" + uuid);
        return new ResponseEntity(headers, HttpStatus.OK);
    }

    @GetMapping("collections")
    public List<HospitalDTO> ListPatients() {

        return hospitalServices.GetHospitalList();

    }

    @GetMapping("/doctors/{id}")
    public List<DoctorDTO> DoctorListByHospitalId(@PathVariable("id") UUID id) {

        return hospitalServices.GetDoctorsByHospitalId(id);

    }

    @GetMapping("/specialities/{id}")
    public List<SpecialityDTO> SpecialityListByHospitalId(@PathVariable("id") UUID id) {

        return hospitalServices.GetSpecialitiesByHospitalId(id);

    }
    @GetMapping("/patients/{id}")
    public List<PatientDTO> PatientListByHospitalId(@PathVariable("id") UUID id) {

        return hospitalServices.GetPatientsByHospitalId(id);

    }
}
