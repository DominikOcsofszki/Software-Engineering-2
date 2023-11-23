package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import lombok.Data;

@Data
public class StudentDTO {
    private Nutzer nutzer;
    private Long studentId;
    private String studentVorname;
    private String studentName;
    private String studentGeburtstag;
    private boolean studentBenachrichtigung;
    private String studentBio;
    private String studentSpezialisierung;
    private Integer studentSemester;
}
