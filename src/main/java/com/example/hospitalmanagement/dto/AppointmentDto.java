package com.example.hospitalmanagement.dto;


import com.example.hospitalmanagement.entity.Doctor;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.Prescription;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private String title;
    private String symptoms;
    private String diagnosis;
    private Date date;
    private Doctor doctor;
    private Patient patient;
    private Prescription prescription;
}
