package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmpruntRepositoryJPA implements EmpruntRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("biblio.pu");

    @Override
    public void save(Emprunt emprunt){
        try(EntityManager entityManager = entityManagerFactory.createEntityManager()){
            entityManager.getTransaction().begin();
            entityManager.persist(emprunt);
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public List<Object[]> findEmpruntsByEmprunteurId(long emprunteurId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            TypedQuery<Object[]> query = entityManager.createQuery(
                    "SELECT emp.id, emp.nom, emp.numeroTelephone, e.dateEmprunt, ed.dateRetourPrevue, d.titre AS document_nom " +
                            "FROM Emprunteur emp " +
                            "LEFT JOIN Emprunt e ON emp.id = e.emprunteur.id " +
                            "LEFT JOIN EmpruntDetail ed ON e.id = ed.emprunt.id " +
                            "LEFT JOIN Document d ON ed.document.id = d.id " +
                            "WHERE emp.id = :emprunteurId", Object[].class);
            query.setParameter("emprunteurId", emprunteurId);
            return query.getResultList();
        }
    }

}
