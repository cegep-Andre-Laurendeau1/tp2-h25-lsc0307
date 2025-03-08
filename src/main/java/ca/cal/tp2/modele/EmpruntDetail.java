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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public LocalDate getDateRetourActuelle() {
        return dateRetourActuelle;
    }

   public Document getDocument(){
        return document;
   }
}