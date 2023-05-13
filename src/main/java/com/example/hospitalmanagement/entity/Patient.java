package com.example.hospitalmanagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GeneratedValue
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
