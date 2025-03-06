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
    private String genre;

    public CD(String titre, LocalDate dateParution, int nombreExemplaires, String artiste, int duree,String genre) {
        super(titre, dateParution, nombreExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    public CD() {
        super();
    }

    public String getArtiste() {
        return artiste;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuree() {
        return duree;
    }


    @Override
    public int getDureeEmpruntEnJours() {
        return nbJoursEmpruntGratuitement;
    }

}