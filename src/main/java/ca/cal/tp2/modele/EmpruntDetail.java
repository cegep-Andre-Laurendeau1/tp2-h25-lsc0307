package ca.cal.tp2.modele;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "emprunt_id")
    private Emprunt emprunt;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Document document;

    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;

    public EmpruntDetail(Emprunt emprunt, Document document, LocalDate dateRetourPrevue, String status) {
        this.emprunt = emprunt;
        this.document = document;
        this.dateRetourPrevue = dateRetourPrevue;
        this.status = status;
        this.dateRetourActuelle = null;
    }

    public EmpruntDetail() {

    }

   public Document getDocument(){
        return document;
   }
}