package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.PreposeRepository;
import ca.cal.tp2.service.dto.CdDTO;
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
            LivreDTO livreDTO = LivreDTO.toDto(livre);
            livresDTO.add(livreDTO);
        }

        return livresDTO;

    }

    public List<LivreDTO> findLivresByAuteur(String auteur) {
        List<Livre> livres = documentRepository.findLivresByAuteur(auteur);
        List<LivreDTO> livresDTO = new ArrayList<>();

        for (Livre livre : livres) {
            LivreDTO livreDTO = LivreDTO.toDto(livre);
            livresDTO.add(livreDTO);
        }

        return livresDTO;

    }

    public List<LivreDTO> findLivresByAnnee(int annee) {
        List<Livre> livres = documentRepository.findLivresByAnnee(annee);
        List<LivreDTO> livresDTO = new ArrayList<>();

        for (Livre livre : livres) {
            LivreDTO livreDTO = LivreDTO.toDto(livre);
            livresDTO.add(livreDTO);
        }

        return livresDTO;

    }

    public List<CdDTO> findCdsByTitre(String titre) {
        List<CD> cds = documentRepository.findCdsByTitre(titre);
        List<CdDTO> cdsDTO = new ArrayList<>();

        for (CD cd : cds) {
            CdDTO cdDTO = CdDTO.toDto(cd);
            cdsDTO.add(cdDTO);
        }

        return cdsDTO;

    }

    public List<CdDTO> findCdsByArtiste(String artiste){
        List<CD> cds = documentRepository.findCdsByArtiste(artiste);
        List<CdDTO> cdsDTO = new ArrayList<>();

        for (CD cd : cds) {
            CdDTO cdDTO = CdDTO.toDto(cd);
            cdsDTO.add(cdDTO);
        }

        return cdsDTO;
    }
}
