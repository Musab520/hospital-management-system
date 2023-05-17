package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto doctorDto);

    List<PatientDto> getAllPatients();

    PatientDto getPatient(long id);

    PatientDto updatePatient(PatientDto patientDto, long id);

    void deletePatient(long id);
}
