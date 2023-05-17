package com.example.hospitalmanagement.controller.impl;

import com.example.hospitalmanagement.controller.AppointmentController;
import com.example.hospitalmanagement.dto.AppointmentDto;
import com.example.hospitalmanagement.dto.DoctorDto;
import com.example.hospitalmanagement.dto.PatientDto;
import com.example.hospitalmanagement.dto.PrescriptionDto;
import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.Prescription;
import com.example.hospitalmanagement.service.AppointmentService;
import com.example.hospitalmanagement.service.DoctorService;
import com.example.hospitalmanagement.service.PatientService;
import com.example.hospitalmanagement.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/appointment")
@Component
public class AppointmentControllerImpl implements AppointmentController {
    private final AppointmentService appointmentService;
    @Autowired
    public AppointmentControllerImpl(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping
    @Override
    public ResponseEntity<AppointmentDto> createAppointment(@Valid @RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<>(appointmentService.createAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments() {
        return ResponseEntity.ok().body(appointmentService.getAllAppointments());
    }
    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AppointmentDto> getAppointment(@PathVariable long id) {
        return ResponseEntity.ok().body(appointmentService.getAppointment(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@Valid @RequestBody AppointmentDto appointmentDto, @PathVariable long id) {
        return ResponseEntity.ok().body(appointmentService.updateAppointment(appointmentDto, id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<>("Deleted successfully.", HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}/doctor")
    public ResponseEntity<Doctor> getDoctorByAppointmentId(@PathVariable long id) {
        AppointmentDto appointmentDto = appointmentService.getAppointment(id);
        return ResponseEntity.ok().body(appointmentDto.getDoctor());
    }

    @Override
    @GetMapping("/{id}/patient")
    public ResponseEntity<Patient> getPatientByAppointmentId(@PathVariable long id) {
        AppointmentDto appointmentDto = appointmentService.getAppointment(id);
        return ResponseEntity.ok().body(appointmentDto.getPatient());
    }

    @Override
    @GetMapping("/{id}/prescription")
    public ResponseEntity<Prescription> getPrescriptionByAppointmentId(@PathVariable long id) {
        AppointmentDto appointmentDto = appointmentService.getAppointment(id);
        return ResponseEntity.ok().body(appointmentDto.getPrescription());
    }

}
