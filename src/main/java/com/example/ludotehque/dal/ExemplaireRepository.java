package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
    @Query(nativeQuery = true,
            value="select count(e.codebarre) from jeu j inner join exemplaire e "
                    + "on j.no_jeu = e.no_jeu "
                    + "where j.no_jeu = :noJeu "
                    + "and e.louable = 1 "
                    + "and e.no_exemplaire not in "
                    + "(select l.no_exemplaire from locations l "
                    + "where l.date_retour IS null "
                    + "and l.no_exemplaire = e.no_exemplaire) "
                    + " group by e.code_barre ")
    int nbExemplairesDisponibleByNoJeu(@Param("noJeu") Integer noJeu);

    @Query("SELECT e FROM Exemplaire e LEFT JOIN FETCH e.jeu WHERE e.codeBarre = :codebarre")
    Exemplaire findByCodebarreWithJeu(@Param("codebarre") String codebarre);
}
