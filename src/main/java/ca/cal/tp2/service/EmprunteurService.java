package ca.cal.tp2.service;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.PreposeRepository;
import ca.cal.tp2.service.dto.EmprunteurDTO;
import ca.cal.tp2.service.dto.LivreDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmprunteurService {
    private final DocumentRepository documentRepository;

    public EmprunteurService(DocumentRepository documentRepository) {
        Objects.requireNonNull(documentRepository);
        this.documentRepository = documentRepository;
    }

    public List<LivreDTO> findLivresByTitre(String titre) {
        List<Livre> livres = documentRepository.findLivresByTitre(titre);
        List<LivreDTO> livresDTO = new ArrayList<>();

        for (Livre livre : livres) {
            LivreDTO livreDTO = LivreDTO.toDto(livre); // Convertir chaque livre
            livresDTO.add(livreDTO); // Ajouter à la liste des DTO
        }

        return livresDTO;

    }
}
