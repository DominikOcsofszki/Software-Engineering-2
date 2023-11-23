package de.hbrs.se2.womm.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDTO {
    private String vorname;
    private String name;
    private String geburtstag;
    private boolean benachrichtigung;
    private String bio;
    private String spezialisierung;
    private Integer semester;
}
