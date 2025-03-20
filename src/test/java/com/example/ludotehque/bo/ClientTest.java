package com.example.ludotehque.bo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientTest {
    @BeforeAll
    public static void initBeforeAll() {
        System.out.println("--- Test CLIENT : Debut ---");
    }

    @Test
    @DisplayName("Création instance Client")
    public void test() {
        Adresse adresse = new Adresse();
        adresse.setNoAdresse(1);
        adresse.setRue("Avenue Léo Lagrange");
        adresse.setCodePostal("79000");
        adresse.setVille("NIORT");

        Client client = new Client();
        client.setNoClient(1);
        client.setNom("Nom");
        client.setPrenom("Prenom");
        client.setEmail("email@email.com");
        client.setTelephone("+33606060606");
        client.setAdresse(adresse);

        assertNotNull(client);
        assertEquals(1, client.getNoClient());
        assertEquals("Nom", client.getNom());
        assertEquals("Prenom", client.getPrenom());
        assertEquals("email@email.com", client.getEmail());
        assertEquals("+33606060606", client.getTelephone());
        assertEquals(1, client.getAdresse().getNoAdresse());
    }

    @AfterAll
    public static void initAfterAll() {
        System.out.println("--- Test CLIENT : Fin ---");
    }
}
