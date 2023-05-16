package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}
