package de.hbrs.se2.womm.dtos;

import lombok.Data;

@Data
public class StelleDTO {
    private Long stelleId;
    private String titel;
    private String ort;
    private String beschreibung;
    private String website;
}
