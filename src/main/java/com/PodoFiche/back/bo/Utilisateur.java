package com.PodoFiche.back.bo;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long utilisateurId;

    private String identifiant;
    private String motDePasse;

    // Relations
    @OneToMany(mappedBy = "utilisateur")
    private List<Journal> journaux;

    @OneToMany(mappedBy = "utilisateur")
    private List<Consultation> consultations;

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    // Getters et Setters

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<Journal> getJournaux() {
        return journaux;
    }

    public void setJournaux(List<Journal> journaux) {
        this.journaux = journaux;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}

