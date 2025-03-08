package ca.cal.tp2.service;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.EmpruntRepository;
import ca.cal.tp2.repository.PreposeRepository;
import ca.cal.tp2.repository.PreposeRepositoryJPA;
import ca.cal.tp2.service.dto.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class EmprunteurService {
    private final DocumentRepository documentRepository;
    private final PreposeRepository preposeRepository;
    private final EmpruntRepository empruntRepository;

    public EmprunteurService(DocumentRepository documentRepository, PreposeRepository preposeRepository, EmpruntRepository empruntRepository) {
        Objects.requireNonNull(documentRepository);
        this.documentRepository = documentRepository;
        this.preposeRepository = preposeRepository;
        this.empruntRepository = empruntRepository;
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

    public List<DvdDTO> findDvdsByTitre(String titre) {
        List<DVD> dvds = documentRepository.findDvdsByTitre(titre);
        List<DvdDTO> dvdsDTO = new ArrayList<>();

        for (DVD dvd : dvds) {
            DvdDTO dvdDTO = DvdDTO.toDto(dvd);
            dvdsDTO.add(dvdDTO);
        }

        return dvdsDTO;

    }

    public List<DvdDTO> findDvdsByDirector(String director){
        List<DVD> dvds = documentRepository.findDvdsByDirector(director);
        List<DvdDTO> dvdsDTO = new ArrayList<>();

        for (DVD dvd : dvds) {
            DvdDTO dvdDTO = DvdDTO.toDto(dvd);
            dvdsDTO.add(dvdDTO);
        }

        return dvdsDTO;
    }

    public void emprunteDocument(String nomEmprunteur,String emailEmprunteur, List<DocumentDTO> documents){
        Emprunteur emprunteur = preposeRepository.findByNameAndEmail(nomEmprunteur,emailEmprunteur);
        Emprunt emprunt = new Emprunt(emprunteur);
        if(emprunteur == null){
            System.out.println("Emprunteur non existant!");
            return;
        }
        for(DocumentDTO document : documents){
            Document documentTrouve;

            if(document instanceof LivreDTO){
                documentTrouve = documentRepository.findLivresByTitre(document.titre()).get(0);
            }
            else if(document instanceof CdDTO){
                documentTrouve = documentRepository.findCdsByTitre(document.titre()).get(0);
            }
            else if(document instanceof DvdDTO){
                documentTrouve = documentRepository.findDvdsByTitre(document.titre()).get(0);
            } else {
                documentTrouve = null;
            }
            if(documentTrouve == null){
                System.out.println("Document " + document.titre() + " non existant!");
                return;
            }

            long count =  emprunt.getEmpruntDetails().stream()
                    .filter(detail -> detail.getDocument().getId() == documentTrouve.getId())
                    .count();

            if(count >= documentTrouve.getNbExemplaires()){
                System.out.println("Document " + document.titre() + " non disponible!");
            }
            else{
                emprunt.addEmpruntDetail(documentTrouve);
            }

        }
        empruntRepository.save(emprunt);

    }

}
