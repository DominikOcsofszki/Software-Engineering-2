package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Unternehmen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnternehmenRepository extends JpaRepository<Unternehmen, Long> {
    Unternehmen findUnternehmenByUnternehmenId(long unternehmenID);

    Unternehmen findUnternehmenByNutzer_NutzerId(long nutzerID);

    List<Unternehmen> findUnternehmenByUnternehmenNameContaining(String unternehmenName);
}
