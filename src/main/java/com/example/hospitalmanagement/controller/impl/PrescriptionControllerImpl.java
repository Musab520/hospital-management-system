package com.example.hospitalmanagement.controller.impl;

import com.example.hospitalmanagement.controller.PrescriptionController;
import com.example.hospitalmanagement.dto.PrescriptionDto;
import com.example.hospitalmanagement.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescription")
@Component
public class PrescriptionControllerImpl implements PrescriptionController {
    private final PrescriptionService prescriptionService;
    @Autowired
    public PrescriptionControllerImpl(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    @PostMapping
    @Override
    public ResponseEntity<PrescriptionDto> createPrescription(@Valid @RequestBody PrescriptionDto prescriptionDto) {
        return new ResponseEntity<>(prescriptionService.createPrescription(prescriptionDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PrescriptionDto>> getAllPrescriptions() {
        return ResponseEntity.ok().body(prescriptionService.getAllPrescriptions());
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<PrescriptionDto> getPrescription(@PathVariable long id) {
        return ResponseEntity.ok().body(prescriptionService.getPrescription(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<PrescriptionDto> updatePrescription(@Valid @RequestBody PrescriptionDto prescriptionDto, @PathVariable long id) {
        return ResponseEntity.ok().body(prescriptionService.updatePrescription(prescriptionDto, id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable long id) {
        prescriptionService.deletePrescription(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
