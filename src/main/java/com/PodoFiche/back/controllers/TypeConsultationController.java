package com.podofiche.back.controllers;

import com.podofiche.back.bo.TypeConsultation;
import com.podofiche.back.repository.TypeConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/typeconsultations")
public class TypeConsultationController {

    private final TypeConsultationRepository typeConsultationRepository;

    @Autowired
    public TypeConsultationController(TypeConsultationRepository typeConsultationRepository) {
        this.typeConsultationRepository = typeConsultationRepository;
    }

    @GetMapping
    public List<TypeConsultation> getAllTypeConsultations() {
        return typeConsultationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeConsultation> getTypeConsultationById(@PathVariable Long id) {
        return typeConsultationRepository.findById(id)
                .map(typeConsultation -> ResponseEntity.ok().body(typeConsultation))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeConsultation createTypeConsultation(@RequestBody TypeConsultation typeConsultation) {
        return typeConsultationRepository.save(typeConsultation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeConsultation> updateTypeConsultation(@PathVariable Long id, @RequestBody TypeConsultation typeConsultationDetails) {
        return typeConsultationRepository.findById(id)
                .map(typeConsultation -> {
                    typeConsultation.setLibelleConsultation(typeConsultationDetails.getLibelleConsultation());
                    typeConsultation.setTemplate(typeConsultationDetails.getTemplate());
                    TypeConsultation updatedTypeConsultation = typeConsultationRepository.save(typeConsultation);
                    return ResponseEntity.ok().body(updatedTypeConsultation);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTypeConsultation(@PathVariable Long id) {
        return typeConsultationRepository.findById(id)
                .map(typeConsultation -> {
                    typeConsultationRepository.delete(typeConsultation);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

