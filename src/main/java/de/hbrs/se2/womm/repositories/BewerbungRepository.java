package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.Bewerbung;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BewerbungRepository extends JpaRepository<Bewerbung,Long> {
    List<Bewerbung> findBewerbungByStudent_StudentId(long studentID);
    List<Bewerbung> findBewerbungByStelle_StelleId(long stelleID);

    Bewerbung findBewerbungByBewerbungId(long bewerbungID);
}
