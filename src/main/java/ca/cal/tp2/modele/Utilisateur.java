package ca.cal.tp2.modele;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nom;
    private String email;
    private String numeroTelephone;

    public Utilisateur (long id, String nom, String email, String numeroTelephone) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.numeroTelephone = numeroTelephone;
    }

    protected Utilisateur() {}

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }
}
