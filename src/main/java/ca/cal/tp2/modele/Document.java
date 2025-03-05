package ca.cal.tp2.modele;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected String nom;
    protected LocalDate dateParution;
    protected int nbExemplaires;

    public Document(String nom, LocalDate dateParution, int nbExemplaires) {
        this.nom = nom;
        this.dateParution = dateParution;
        this.nbExemplaires = nbExemplaires;
    }

    public Document() {
    }


    public abstract int getDureeEmpruntEnJours();
}