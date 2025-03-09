package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.DVD;
import java.time.LocalDate;

public record DvdDTO(long id, String titre, LocalDate dateParution, int nbExemplaires, String director, int rating, int duree) implements DocumentDTO {
    public static DvdDTO toDto(DVD dvd) {
        return new DvdDTO(dvd.getId(), dvd.getTitre(), dvd.getDateParution(), dvd.getNbExemplaires(), dvd.getDirector(), dvd.getRating(), dvd.getDuree());
    }
    @Override
    public String toString() {
        return String.format("%s - %d min - %s - Rating: %d - Nombre d'exemplaires : %d",
                titre, duree, director, rating, nbExemplaires);
    }
}