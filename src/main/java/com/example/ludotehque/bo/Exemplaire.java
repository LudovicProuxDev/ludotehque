package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "EXEMPLAIRE")
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noExemplaire;
    @Column(nullable = false, length = 100)
    @NonNull
    private String codeBarre;
    @Column @NonNull
    private Boolean louable;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NonNull
    private Jeu jeu;
}
