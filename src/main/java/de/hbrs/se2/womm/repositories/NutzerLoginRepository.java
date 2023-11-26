package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.NutzerLogin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutzerLoginRepository extends JpaRepository<NutzerLogin,Long> {
}
