package com.podofiche.back.repository;

import com.podofiche.back.bo.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    // Trouver tous les journaux par un utilisateur spécifique
    List<Journal> findByUtilisateur_UtilisateurId(Long utilisateurId);

    // Trouver tous les journaux créés après une certaine date
    List<Journal> findByDateJournalAfter(LocalDateTime date);
}

