package ca.cal.tp2.modele;

import java.time.LocalDate;
import java.util.Date;

public class Livre extends Document {
    public Livre(String nom, LocalDate dateParution, int nbExemplaires) {
        super(nom, dateParution, nbExemplaires);
    }

    @Override
    public int getDureeEmpruntEnJours() {
        return 21;
    }
}
