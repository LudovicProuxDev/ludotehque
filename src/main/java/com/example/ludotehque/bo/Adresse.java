package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name= "ADRESSE")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noAdresse;
    @Column(nullable = false, length = 100)
    private String rue;
    @Column(nullable = false, length = 6)
    private String codePostal;
    @Column(nullable = false, length = 50)
    private String ville;
}
