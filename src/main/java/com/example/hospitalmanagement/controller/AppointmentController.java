package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.dto.PrescriptionDto;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.Prescription;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentController {
    ResponseEntity<AppointmentDto> createAppointment(AppointmentDto appointmentDto);

    ResponseEntity<AppointmentDto> getAppointment(long appointmentId);

    ResponseEntity<List<AppointmentDto>> getAllAppointments();

    ResponseEntity<AppointmentDto> updateAppointment(AppointmentDto appointmentDto, long id);

    ResponseEntity<String> deleteAppointment(long id);

    ResponseEntity<Doctor> getDoctorByAppointmentId(long doctorId);

    ResponseEntity<Patient> getPatientByAppointmentId(long patientId);

    ResponseEntity<Prescription> getPrescriptionByAppointmentId(long prescriptionId);
}
