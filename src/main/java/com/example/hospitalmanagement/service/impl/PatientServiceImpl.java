package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private ModelMapper modelMapper;
    @Autowired
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
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());
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
