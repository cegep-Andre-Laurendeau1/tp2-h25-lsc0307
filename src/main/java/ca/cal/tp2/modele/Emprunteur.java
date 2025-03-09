package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "EMPRUNTEUR",uniqueConstraints = {@UniqueConstraint(columnNames = {"nom", "email"})})
public class Emprunteur extends Utilisateur{

    @OneToMany(mappedBy = "emprunteur", cascade = CascadeType.PERSIST)
    private Set<Emprunt> emprunts = new HashSet<>();

    public Emprunteur(String nom, String email, String numeroTelephone) {
        super( nom, email, numeroTelephone);
    }
    protected Emprunteur() {
        super();
    }

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }

    @Override
    public String toString() {
        return "Emprunteur{" +
                "nom='" + getNom() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", numéro de téléphone='" + getNumeroTelephone() + '\'' +
                '}';
    }
}
