package ca.cal.tp2.service.dto;


import ca.cal.tp2.modele.CD;

import java.time.LocalDate;

public record CdDTO(long id, String titre, LocalDate dateParution, int nbExemplaires,String artiste, String genre, int duree ) implements DocumentDTO {
    public static CdDTO toDto(CD cd) {
        return new CdDTO(cd.getId(),cd.getTitre(), cd.getDateParution(),cd.getNbExemplaires(),cd.getArtiste(), cd.getGenre(), cd.getDuree());
    }
    @Override
    public String toString() {
        return String.format("%s - %d min - %s - %s - Nombre d'exemplaires : %d", titre, duree, genre, artiste, nbExemplaires);
    }
}

