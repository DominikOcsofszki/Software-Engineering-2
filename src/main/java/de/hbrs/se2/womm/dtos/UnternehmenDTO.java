package de.hbrs.se2.womm.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = true)
public class UnternehmenDTO extends NutzerDTO {
    private Long unternehmenId;
    private String name;
    private String beschreibung;
    private Date gruendung;
    private Long nutzerId;
}
