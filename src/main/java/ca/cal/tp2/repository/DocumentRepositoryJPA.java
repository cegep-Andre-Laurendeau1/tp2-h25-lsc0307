package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DocumentRepositoryJPA implements DocumentRepository {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio.pu");

    @Override
    public void saveDocument(Document document) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(document);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<Livre> findLivresByTitre(String titre) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Livre> query = entityManager.createQuery(
                    "SELECT l FROM Livre l WHERE LOWER(l.titre) LIKE LOWER(:titre)", Livre.class);
            query.setParameter("titre", "%" + titre + "%"); // Recherche partielle
            return query.getResultList(); // Renvoie la liste de livres trouvés
        }
    }
}
