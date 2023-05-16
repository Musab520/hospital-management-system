package com.example.hospitalmanagement.controller.impl;

import com.example.hospitalmanagement.controller.DoctorController;
import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/doctor")
@Component
public class DoctorControllerImpl implements DoctorController {
    private final DoctorService doctorService;
    @Autowired
    public DoctorControllerImpl(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @PostMapping
    @Override
    public ResponseEntity<DoctorDto> createDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        return new ResponseEntity<>(doctorService.createDoctor(doctorDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        return ResponseEntity.ok().body(doctorService.getAllDoctors());
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable long id) {
        return ResponseEntity.ok().body(doctorService.getDoctor(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@Valid @RequestBody DoctorDto doctorDto, @PathVariable long id) {
        return ResponseEntity.ok().body(doctorService.updateDoctor(doctorDto, id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }
}
