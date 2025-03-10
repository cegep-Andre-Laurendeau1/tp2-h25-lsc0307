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
    private int duree;


    public DVD(String titre,LocalDate dateParution, int nombreExemplaires, String director, int rating,int duree) {
        super(titre, dateParution, nombreExemplaires);
        this.director = director;
        this.rating = rating;
        this.duree = duree;
    }

    public DVD() {
        super();
    }

    public int getDuree() {
        return duree;
    }

    public int getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return nbJoursEmpruntGratuitement;
    }

}