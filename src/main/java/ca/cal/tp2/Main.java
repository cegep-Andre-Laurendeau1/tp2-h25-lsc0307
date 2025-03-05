package ca.cal.tp2;

import ca.cal.tp2.modele.*;
import ca.cal.tp2.repository.DocumentRepository;
import ca.cal.tp2.repository.DocumentRepositoryJPA;
import ca.cal.tp2.repository.PreposeRepositoryJPA;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;
import java.time.LocalDate;

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
                "Tolkien"
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
        Thread.currentThread().join();
    }
}
