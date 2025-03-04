package ca.cal.tp2.modele;

import java.time.LocalDate;
import java.util.Date;

public class DVD extends Document {

    public DVD(String nom, LocalDate dateParution, int nbExemplaires) {
        super(nom, dateParution, nbExemplaires);
    }
    @Override
    public int getDureeEmpruntEnJours() {
        return 7;
    }
}