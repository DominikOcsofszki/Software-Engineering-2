package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Nutzer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutzerRepository extends JpaRepository<Nutzer, Long> {
    Nutzer findByNutzerId(long nutzerID);

    Nutzer findNutzerByNutzerName(String name);

    Nutzer findNutzerByNutzerPasswort(String password);

    Boolean existsNutzerByNutzerName(String name);

    List<Nutzer> findByNutzerNameContaining(String name);

    List<Nutzer> findByNutzerMailContaining(String mail);
}
