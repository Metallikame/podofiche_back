package com.PodoFiche.back.repository;

import com.PodoFiche.back.bo.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    // Trouver un patient par numéro de sécurité sociale
    Patient findByNumeroSecu(String numeroSecu);

    // Trouver tous les patients avec un nom donné
    List<Patient> findByNom(String nom);

    // Trouver tous les patients avec un prénom donné
    List<Patient> findByPrenom(String prenom);
}

