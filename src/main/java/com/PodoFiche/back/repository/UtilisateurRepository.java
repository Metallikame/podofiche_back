package com.podofiche.back.repository;

import com.podofiche.back.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByIdentifiant(String identifiant);
}
