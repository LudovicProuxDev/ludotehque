package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Genre;
import com.example.ludotehque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JeuRepositoryTest {

    @Autowired
    private JeuRepository jeuRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("Creation d'un Jeu")
    public void testCreationJeu() {
        // Arrange
        Optional<Genre> genreUn = genreRepository.findById(1);
        Optional<Genre> genreDeux = genreRepository.findById(2);
        Jeu jeu = new Jeu("Skyjo","REF-skyjo",6,"Super pour jour en famille",45,4.5f);
        jeu.addGenre(genreUn.get());
        jeu.addGenre(genreDeux.get());
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

    @Test
    @DisplayName("Modification d'un Jeu - cas positif")
    public void testModificationJeu() {
        // Arrange
        Optional<Jeu> jeuOpt = jeuRepository.findById(3);
        int nbGenresJeu = jeuOpt.get().getGenres().size();
        Optional<Genre> genreToRemove = genreRepository.findById(4);
        Optional<Genre> genreToAdd = genreRepository.findById(1);
        jeuOpt.get().setTitre("Cluedo");
        jeuOpt.get().setReference("REF-cluedo");
        jeuOpt.get().setAgeMin(8);
        jeuOpt.get().setDescription("Découvrir le suspect");
        jeuOpt.get().setDuree(60);
        jeuOpt.get().setTarifJour(5.6f);
        jeuOpt.get().removeGenre(genreToRemove.get());
        jeuOpt.get().addGenre(genreToAdd.get());

        // Act
        jeuRepository.save(jeuOpt.get());

        // Assert
        assertThat(jeuOpt.isPresent()).isTrue();
        assertEquals("Cluedo", jeuOpt.get().getTitre());
        assertEquals("REF-cluedo", jeuOpt.get().getReference());
        assertEquals(8, jeuOpt.get().getAgeMin());
        assertEquals("Découvrir le suspect", jeuOpt.get().getDescription());
        assertEquals(60, jeuOpt.get().getDuree());
        assertEquals(5.6f, jeuOpt.get().getTarifJour());
        assertEquals(nbGenresJeu,jeuOpt.get().getGenres().size());
    }
}
