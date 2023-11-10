package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Stelle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StelleRepository extends JpaRepository<Stelle, Long> {
    Stelle findStelleByStelleId(long stelleID);
}
