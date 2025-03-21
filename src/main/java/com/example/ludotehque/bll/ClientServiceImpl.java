package com.example.ludotehque.bll;

import com.example.ludotehque.bo.Client;
import com.example.ludotehque.dal.ClientRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientServiceImpl implements ClientService {
    @NonNull
    private ClientRepository clientRepository;

    @Override
    public void ajouterClient(Client client) {
        clientRepository.save(client);
    }
}
