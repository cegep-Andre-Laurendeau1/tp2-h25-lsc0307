package ca.cal.tp2.modele;

import java.time.LocalDate;
import java.util.Date;

public class CD extends Document {

    public CD(String nom, LocalDate dateParution, int nbExemplaires) {
        super(nom, dateParution, nbExemplaires);
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return 14;
    }
}