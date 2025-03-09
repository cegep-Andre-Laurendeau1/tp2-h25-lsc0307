package ca.cal.tp2;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.EmpruntRepositoryJPA;
import ca.cal.tp2.repository.PreposeRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.service.dto.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();
        PreposeService preposeService = new PreposeService(new PreposeRepositoryJPA(), new DocumentRepositoryJPA());

        preposeService.saveEmprunteur(new Emprunteur("Leandro", "abc@gmail.com", "123456789"));

        preposeService.saveEmprunteur(new Emprunteur("Moi", "def@gmail.com", "123456789"));

        System.out.println(preposeService.findByNameAndEmail("Leandro","abc@gmail.com"));

        System.out.println(preposeService.findByNameAndEmail("Moi","def@gmail.com"));

        preposeService.saveDocument(new Livre(
                "Seigneur des anneaux",
                LocalDate.of(1954, 7, 29),
                2,
                "978-3-16-148410-0",
                "J.R.R",
                "Tolkien"

        ));

        preposeService.saveDocument(new Livre(
                "Le hobbit",
                LocalDate.of(1930, 7, 29),
                2,
                "978-3-16-123456-3",
                "J.R.R",
                "Tolkien"

        ));

        preposeService.saveDocument(new Livre(
                "Seigneur Jesus",
                LocalDate.of(0000, 1, 1),
                2,
                "328-2-16-165410-0",
                ":D",
                "Jules verne"

        ));

        preposeService.saveDocument(new CD(
                "The Dark Side of the Moon",
                LocalDate.of(1973, 3, 1),
                1,
                "Michael Jackson",
                50,
                "Classique"
        ));

        preposeService.saveDocument(new CD(
                "Thriller",
                LocalDate.of(1980, 3, 1),
                6,
                "Michael Jackson",
                2,
                "Pop"
        ));

        preposeService.saveDocument(new DVD(
                "The Dark Knight",
                LocalDate.of(2008, 7, 18),
                1,
                "Batman",
                90,
                45
        ));

        preposeService.saveDocument(new DVD(
                "The JOKER",
                LocalDate.of(2010, 7, 18),
                4,
                "Batman",
                90,
                60
        ));

        EmprunteurService emprunteurService = new EmprunteurService(new DocumentRepositoryJPA(), new PreposeRepositoryJPA(),new EmpruntRepositoryJPA());

        List<LivreDTO> livresTrouvesParTitre = emprunteurService.findLivresByTitre("SEIGNEUR");
        for (LivreDTO livreDTO : livresTrouvesParTitre) {
            System.out.println(livreDTO.titre() + " - " + livreDTO.auteur()+ " - " + livreDTO.editeur() + " - " + livreDTO.nbExemplaires());
        }

        List<LivreDTO> livresTrouvesParAuteur = emprunteurService.findLivresByAuteur("TOLKIEN");
        for (LivreDTO livreDTO : livresTrouvesParAuteur) {
            System.out.println(livreDTO.titre() + " - " + livreDTO.auteur()+ " - " + livreDTO.editeur() + " - " + livreDTO.nbExemplaires());
        }

        List<LivreDTO> livresTrouvesParAnnee = emprunteurService.findLivresByAnnee(1930);
        for (LivreDTO livreDTO : livresTrouvesParAnnee) {
            System.out.println(livreDTO.titre() + " - " + livreDTO.auteur()+ " - " + livreDTO.editeur() + " - " + livreDTO.nbExemplaires());
        }

        List<CdDTO> cdsTrouvesParTitre = emprunteurService.findCdsByTitre("DARK SIDE");
        for(CdDTO cdDTO : cdsTrouvesParTitre){
            System.out.println(cdDTO.titre() + " - " + cdDTO.duree() + " - " + cdDTO.genre() + " - " + cdDTO.artiste());
        }

        List<CdDTO> cdsTrouvesParArtiste = emprunteurService.findCdsByArtiste("Michael Jackson");
        for(CdDTO cdDTO : cdsTrouvesParArtiste){
            System.out.println(cdDTO.titre() + " - " + cdDTO.duree() + " - " + cdDTO.genre() + " - " + cdDTO.artiste());
        }

        List<DvdDTO> dvdsTrouvesParTitre = emprunteurService.findDvdsByTitre("Knight");
        for(DvdDTO dvdDTO : dvdsTrouvesParTitre){
            System.out.println(dvdDTO.titre() + " - " + dvdDTO.duree() + " - " + dvdDTO.director() + " - " + dvdDTO.dateParution() + " - " + dvdDTO.nbExemplaires() + " - " + dvdDTO.rating() );
        }

        List<DvdDTO> dvdsTrouvesParDirector = emprunteurService.findDvdsByDirector("batman");
        for(DvdDTO dvdDTO : dvdsTrouvesParDirector){
            System.out.println(dvdDTO.titre() + " - " + dvdDTO.duree() + " - " + dvdDTO.director() + " - " + dvdDTO.dateParution() + " - " + dvdDTO.nbExemplaires() + " - " + dvdDTO.rating() );
        }

        EmprunteurDTO emprunteur = preposeService.findByNameAndEmail("Leandro", "abc@gmail.com");
        DocumentDTO livreEmprunte1 = emprunteurService.findLivresByTitre("Seigneur des anneaux").get(0);
        DocumentDTO livreEmprunte3 = emprunteurService.findLivresByTitre("Seigneur des anneaux").get(0);
        DocumentDTO livreEmprunte4 = emprunteurService.findLivresByTitre("Seigneur des anneaux").get(0);
        DocumentDTO livreEmprunte5 = emprunteurService.findLivresByTitre("Seigneur des anneaux").get(0);
        DocumentDTO livreEmprunte2 = emprunteurService.findLivresByTitre("Le hobbit").get(0);
        DocumentDTO cdEmprunte1 = emprunteurService.findCdsByTitre("The Dark Side of the Moon").get(0);
        DocumentDTO cdEmprunte2 = emprunteurService.findCdsByTitre("The Dark Side of the Moon").get(0);
        DocumentDTO dvdEmprunte1 = emprunteurService.findDvdsByTitre("The Dark Knight").get(0);
        DocumentDTO dvdEmprunte2 = emprunteurService.findDvdsByTitre("The Dark Knight").get(0);
        emprunteurService.emprunteDocument(emprunteur.name(),emprunteur.email(), Arrays.asList(livreEmprunte1, livreEmprunte2, livreEmprunte3,livreEmprunte4,livreEmprunte5,cdEmprunte1,cdEmprunte2,dvdEmprunte1,dvdEmprunte2));

        EmprunteurDTO emprunteur1 = preposeService.findByNameAndEmail("Leandro", "abc@gmail.com");
        System.out.println(emprunteurService.afficherEmprunts(emprunteur1.id()));

        EmprunteurDTO emprunteur2 = preposeService.findByNameAndEmail("Moi", "def@gmail.com");
        System.out.println(emprunteurService.afficherEmprunts(emprunteur2.id()).toString());



        Thread.currentThread().join();
    }
}
