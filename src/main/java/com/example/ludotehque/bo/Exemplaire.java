package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name= "EXEMPLAIRE")
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noExemplaire;
    @Column(nullable = false, length = 100)
    private String codeBarre;
    @Column
    private Boolean louable;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Jeu jeu;
}
