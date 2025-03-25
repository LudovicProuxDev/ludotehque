package com.example.ludotehque.bll;

import com.example.ludotehque.bo.Adresse;
import com.example.ludotehque.bo.Client;
import com.example.ludotehque.dal.AdresseRepository;
import com.example.ludotehque.dal.ClientRepository;
import com.example.ludotehque.dto.ClientDTO;
import com.example.ludotehque.exceptions.DataNotFound;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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
    public Client ajouterClient(ClientDTO clientDTO) {
        Client client = new Client();
        Adresse adresse = new Adresse();
        BeanUtils.copyProperties(clientDTO, client);
        BeanUtils.copyProperties(clientDTO, adresse);
        client.setAdresse(adresse);
        return clientRepository.save(client);
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
    public Client modifierClient(Integer noClient, ClientDTO clientDTO) {
        Optional<Client> optClient = clientRepository.findById(noClient);
        if(optClient.isEmpty()) {
            throw new DataNotFound("Client", noClient);
        }
        if (clientDTO.getNom()==null) {
            clientDTO.setNom(optClient.get().getNom());
        }
        if (clientDTO.getPrenom()==null) {
            clientDTO.setPrenom(optClient.get().getPrenom());
        }
        if (clientDTO.getEmail()==null) {
            clientDTO.setEmail(optClient.get().getEmail());
        }
        if (clientDTO.getTelephone()==null) {
            clientDTO.setTelephone(optClient.get().getTelephone());
        }
        BeanUtils.copyProperties(clientDTO, optClient.get());
        BeanUtils.copyProperties(clientDTO, optClient.get().getAdresse());
        return clientRepository.save(optClient.get());
    }

    @Override
    public void modifierAdresse(Adresse adresse) {
        if(adresse.getNoAdresse()==null){
            throw new IllegalStateException();
        }
        adresseRepository.save(adresse);
    }

    @Override
    public List<Client> trouverClients() {
        return clientRepository.findAll();
    }

    @Override
    public void supprimerClient(Integer id) {
        Optional<Client> optClient = clientRepository.findById(id);
        if(optClient.isEmpty()) {
            throw new DataNotFound("Client", id);
        }
        clientRepository.delete(optClient.get());
    }
}
