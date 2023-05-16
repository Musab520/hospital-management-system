package com.example.hospitalmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private String name;
    private String specialty;
    private int phoneNumber;
    private String email;
    private String clinicalAddress;
}
