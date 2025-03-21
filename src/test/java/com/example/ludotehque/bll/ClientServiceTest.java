package com.example.ludotehque.bll;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;
import com.example.ludotehque.dal.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockitoBean
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Ajout d'un client - cas positif")
    public void testAjouterClientCasPositif() {
        //Arrange
        Adresse adresse = new Adresse("rue des Cormorans", "44860", "Saint Aignan Grand Lieu");
        Client client = new Client("n1", "p1", "e1", "tel1");
        client.setAdresse(adresse);

        org.mockito.Mockito.doAnswer((invocation) -> {
            Client cli = invocation.getArgument(0);
            cli.setNoClient(999);
            return cli;
        }).when(clientRepository).save(client);

        //Act
        clientService.ajouterClient(client);

        //Assert
        Assertions.assertThat(client.getNoClient()).isNotNull();
        Assertions.assertThat(client.getNoClient()).isEqualTo(999);
    }
}
