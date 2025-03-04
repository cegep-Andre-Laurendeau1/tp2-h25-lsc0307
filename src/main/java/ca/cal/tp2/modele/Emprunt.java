package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int borrowID;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;

    private LocalDate dateEmprunt;
    private String status;

    public Emprunt(Emprunteur emprunteur, LocalDate dateEmprunt, String status) {
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
    }

    protected Emprunt() {}

    // Getters et Setters
}