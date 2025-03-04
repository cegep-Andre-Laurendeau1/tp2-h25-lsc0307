package ca.cal.tp2.modele;


public abstract class Utilisateur {
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
