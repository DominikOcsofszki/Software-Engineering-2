package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Builder
@Getter
public class UnternehmenDTO {
    private Long unternehmenId;
    private String name;
    private String beschreibung;
    private String gruendung;
    private Nutzer nutzer;
}
