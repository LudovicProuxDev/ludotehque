package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "GENRE")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noGenre;
    @Column(nullable = false, length = 50)
    @NonNull
    private String libelle;
}
