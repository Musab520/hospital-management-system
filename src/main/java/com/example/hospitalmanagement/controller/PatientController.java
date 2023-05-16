package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.PatientDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientController {
    ResponseEntity<PatientDto> createPatient(PatientDto patientDto);

    ResponseEntity<List<PatientDto>> getAllPatients();

    ResponseEntity<PatientDto> getPatient(long id);

    ResponseEntity<PatientDto> updatePatient(PatientDto patientDto, long id);

    ResponseEntity<String> deletePatient(long id);
}
