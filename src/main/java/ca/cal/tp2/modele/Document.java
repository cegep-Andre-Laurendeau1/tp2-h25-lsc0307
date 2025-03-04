package ca.cal.tp2.modele;


import java.time.LocalDate;

public abstract class Document {
    protected String nom;
    protected LocalDate dateParution;
    protected int nbExemplaires;

    public Document(String nom, LocalDate dateParution, int nbExemplaires) {
        this.nom = nom;
        this.dateParution = dateParution;
        this.nbExemplaires = nbExemplaires;
    }


    public abstract int getDureeEmpruntEnJours();
}