package de.hbrs.se2.womm.repositories;

import de.hbrs.se2.womm.entities.AboStudentUnternehmen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboStudentUnternehmenRepository extends JpaRepository<AboStudentUnternehmen,Long> {
    AboStudentUnternehmen findAboStudentUnternehmenByAboId(long aboID);
    AboStudentUnternehmen findAboStudentUnternehmenByStudent_StudentIdAndUnternehmen_UnternehmenId(long studentID, long unternehmenID);
    List<AboStudentUnternehmen> findAboStudentUnternehmenByStudent_StudentId(long studentID);
}
