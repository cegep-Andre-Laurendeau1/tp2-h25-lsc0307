package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class PreposeRepositoryJPA implements PreposeRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio.pu");

    @Override
    public void saveEmprunteur(Emprunteur emprunteur) {
       try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
           entityManager.getTransaction().begin();
           entityManager.persist(emprunteur);
           entityManager.getTransaction().commit();
       }
    }

    @Override
    public Emprunteur findByNameAndEmail(String nom, String email) {
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            TypedQuery<Emprunteur> query = entityManager.createQuery("SELECT e FROM Emprunteur e WHERE e.nom = :nom AND e.email = :email", Emprunteur.class);
            query.setParameter("nom", nom);
            query.setParameter("email", email);
            return query.getSingleResult();
        }
    }


}
