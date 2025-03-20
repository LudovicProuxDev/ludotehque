package com.example.ludotehque.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExemplaireTest {
    @Test
    @DisplayName("Création instance Client")
    public void test() {
        Jeu jeu = new Jeu();
        jeu.setNoJeu(1);
        jeu.setTitre("Skyjo");
        jeu.setReference("REF-skyjo");
        jeu.setAgeMin(6);
        jeu.setDescription("Super pour jour en famille");
        jeu.setDuree(45);
        jeu.setTarifJour(4.5f);

        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setNoExemplaire(1);
        exemplaire.setCodeBarre("codeBarre");
        exemplaire.setLouable(true);
        exemplaire.setJeu(jeu);

        assertNotNull(exemplaire);
        assertEquals(1, exemplaire.getNoExemplaire());
        assertEquals("codeBarre", exemplaire.getCodeBarre());
        assertEquals(true, exemplaire.getLouable());
        assertEquals(1, exemplaire.getJeu().getNoJeu());
    }
}
