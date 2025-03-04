package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunteur;


public interface PreposeRepository {
    void save(Emprunteur emprunteur);

    Emprunteur getEmprunteur(int id);
}
