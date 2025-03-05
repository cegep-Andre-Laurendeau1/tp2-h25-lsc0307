package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("livre")
public class Livre extends Document {
    private String ISBN;
    private String editeur;
    private int nbJoursEmpruntGratuitement = 21;

    public Livre(String nom, LocalDate dateParution, int nombreExemplaires, String ISBN, String editeur) {
        super(nom, dateParution, nombreExemplaires);
        this.ISBN = ISBN;
        this.editeur = editeur;
    }

    public Livre() {
        super();
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return nbJoursEmpruntGratuitement;
    }

}