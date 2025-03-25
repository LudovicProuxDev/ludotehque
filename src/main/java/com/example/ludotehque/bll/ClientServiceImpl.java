package com.example.ludotehque.bll;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;
import com.example.ludotehque.dal.AdresseRepository;
import com.example.ludotehque.dal.ClientRepository;
import com.example.ludotehque.exceptions.DataNotFound;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    @NonNull
    private ClientRepository clientRepository;
    @NonNull
    private AdresseRepository adresseRepository;

    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client trouverClientParId(Integer id) {
        Optional<Client> optClient = clientRepository.findById(id);
        if(optClient.isEmpty()) {
            throw new DataNotFound("Client", id);
        }
        return optClient.get();
    }

    @Override
    public List<Client> trouverClientsParNom(String nom) {
        return clientRepository.findByNomContaining(nom);
    }

    @Override
    public void modifierClient(Client client) {
        if(client.getNoClient()==null) {
            throw new IllegalStateException();
        }
        clientRepository.save(client);
    }

    @Override
    public void modifierAdresse(Adresse adresse) {
        if(adresse.getNoAdresse()==null){
            throw new IllegalStateException();
        }
        adresseRepository.save(adresse);
    }
}
