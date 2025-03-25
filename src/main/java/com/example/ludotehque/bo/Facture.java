package com.example.ludotehque.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Table(name= "FACTURE")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noFacture;
    @Column(columnDefinition = "DATETIME")
    @NonNull
    private LocalDateTime datePaiement;

    @OneToMany
    @JoinColumn(name="no_facture")
    private List<Location> locations;
}
