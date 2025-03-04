package ca.cal.tp2.modele;

import java.time.LocalDate;
import java.util.Date;

public class Amende {
    private long id;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    public Amende(long id, double montant, LocalDate dateCreation, boolean status) {
        this.id = id;
        this.montant = montant;
        this.dateCreation = dateCreation;
        this.status = status;
    }

}