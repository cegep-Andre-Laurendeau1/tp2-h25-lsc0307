package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunteur;


public interface PreposeRepository {
    void saveEmprunteur(Emprunteur emprunteur);

    Emprunteur findByNameAndEmail(String name, String email);
}
