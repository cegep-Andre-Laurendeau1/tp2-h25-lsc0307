package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Livre;

import java.time.LocalDate;

public record LivreDTO(long id,String auteur,String titre, String ISBN, String editeur, LocalDate dateParution, int nbExemplaires) implements DocumentDTO {

    public static LivreDTO toDto(Livre livre)  {
        return new LivreDTO(livre.getId(),livre.getAuteur(),livre.getTitre(), livre.getISBN(), livre.getEditeur(), livre.getDateParution(), livre.getNbExemplaires());
    }
}