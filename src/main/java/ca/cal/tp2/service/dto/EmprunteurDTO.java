package ca.cal.tp2.service.dto;

import ca.cal.tp2.modele.Emprunteur;

public record EmprunteurDTO(long id, String name, String email) {
    public static EmprunteurDTO toDto(Emprunteur emprunteur) {
        return new EmprunteurDTO(emprunteur.getId(), emprunteur.getNom(), emprunteur.getEmail());
    }
}
