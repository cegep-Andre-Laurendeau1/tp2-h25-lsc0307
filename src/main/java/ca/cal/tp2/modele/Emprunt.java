package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;

    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmpruntDetail> empruntDetails = new HashSet<>();


    public Emprunt(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
        this.dateEmprunt = LocalDate.now();
        this.status = "À temps";
    }

    public Set<EmpruntDetail> getEmpruntDetails() {
        return empruntDetails;
    }

    protected Emprunt() {}

    public void addEmpruntDetail(Document document) {
        LocalDate dateRetourPrevue = LocalDate.now().plusDays(document.getDureeEmpruntEnJours());
        EmpruntDetail detail = new EmpruntDetail(this, document, dateRetourPrevue, status);
        empruntDetails.add(detail);
    }

}