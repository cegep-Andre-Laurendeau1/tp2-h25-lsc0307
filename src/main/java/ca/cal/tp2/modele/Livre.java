package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("livre")
public class Livre extends Document {
    private String ISBN;
    private String editeur;
    private String auteur;
    private int nbJoursEmpruntGratuitement = 21;

    public Livre(String titre, LocalDate dateParution, int nombreExemplaires, String ISBN, String editeur, String auteur) {
        super(titre, dateParution, nombreExemplaires);
        this.ISBN = ISBN;
        this.editeur = editeur;
        this.auteur = auteur;
    }

    public Livre() {
        super();
    }

    public String getEditeur() {
        return editeur;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return nbJoursEmpruntGratuitement;
    }

}