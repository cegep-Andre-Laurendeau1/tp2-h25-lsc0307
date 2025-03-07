package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "emprunteur_id")
    private Emprunteur emprunteur;

    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpruntDetail> empruntDetails = new ArrayList<>();


    public Emprunt(Emprunteur emprunteur, LocalDate dateEmprunt, String status) {
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.status = status;
    }

    protected Emprunt() {}

    public void addEmpruntDetail(Document document) {
        LocalDate dateRetourPrevue = LocalDate.now().plusDays(document.getDureeEmpruntEnJours());
        EmpruntDetail detail = new EmpruntDetail(this, document, dateRetourPrevue, "Emprunté");
        empruntDetails.add(detail);
    }

}