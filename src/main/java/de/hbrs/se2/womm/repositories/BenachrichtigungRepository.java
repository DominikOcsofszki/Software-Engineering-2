package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Benachrichtigung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenachrichtigungRepository extends JpaRepository<Benachrichtigung, Long> {
    List<Benachrichtigung> findByNutzer_id(Long id);
}
