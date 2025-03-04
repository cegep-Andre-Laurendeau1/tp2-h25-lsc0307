package ca.cal.tp2.modele;

import jakarta.persistence.Entity;

@Entity
public class Emprunteur extends Utilisateur{
    public Emprunteur(String nom, String email, String numeroTelephone) {
        super( nom, email, numeroTelephone);
    }
    protected Emprunteur() {
        super();
    }
}
