package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.PrescriptionDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PrescriptionController {
    ResponseEntity<PrescriptionDto> createPrescription(PrescriptionDto prescriptionDto);

    ResponseEntity<List<PrescriptionDto>> getAllPrescriptions();

    ResponseEntity<PrescriptionDto> getPrescription(long id);

    ResponseEntity<PrescriptionDto> updatePrescription(PrescriptionDto prescriptionDto, long id);

    ResponseEntity<String> deletePrescription(long id);
    
}
