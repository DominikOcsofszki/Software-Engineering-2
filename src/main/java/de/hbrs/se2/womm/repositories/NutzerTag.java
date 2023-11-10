package de.hbrs.se2.womm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NutzerTag extends JpaRepository<NutzerTag, Long> {
    List<NutzerTag> findNutzerTagByNutzer_NutzerID(long nutzerID);

    List<NutzerTag> findNutzerTagByTag_TagID(long tagID);
}
