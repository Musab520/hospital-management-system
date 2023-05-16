package com.example.hospitalmanagement.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String gender;
    private String address;
    private double weight;
    private double height;
    private int phoneNumber;
    private Date birthDate;
    private String maritalStatus;
    private String bloodType;
}
