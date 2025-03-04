package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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


}
