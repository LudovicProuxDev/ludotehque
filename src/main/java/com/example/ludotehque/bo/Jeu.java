package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "JEU")
public class Jeu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noJeu;
    @Column(nullable = false, length = 50)
    @NonNull
    private String titre;
    @Column(nullable = false, length = 50)
    @NonNull
    private String reference;
    @Column @NonNull
    private Integer ageMin;
    @Column(columnDefinition = "TEXT")
    @NonNull
    private String description;
    @Column @NonNull
    private Integer duree;
    @Column(nullable = false, scale = 2)
    @NonNull
    private Float tarifJour;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "JEU_GENRE",
            joinColumns = {@JoinColumn(name = "no_jeu")},
            inverseJoinColumns = {@JoinColumn(name = "no_genre")},
            uniqueConstraints = {@UniqueConstraint(columnNames = { "no_jeu", "no_genre" })}
    )
    private List<Genre> genres = new ArrayList<>();

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void removeGenre(Genre genre) { genres.remove(genre); }
}
