package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPRUNTEUR",uniqueConstraints = {@UniqueConstraint(columnNames = {"nom", "email"})})
public class Emprunteur extends Utilisateur{

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunts = new ArrayList<>();

    public Emprunteur(String nom, String email, String numeroTelephone) {
        super( nom, email, numeroTelephone);
    }
    protected Emprunteur() {
        super();
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }
}
