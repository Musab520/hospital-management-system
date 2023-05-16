package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.DoctorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorController {
    ResponseEntity<DoctorDto> createDoctor(DoctorDto doctorDto);

    ResponseEntity<List<DoctorDto>> getAllDoctors();

    ResponseEntity<DoctorDto> getDoctor(long id);

    ResponseEntity<DoctorDto> updateDoctor(DoctorDto doctorDto, long id);

    ResponseEntity<String> deleteDoctor(long id);
}
