package com.podofiche.back.repository;

import com.podofiche.back.bo.TypeConsultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeConsultationRepository extends JpaRepository<TypeConsultation, Long> {
    // Trouver un type de consultation par libellé
    TypeConsultation findByLibelleConsultation(String libelleConsultation);
}
