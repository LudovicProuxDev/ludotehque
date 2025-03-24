package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientRepositoryTest {
    
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Creation d'un Client et d'une Adresse - cas positif")
    public void testCreationClient() {
        // Arrange
        Adresse adresse = new Adresse("Avenue Léo Lagrange","79000","NIORT");
        Client client = new Client("Nom","Prenom","email@email.com","+33606060606");
        client.setAdresse(adresse);

        //Act
        clientRepository.save(client);

        //Assert
        assertThat(client.getNoClient()).isNotNull();
        Optional<Client> clientBD = clientRepository.findById(client.getNoClient());
        assertThat(clientBD.isPresent()).isTrue();
        if(clientBD.isPresent()) {
            assertThat(clientBD.get()).isEqualTo(client);
        }
    }

    @Test
    @DisplayName("Creation d'un Client avec email identique - cas negatif")
    public void testCreationClientEmailIdentique() {
        // Arrange
        Adresse adresse = new Adresse("Avenue Léo Lagrange","79000","NIORT");
        Client client = new Client("Nom","Prenom","email@email.com","+33606060606");
        client.setAdresse(adresse);
        long nbClients = clientRepository.count();

        // Act - Assert
        assertThrows(DataIntegrityViolationException.class, () -> {clientRepository.save(client);});
        assertNotEquals(clientRepository.count(),nbClients+1);
    }

    @Test
    @DisplayName("Recherche d'un Client par son identifiant - cas positif")
    public void testFindByIdClient() {
        // Arrange
        Integer idclient = 1;

        // Act
        Optional<Client> clientOpt = clientRepository.findById(idclient);

        // Assert
        assertNotNull(clientOpt.isPresent());
        assertEquals(1, clientOpt.get().getNoClient());
    }

    @Test
    @DisplayName("Creation d'un Client sans Adresse - cas negatif")
    public void testCreationClientSansAdresse() {
        // Arrange
        Client client = new Client("Nom","Prenom","email@email.com","+33606060606");

        // Act - Assert
        assertThrows(DataIntegrityViolationException.class, () -> {clientRepository.save(client);});
    }


    @Test
    @DisplayName("Recherche clients par nom - cas positif")
    public void testFindByNomClientCasPositif() {
        // Arrange
        String nom = "Nom";

        // Act - Assert
        assertEquals(true, !clientRepository.findClientsByNom(nom).isEmpty());
    }

    @Test
    @DisplayName("Recherche clients par nom - cas negatif")
    public void testFindByNomClientCasNegatif() {
        // Arrange
        String nom = "Hello World";

        // Act - Assert
        assertEquals(true, clientRepository.findClientsByNom(nom).isEmpty());
    }

    @Test
    @DisplayName("Modification d'un Client et d'une Adresse - cas positif")
    public void testModificationClient() {
        // Arrange
        Optional<Client> clientBD = clientRepository.findById(1);
        Adresse clientAdresse = clientBD.get().getAdresse();
        clientBD.get().setNom("PROUX");
        clientBD.get().setPrenom("Ludovic");
        clientBD.get().setTelephone("0606060606");
        clientBD.get().setEmail("ludovic.proux@email.com");
        clientBD.get().getAdresse().setRue("Avenue du Maréchal Juin");
        clientBD.get().getAdresse().setCodePostal("17000");
        clientBD.get().getAdresse().setVille("LA ROCHELLE");

        //Act
        clientRepository.save(clientBD.get());

        //Assert
        clientBD = clientRepository.findById(1);
        assertThat(clientBD.isPresent()).isTrue();
        assertThat(clientBD.get().getAdresse().getNoAdresse()).isNotNull();
        if(clientBD.isPresent()) {
            assertEquals(1, clientBD.get().getNoClient());
            assertEquals("PROUX", clientBD.get().getNom());
            assertEquals("Ludovic", clientBD.get().getPrenom());
            assertEquals("ludovic.proux@email.com", clientBD.get().getEmail());
            assertEquals("0606060606", clientBD.get().getTelephone());
            assertThat(clientBD.get().getAdresse().getNoAdresse()).isEqualTo(clientAdresse.getNoAdresse());
            assertEquals("Avenue du Maréchal Juin", clientBD.get().getAdresse().getRue());
            assertEquals("17000", clientBD.get().getAdresse().getCodePostal());
            assertEquals("LA ROCHELLE", clientBD.get().getAdresse().getVille());
        }
    }

    @Test
    @DisplayName("Modification de l'Adresse du Client - cas positif")
    public void testModificationAdresseClient() {
        // Arrange
        Optional<Client> clientBD = clientRepository.findById(1);
        Adresse clientAdresse = clientBD.get().getAdresse();
        clientBD.get().getAdresse().setRue("Avenue Léo Lagrange");
        clientBD.get().getAdresse().setCodePostal("79000");
        clientBD.get().getAdresse().setVille("NIORT");

        //Act
        clientRepository.save(clientBD.get());

        //Assert
        clientBD = clientRepository.findById(1);
        assertThat(clientBD.isPresent()).isTrue();
        assertThat(clientBD.get().getAdresse().getNoAdresse()).isNotNull();
        if(clientBD.isPresent()) {
            assertThat(clientBD.get().getAdresse().getNoAdresse()).isEqualTo(clientAdresse.getNoAdresse());
            assertEquals("Avenue Léo Lagrange", clientBD.get().getAdresse().getRue());
            assertEquals("79000", clientBD.get().getAdresse().getCodePostal());
            assertEquals("NIORT", clientBD.get().getAdresse().getVille());
        }
    }
}
