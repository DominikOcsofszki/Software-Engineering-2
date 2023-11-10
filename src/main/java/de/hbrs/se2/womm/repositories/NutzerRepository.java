package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Nutzer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutzerRepository extends JpaRepository<Nutzer, Long> {
    Nutzer findByNutzerId(long nutzerID);

    Nutzer findByNutzerName(String name);

    Nutzer findByNutzerMail(String mail);
}
