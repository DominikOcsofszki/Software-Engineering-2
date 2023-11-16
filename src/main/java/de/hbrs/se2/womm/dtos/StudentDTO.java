package de.hbrs.se2.womm.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDTO extends NutzerDTO {
    private String vorname;
    private String name;
    private Date geburtstag;
    private boolean benachrichtigung;
    private String bio;
    private String spezialisierung;
    private Integer semester;
}
