package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.DVD;
import java.time.LocalDate;

public record DvdDTO(int id, String titre, LocalDate dateParution, int nombreExemplaires, String director, int rating, int duree) {
    public static DvdDTO toDto(DVD dvd) {
        return new DvdDTO(dvd.getId(), dvd.getTitre(), dvd.getDateParution(), dvd.getNbExemplaires(), dvd.getDirector(), dvd.getRating(), dvd.getDuree());
    }
}