package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    List<Client> findClientsByNom(String nom);
}
