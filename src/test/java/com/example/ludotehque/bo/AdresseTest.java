package com.example.ludotehque.bo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AdresseTest {
    @BeforeAll
    public static void initBeforeAll() {
        System.out.println("--- Test ADRESSE : Debut ---");
    }

    @Test
    @DisplayName("Création instance Adresse")
    public void test() {
        Adresse adresse = new Adresse();
        adresse.setNoAdresse(1);
        adresse.setRue("Avenue Léo Lagrange");
        adresse.setCodePostal("79000");
        adresse.setVille("NIORT");

        assertNotNull(adresse);
        assertEquals(1, adresse.getNoAdresse());
        assertEquals("Avenue Léo Lagrange", adresse.getRue());
        assertEquals("79000", adresse.getCodePostal());
        assertEquals("NIORT", adresse.getVille());
    }

    @AfterAll
    public static void initAfterAll() {
        System.out.println("--- Test ADRESSE : Fin ---");
    }
}
