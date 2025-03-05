package ca.cal.tp2.modele;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String email;
    private String numeroTelephone;

    public Utilisateur ( String nom, String email, String numeroTelephone) {
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
