package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.PreposeRepository;
import ca.cal.tp2.service.dto.EmprunteurDTO;

import java.util.Objects;

public class PreposeService {
    private final PreposeRepository preposeRepository;
    private final DocumentRepository documentRepository;

    public PreposeService(PreposeRepository preposeRepository, DocumentRepository documentRepository) {
        Objects.requireNonNull(preposeRepository);
        this.preposeRepository = preposeRepository;
        this.documentRepository = documentRepository;
    }

    public void saveEmprunteur(Emprunteur emprunteur) {
        preposeRepository.saveEmprunteur(emprunteur);
    }

    public void saveDocument(Document document) {
        documentRepository.saveDocument(document);
    }

    public EmprunteurDTO findByNameAndEmail(String nom, String email) {
        Emprunteur emprunteur = preposeRepository.findByNameAndEmail(nom, email);
        return EmprunteurDTO.toDto(emprunteur);

    }


}
