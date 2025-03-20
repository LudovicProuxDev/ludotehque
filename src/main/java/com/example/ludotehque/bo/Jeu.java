package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name= "JEU")
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noJeu;
    @Column(nullable = false, length = 50)
    private String titre;
    @Column(nullable = false, length = 50)
    private String reference;
    @Column
    private Integer ageMin;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private Integer duree;
    @Column(nullable = false, scale = 2)
    private Float tarifJour;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "JEU_GENRE",
            joinColumns = {@JoinColumn(name = "no_jeu")},
            inverseJoinColumns = {@JoinColumn(name = "no_genre")}
    )
    private List<Genre> genres;
}
