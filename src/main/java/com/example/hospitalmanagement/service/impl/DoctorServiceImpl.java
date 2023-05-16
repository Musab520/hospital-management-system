package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.repository.DoctorRepository;
import com.example.hospitalmanagement.service.DoctorService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        Doctor newDoctor = doctorRepository.save(doctor);
        return modelMapper.map(newDoctor,DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctor(long id) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor doctor = doctorRepository.findById(id).get();
            return modelMapper.map(doctor , DoctorDto.class);
        }
        return null;
    }

    @Override
    public DoctorDto updateDoctor(@Valid @RequestBody DoctorDto doctorDto, long id) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor doctor = doctorRepository.findById(id).get();
            modelMapper.map(doctorDto , doctor);
            Doctor updatedDoctor = doctorRepository.save(doctor);
            return modelMapper.map(updatedDoctor, DoctorDto.class);
        }
        return null;
    }

    @Override
    public void deleteDoctor(long id) {
        if (doctorRepository.findById(id).isPresent()) {
            Doctor doctor = doctorRepository.findById(id).get();
            doctorRepository.delete(doctor);
        }
    }
}
