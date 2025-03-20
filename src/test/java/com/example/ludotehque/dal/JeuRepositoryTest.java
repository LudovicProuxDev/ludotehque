package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Genre;
import com.example.ludotehque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;

    @Test
    @DisplayName("Creation d'un Jeu")
    public void testCreationJeu() {
        // Arrange
        Genre genreUn = new Genre("Genre1");
        Genre genreDeux = new Genre("Genre2");
        Jeu jeu = new Jeu("Skyjo","REF-skyjo",6,"Super pour jour en famille",45,4.5f);
        jeu.addGenre(genreUn);
        jeu.addGenre(genreDeux);
        long nbJeux = jeuRepository.count();

        // Act
        jeuRepository.save(jeu);

        // Assert
        assertNotNull(jeu.getNoJeu());
        assertEquals(jeuRepository.count(),nbJeux+1);
    }

    @Test
    @DisplayName("Recherche d'un Jeu par son identifiant")
    public void testFindByIdJeu() {
        // Arrange
        Integer idJeu = 1;

        // Act
        Optional<Jeu> jeuOpt = jeuRepository.findById(idJeu);

        // Assert
        assertNotNull(jeuOpt.isPresent());
        assertEquals(1, jeuOpt.get().getNoJeu());
    }
}
