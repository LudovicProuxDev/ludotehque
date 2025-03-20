package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
}
