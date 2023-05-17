package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.dto.PrescriptionDto;
import com.example.hospitalmanagement.entity.Prescription;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDto);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointment(long id);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto, long id);

    void deleteAppointment(long id);

}
