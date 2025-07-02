package com.PodoFiche.back.bo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long journalId;

    private LocalDateTime dateJournal;
    private String libelleJournal;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Getters et Setters

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public LocalDateTime getDateJournal() {
        return dateJournal;
    }

    public void setDateJournal(LocalDateTime dateJournal) {
        this.dateJournal = dateJournal;
    }

    public String getLibelleJournal() {
        return libelleJournal;
    }

    public void setLibelleJournal(String libelleJournal) {
        this.libelleJournal = libelleJournal;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}

