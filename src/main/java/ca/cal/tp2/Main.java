package ca.cal.tp2;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.PreposeRepositoryJPA;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;
import ca.cal.tp2.service.dto.LivreDTO;

import java.sql.SQLException;
import java.time.LocalDate;
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
                "978-3-16-148410-0",
                50
        ));
        preposeService.saveDocument(new DVD(
                "The Dark Knight",
                LocalDate.of(2008, 7, 18),
                1,
                "978-3-16-148410-0",
                90,
                45
        ));

        EmprunteurService emprunteurService = new EmprunteurService(new DocumentRepositoryJPA());

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
        Thread.currentThread().join();
    }
}
