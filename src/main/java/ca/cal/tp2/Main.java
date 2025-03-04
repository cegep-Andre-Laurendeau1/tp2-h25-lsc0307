package ca.cal.tp2;

import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.modele.Prepose;
import ca.cal.tp2.repository.PreposeRepositoryJPA;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        // Votre script qui utilise votre API ici
        TcpServer.startTcpServer();
        PreposeService preposeService = new PreposeService(new PreposeRepositoryJPA());

        preposeService.saveEmprunteur(new Emprunteur("Leandro", "abc@gmail.com", "123456789"));

        preposeService.saveEmprunteur(new Emprunteur("Moi", "def@gmail.com", "123456789"));

        System.out.println(preposeService.findByNameAndEmail("Leandro","abc@gmail.com"));

        System.out.println(preposeService.findByNameAndEmail("Moi","def@gmail.com"));

        Thread.currentThread().join();
    }
}
