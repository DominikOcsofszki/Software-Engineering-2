package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Stelle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StelleRepository extends JpaRepository<Stelle, Long> {
    List<Stelle> findByUnternehmen_UnternehmenId(long stelleID);
}
