package ca.cal.tp2.modele;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"nom"})})
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected String titre;
    protected LocalDate dateParution;
    protected int nbExemplaires;

    public Document(String titre, LocalDate dateParution, int nbExemplaires) {
        this.titre = titre;
        this.dateParution = dateParution;
        this.nbExemplaires = nbExemplaires;
    }

    public Document() {
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getDateParution() {
        return dateParution;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public abstract int getDureeEmpruntEnJours();
}