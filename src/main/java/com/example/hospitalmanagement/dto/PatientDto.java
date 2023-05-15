package com.example.hospitalmanagement.dto;

import com.example.hospitalmanagement.enums.BloodType;
import com.example.hospitalmanagement.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private String name;
    private String gender;
    private String address;
    private double weight;
    private double height;
    private int phoneNumber;
    private Date birthDate;
    private MaritalStatus maritalStatus;
    private BloodType bloodType;
}
