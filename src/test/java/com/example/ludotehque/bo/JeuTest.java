package com.example.ludotehque.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JeuTest {
    @Test
    @DisplayName("Création instance Jeu")
    public void test() {
        Genre genreUn = new Genre();
        genreUn.setNoGenre(1);
        genreUn.setLibelle("Genre1");
        Genre genreDeux = new Genre();
        genreDeux.setNoGenre(2);
        genreDeux.setLibelle("Genre2");

        Jeu jeu = new Jeu();
        jeu.setNoJeu(1);
        jeu.setTitre("Skyjo");
        jeu.setReference("REF-skyjo");
        jeu.setAgeMin(6);
        jeu.setDescription("Super pour jour en famille");
        jeu.setDuree(45);
        jeu.setTarifJour(4.5f);

        jeu.addGenre(genreUn);
        jeu.addGenre(genreDeux);

        assertNotNull(jeu);
        assertEquals(1, jeu.getNoJeu());
        assertEquals("Skyjo", jeu.getTitre());
        assertEquals("REF-skyjo", jeu.getReference());
        assertEquals(6, jeu.getAgeMin());
        assertEquals("Super pour jour en famille", jeu.getDescription());
        assertEquals(45, jeu.getDuree());
        assertEquals(4.5f, jeu.getTarifJour());
        assertEquals(2, jeu.getGenres().size());
        assertEquals(1, jeu.getGenres().get(0).getNoGenre());
        assertEquals(2, jeu.getGenres().get(1).getNoGenre());
    }
}
