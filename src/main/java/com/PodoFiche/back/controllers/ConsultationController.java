package com.podofiche.back.controllers;

import com.podofiche.back.bo.Consultation;
import com.podofiche.back.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/consultations")
public class ConsultationController {

    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationController(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @GetMapping
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultation> getConsultationById(@PathVariable Long id) {
        return consultationRepository.findById(id)
                .map(consultation -> ResponseEntity.ok().body(consultation))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultation> updateConsultation(@PathVariable Long id, @RequestBody Consultation consultationDetails) {
        return consultationRepository.findById(id)
                .map(consultation -> {
                    consultation.setDateConsultation(consultationDetails.getDateConsultation());
                    consultation.setMotif(consultationDetails.getMotif());
                    consultation.setCompteRendu(consultationDetails.getCompteRendu());
                    Consultation updatedConsultation = consultationRepository.save(consultation);
                    return ResponseEntity.ok().body(updatedConsultation);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConsultation(@PathVariable Long id) {
        return consultationRepository.findById(id)
                .map(consultation -> {
                    consultationRepository.delete(consultation);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


