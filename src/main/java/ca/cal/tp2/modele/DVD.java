package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("dvd")
public class DVD extends Document {
    private String director;
    private int rating;
    private int nbJoursEmpruntGratuitement = 7;

    public DVD(String nom, LocalDate dateParution, int nombreExemplaires, String director, int rating) {
        super(nom, dateParution, nombreExemplaires);
        this.director = director;
        this.rating = rating;
    }

    public DVD() {
        super();
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return nbJoursEmpruntGratuitement;
    }

}