package com.PodoFiche.back.bo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class TypeConsultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeConsultationId;

    private String libelleConsultation;
    private String template;

    @OneToMany(mappedBy = "typeConsultation")
    private List<Consultation> consultations;

    // Getters et Setters

    public Long getTypeConsultationId() {
        return typeConsultationId;
    }

    public void setTypeConsultationId(Long typeConsultationId) {
        this.typeConsultationId = typeConsultationId;
    }

    public String getLibelleConsultation() {
        return libelleConsultation;
    }

    public void setLibelleConsultation(String libelleConsultation) {
        this.libelleConsultation = libelleConsultation;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }
}

