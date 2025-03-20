package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
