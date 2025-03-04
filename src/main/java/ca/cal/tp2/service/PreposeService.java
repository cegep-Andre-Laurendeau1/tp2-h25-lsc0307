package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.PreposeRepository;

import java.util.Objects;

public class PreposeService implements PreposeRepository{
    private final PreposeRepository preposeRepository;

    public PreposeService(PreposeRepository preposeRepository){
        Objects.requireNonNull(preposeRepository);
        this.preposeRepository = preposeRepository;
    }


    @Override
    public void saveEmprunteur(Emprunteur emprunteur) {
        preposeRepository.saveEmprunteur(emprunteur);
    }
}
