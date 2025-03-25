package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("SELECT l FROM Location l WHERE l.exemplaire.codeBarre = :codebarre")
    Location findLocationByCodebarreWithJeu(@Param("codebarre") String codebarre);
}
