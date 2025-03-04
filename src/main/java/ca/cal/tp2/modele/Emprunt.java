package ca.cal.tp2.modele;

import java.time.LocalDate;
import java.util.Date;

public class Emprunt {
    private long id;
    private LocalDate dateEmprunt;
    private String status;

    public Emprunt(long idEmprunt, LocalDate dateEmprunt, String status) {
        this.id = id;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
    }
}
