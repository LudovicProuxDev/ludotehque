package com.example.ludotehque.bll;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;

import java.util.List;

public interface ClientService {
    void ajouterClient(Client client);

    Client trouverClientParId(Integer id);

    List<Client> trouverClientsParNom(String nom);

    void modifierClient(Client client);

    void modifierAdresse(Adresse adresse);

    List<Client> trouverClients();
}
