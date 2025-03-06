package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Livre;

import java.util.List;

public interface DocumentRepository {
    void saveDocument(Document document);

    List<Livre> findLivresByTitre(String titre);

    List<Livre> findLivresByAuteur(String auteur);

    List<Livre> findLivresByAnnee(int annee);

}
