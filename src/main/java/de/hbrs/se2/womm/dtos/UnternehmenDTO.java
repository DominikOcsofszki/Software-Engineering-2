package de.hbrs.se2.womm.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UnternehmenDTO {
    private Long unternehmenId;
    private String name;
    private String beschreibung;
    private String gruendung;
    private Long nutzerId;
}
