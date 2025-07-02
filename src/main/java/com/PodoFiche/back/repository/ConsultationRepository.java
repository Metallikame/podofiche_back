package com.PodoFiche.back.repository;

import com.PodoFiche.back.bo.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    // Trouver toutes les consultations pour un patient donné
    List<Consultation> findByPatient_PatientId(Long patientId);

    // Trouver toutes les consultations par un utilisateur donné
    List<Consultation> findByUtilisateur_UtilisateurId(Long utilisateurId);

    // Trouver toutes les consultations après une date spécifique
    List<Consultation> findByDateConsultationAfter(LocalDateTime date);
}
