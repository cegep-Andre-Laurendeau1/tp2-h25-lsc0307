package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("cd")
public class CD extends Document {
    private String artiste;
    private int duree;
    private int nbJoursEmpruntGratuitement = 14;

    public CD(String nom, LocalDate dateParution, int nombreExemplaires, String artiste, int duree) {
        super(nom, dateParution, nombreExemplaires);
        this.artiste = artiste;
        this.duree = duree;
    }

    public CD() {
        super();
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return nbJoursEmpruntGratuitement;
    }

}