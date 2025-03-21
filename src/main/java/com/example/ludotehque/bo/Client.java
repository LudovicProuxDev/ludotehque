package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noClient;
    @Column(nullable = false, length = 50)
    @NonNull
    private String nom;
    @Column(nullable = false, length = 50)
    @NonNull
    private String prenom;
    @Column(nullable = false, length = 180, unique = true)
    @NonNull
    private String email;
    @Column(nullable = false, length = 20)
    @NonNull
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "no_adresse", nullable = false)
    private Adresse adresse;
}
