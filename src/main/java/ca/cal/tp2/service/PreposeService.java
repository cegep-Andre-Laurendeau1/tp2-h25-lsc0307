package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.PreposeRepository;
import ca.cal.tp2.service.dto.EmprunteurDTO;

import java.util.Objects;

public class PreposeService {
    private final PreposeRepository preposeRepository;

    public PreposeService(PreposeRepository preposeRepository){
        Objects.requireNonNull(preposeRepository);
        this.preposeRepository = preposeRepository;
    }

    public void saveEmprunteur(Emprunteur emprunteur) {
        preposeRepository.saveEmprunteur(emprunteur);
    }

    public EmprunteurDTO findByNameAndEmail(String nom, String email) {
        Emprunteur emprunteur = preposeRepository.findByNameAndEmail(nom, email);
        return EmprunteurDTO.toDto(emprunteur);

    }


}
