package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClientRepositoryTest {
    
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Creation d'un Client et d'une Adresse - cas positif")
    @Transactional
    public void testCreationClient() {
        // Arrange
        Adresse adresse = new Adresse("Avenue Léo Lagrange","79000","NIORT");
        Client client = new Client("Nom","Prenom","email@email.com","+33606060606",adresse);

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
    @DisplayName("Creation d'un Client avec email identique")
    public void testCreationClientEmailIdentique() {
        // Arrange
        Adresse adresse = new Adresse("Avenue Léo Lagrange","79000","NIORT");
        Client client = new Client("Nom","Prenom","email@email.com","+33606060606",adresse);
        long nbClients = clientRepository.count();

        // Act - Assert
        assertThrows(DataIntegrityViolationException.class, () -> {clientRepository.save(client);});
        assertNotEquals(clientRepository.count(),nbClients+1);
    }

    @Test
    @DisplayName("Recherche d'un Client par son identifiant")
    public void testFindByIdclient() {
        // Arrange
        Integer idclient = 1;

        // Act
        Optional<Client> clientOpt = clientRepository.findById(idclient);

        // Assert
        assertNotNull(clientOpt.isPresent());
        assertEquals(1, clientOpt.get().getNoClient());
    }
}
