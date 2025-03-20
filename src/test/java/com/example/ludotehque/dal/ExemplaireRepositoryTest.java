package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Exemplaire;
import com.example.ludotehque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExemplaireRepositoryTest {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Test
    @DisplayName("Creation d'un Exemplaire")
    public void testCreationJeu() {
        // Arrange
        Jeu jeu = new Jeu("Skyjo","REF-skyjo",6,"Super pour jour en famille",45,4.5f);
        Exemplaire exemplaire = new Exemplaire("codeBarre",true,jeu);
        long nbExemplaires = exemplaireRepository.count();

        // Act
        exemplaireRepository.save(exemplaire);

        // Assert
        assertNotNull(exemplaire.getNoExemplaire());
        assertEquals(exemplaireRepository.count(),nbExemplaires+1);
    }

    @Test
    @DisplayName("Recherche d'un Exemplaire par son identifiant")
    public void testFindByIdJeu() {
        // Arrange
        Integer idExemplaire = 1;

        // Act
        Optional<Exemplaire> exemplaireOpt = exemplaireRepository.findById(idExemplaire);

        // Assert
        assertNotNull(exemplaireOpt.isPresent());
        assertEquals(1, exemplaireOpt.get().getNoExemplaire());
    }
}
