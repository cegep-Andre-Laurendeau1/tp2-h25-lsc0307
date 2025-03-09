package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;

import java.util.List;

public interface EmpruntRepository {
    void save(Emprunt emprunt);
    List<Object[]> findEmpruntsByEmprunteurId(long id);
}
