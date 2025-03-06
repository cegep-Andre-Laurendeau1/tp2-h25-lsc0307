package ca.cal.tp2.repository;

import ca.cal.tp2.modele.*;
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
            query.setParameter("titre", "%" + titre + "%");
            return query.getResultList();
        }
    }

    @Override
    public List<Livre> findLivresByAuteur(String auteur) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Livre> query = entityManager.createQuery(
                    "SELECT l FROM Livre l WHERE LOWER(l.auteur) = LOWER(:auteur)", Livre.class);
            query.setParameter("auteur", auteur);
            return query.getResultList();
        }
    }

    @Override
    public List<Livre> findLivresByAnnee(int annee) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Livre> query = entityManager.createQuery(
                    "SELECT l FROM Livre l WHERE YEAR(l.dateParution) = :annee", Livre.class);
            query.setParameter("annee", annee);
            return query.getResultList();
        }
    }

    @Override
    public List<CD> findCdsByTitre(String titre) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<CD> query = entityManager.createQuery(
                    "SELECT c FROM CD c WHERE LOWER(c.titre) LIKE LOWER(:titre)", CD.class);
            query.setParameter("titre", "%" + titre + "%");
            return query.getResultList();
        }
    }

    @Override
    public List<CD> findCdsByArtiste(String artiste){
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<CD> query = entityManager.createQuery(
                    "SELECT c FROM CD c WHERE LOWER(c.artiste) = LOWER(:artiste)", CD.class);
            query.setParameter("artiste", artiste);
            return query.getResultList();
        }
    }

    @Override
    public List<DVD> findDvdsByTitre(String titre) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<DVD> query = entityManager.createQuery(
                    "SELECT d FROM DVD d WHERE LOWER(d.titre) LIKE LOWER(:titre)", DVD.class);
            query.setParameter("titre", "%" + titre + "%");
            return query.getResultList();
        }
    }
}
