package com.example.hospitalmanagement.controller.impl;

import com.example.hospitalmanagement.controller.PatientController;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/patient")
@Component
public class PatientControllerImpl implements PatientController {

    private PatientService patientService;
    @Autowired
    public PatientControllerImpl(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping
    @Override
    public ResponseEntity<PatientDto> createPatient(@Valid @RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(patientService.createPatient(patientDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients() {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @Override
    public ResponseEntity<PatientDto> getPatient(long id) {
        return null;
    }

    @Override
    public ResponseEntity<PatientDto> updatePatient(PatientDto patientDto, long id) {
        return null;
    }

    @Override
    public ResponseEntity<String> deletePatient(long id) {
        return null;
    }
}
