package com.example.ludotehque.dal;

import com.example.ludotehque.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JeuRepository extends JpaRepository<Jeu, Integer> {
    @Query(nativeQuery = true, value = "select ex.no_jeu, j.titre, j.reference, j.description, j.tarif_jour, j.duree, j.age_min, COUNT(ex.no_jeu) as nbExemplaires "
            + " from jeu j left join exemplaire ex on j.no_jeu = ex.no_jeu "
            + " where ex.louable = 1 "
            + " and (:titre = 'TOUS' OR titre like '%:titre%')"
            + " group by ex.no_jeu, j.titre, j.reference, j.description, j.tarif_jour, j.duree, j.age_min ")
    List<Jeu> findAllJeuxAvecNbExemplaires(@Param("titre") String titre);

    float findTarifJourByNoJeu(Integer noJeu);

    Jeu findByReference(String reference);
}
