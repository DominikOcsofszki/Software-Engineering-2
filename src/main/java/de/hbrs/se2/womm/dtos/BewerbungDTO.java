package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BewerbungDTO {
    private Long bewerbungId;
    private byte[] bewerbungPdf;
    private String bewerbungText;
    private StelleDTO bewerbungStelle;
    private StudentDTO bewerbungStudent;
}
