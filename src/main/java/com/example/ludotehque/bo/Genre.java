package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name= "GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noGenre;
    @Column(nullable = false, length = 50)
    private String libelle;
}
