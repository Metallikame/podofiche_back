package com.PodoFiche.back.repository;

import com.PodoFiche.back.bo.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByIdentifiant(String identifiant);
}
