package ca.cal.tp2.modele;

import jakarta.persistence.Entity;

@Entity
public class Prepose extends Utilisateur{

    public Prepose( String nom, String email, String numeroTelephone) {
        super(nom, email, numeroTelephone);
    }

    public Prepose() {

    }
}
