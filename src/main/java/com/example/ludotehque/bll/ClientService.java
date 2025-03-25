package com.example.ludotehque.bll;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;
import com.example.ludotehque.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    Client ajouterClient(ClientDTO clientDTO);

    Client trouverClientParId(Integer id);

    List<Client> trouverClientsParNom(String nom);

    Client modifierClient(Integer noClient, ClientDTO clientDTO);

    void modifierAdresse(Adresse adresse);

    List<Client> trouverClients();

    void supprimerClient(Integer id);
}
