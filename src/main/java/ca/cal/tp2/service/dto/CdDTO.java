package ca.cal.tp2.service.dto;


import ca.cal.tp2.modele.CD;

public record CdDTO(int id,String titre, String artiste, String genre,int duree ) {
    public static CdDTO toDto(CD cd) {
        return new CdDTO(cd.getId(),cd.getTitre(),cd.getArtiste(), cd.getGenre(), cd.getDuree());
    }
}

