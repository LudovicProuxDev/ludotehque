package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Adresse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdresseRepositoryTest {

    @Autowired
    private AdresseRepository adresseRepository;

    @Test
    @DisplayName("Creation d'une Adresse")
    public void testCreationAdresse() {
        // Arrange
        Adresse adresse = new Adresse("Avenue Léo Lagrange","79000","NIORT");
        long nbAdresses = adresseRepository.count();

        // Act
        adresseRepository.save(adresse);

        // Assert
        assertNotNull(adresse.getNoAdresse());
        assertEquals(adresseRepository.count(),nbAdresses+1);
    }

    @Test
    @DisplayName("Recherche d'une Adresse par son identifiant")
    public void testFindByIdAdresse() {
        // Arrange
        Integer idAdresse = 1;

        // Act
        Optional<Adresse> adresseOpt = adresseRepository.findById(idAdresse);

        // Assert
        assertNotNull(adresseOpt.isPresent());
        assertEquals(1, adresseOpt.get().getNoAdresse());
    }
}
