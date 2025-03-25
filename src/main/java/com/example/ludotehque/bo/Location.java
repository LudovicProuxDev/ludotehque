package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noLocation;
    @Column @NonNull
    private LocalDateTime dateDebut;
    @Column
    private LocalDateTime dateRetour;
    @Column(nullable = false, scale = 2)
    @NonNull
    private Float tarifJour;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="no_client", nullable = false)
    @NonNull
    private Client client;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="no_exemplaire", nullable = false)
    @NonNull
    private Exemplaire exemplaire;
}
