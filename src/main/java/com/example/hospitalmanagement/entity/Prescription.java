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
public class Prescription {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String dosage;
    private String frequency;
    private Date startDate;
    private Date endDate;
}
