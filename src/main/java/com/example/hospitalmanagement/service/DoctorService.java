package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    List<DoctorDto> getAllDoctors();

    DoctorDto getDoctor(long id);

    DoctorDto updateDoctor(DoctorDto doctorDto, long id);

    void deleteDoctor(long id);
}
