package com.example.hospitalmanagement.service.impl;

import com.example.hospitalmanagement.dto.PrescriptionDto;
import com.example.hospitalmanagement.entity.Prescription;
import com.example.hospitalmanagement.repository.PrescriptionRepository;
import com.example.hospitalmanagement.service.PrescriptionService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository, ModelMapper modelMapper) {
        this.prescriptionRepository = prescriptionRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public PrescriptionDto createPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = modelMapper.map(prescriptionDto, Prescription.class);
        Prescription newPrescription = prescriptionRepository.save(prescription);
        return modelMapper.map(newPrescription,PrescriptionDto.class);
    }

    @Override
    public List<PrescriptionDto> getAllPrescriptions() {
        List<Prescription> prescriptionList = prescriptionRepository.findAll();
        return prescriptionList.stream()
                .map(prescription -> modelMapper.map(prescription, PrescriptionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrescriptionDto getPrescription(long id) {
        if (prescriptionRepository.findById(id).isPresent()) {
            Prescription prescription = prescriptionRepository.findById(id).get();
            return modelMapper.map(prescription , PrescriptionDto.class);
        }
        return null;
    }

    @Override
    public PrescriptionDto updatePrescription(@Valid @RequestBody PrescriptionDto prescriptionDto, long id) {
        if (prescriptionRepository.findById(id).isPresent()) {
            Prescription prescription = prescriptionRepository.findById(id).get();
            modelMapper.map(prescriptionDto , prescription);
            Prescription updatedPrescription = prescriptionRepository.save(prescription);
            return modelMapper.map(updatedPrescription, PrescriptionDto.class);
        }
        return null;
    }

    @Override
    public void deletePrescription(long id) {
        if (prescriptionRepository.findById(id).isPresent()) {
            Prescription prescription = prescriptionRepository.findById(id).get();
            prescriptionRepository.delete(prescription);
        }
    }
}
