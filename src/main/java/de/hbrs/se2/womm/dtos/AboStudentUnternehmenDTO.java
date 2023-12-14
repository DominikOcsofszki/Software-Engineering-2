package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.entities.Unternehmen;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AboStudentUnternehmenDTO {
    private Integer aboId;

    private Boolean aboBenachrichtigungen;

    private Student student;

    private Unternehmen unternehmen;
}
