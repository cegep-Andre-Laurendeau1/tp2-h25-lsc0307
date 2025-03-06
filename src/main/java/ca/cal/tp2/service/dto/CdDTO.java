package ca.cal.tp2.service.dto;


import ca.cal.tp2.modele.CD;

import java.time.LocalDate;

public record CdDTO(int id, String titre, LocalDate dateParution, int nbExemplaires,String artiste, String genre, int duree ) {
    public static CdDTO toDto(CD cd) {
        return new CdDTO(cd.getId(),cd.getTitre(), cd.getDateParution(),cd.getNbExemplaires(),cd.getArtiste(), cd.getGenre(), cd.getDuree());
    }
}

