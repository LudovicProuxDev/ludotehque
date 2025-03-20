package com.example.ludotehque.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GenreTest {
    @Test
    @DisplayName("Création instance Genre")
    public void test() {
        Genre genre = new Genre();
        genre.setNoGenre(1);
        genre.setLibelle("Genre");

        assertNotNull(genre);
        assertEquals(1, genre.getNoGenre());
        assertEquals("Genre", genre.getLibelle());
    }
}
