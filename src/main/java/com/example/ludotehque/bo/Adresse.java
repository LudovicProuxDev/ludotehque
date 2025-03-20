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
@Table(name= "ADRESSE")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noAdresse;
    @Column(nullable = false, length = 100)
    @NonNull
    private String rue;
    @Column(nullable = false, length = 6)
    @NonNull
    private String codePostal;
    @Column(nullable = false, length = 50)
    @NonNull
    private String ville;
}
