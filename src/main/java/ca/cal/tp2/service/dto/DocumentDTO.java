package ca.cal.tp2.service.dto;

import java.time.LocalDate;

public interface DocumentDTO {
    long id();
    String titre();
    LocalDate dateParution();
    int nbExemplaires();
}
