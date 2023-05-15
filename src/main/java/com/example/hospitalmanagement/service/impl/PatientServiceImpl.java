package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepository patientRepository, ModelMapper modelMapper) {
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient newPatient = patientRepository.save(patient);
        return modelMapper.map(newPatient,PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        return null;
    }

    @Override
    public PatientDto getPatient(long id) {
        return null;
    }

    @Override
    public PatientDto updatePatient(PatientDto patientDto, long id) {
        return null;
    }

    @Override
    public void deletePatient(long id) {

    }
}
