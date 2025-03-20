package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Genre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GenreRepositoryTest {
    @Autowired
    private GenreRepository genreRepository;

    @Test
    @DisplayName("Creation d'un Genre")
    public void testCreationGenre() {
        // Arrange
        Genre genre = new Genre("Genre");
        long nbGenres = genreRepository.count();

        // Act
        genreRepository.save(genre);

        // Assert
        assertNotNull(genre.getNoGenre());
        assertEquals(genreRepository.count(),nbGenres+1);
    }

    @Test
    @DisplayName("Recherche d'un Genre par son identifiant")
    public void testFindByIdGenre() {
        // Arrange
        Integer idGenre = 1;

        // Act
        Optional<Genre> genreOpt = genreRepository.findById(idGenre);

        // Assert
        assertNotNull(genreOpt.isPresent());
        assertEquals(1, genreOpt.get().getNoGenre());
    }
}
