package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.dto.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {
    PrescriptionDto createPrescription(PrescriptionDto CategoryDto);

    List<PrescriptionDto> getAllPrescriptions();

    PrescriptionDto getPrescription(long id);

    PrescriptionDto updatePrescription(PrescriptionDto prescriptionDto, long id);

    void deletePrescription(long id);
}
