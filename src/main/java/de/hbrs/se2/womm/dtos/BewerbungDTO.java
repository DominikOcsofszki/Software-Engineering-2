package de.hbrs.se2.womm.dtos;

import lombok.Data;

@Data
public class BewerbungDTO {
    private Long bewerbungId;
    private byte[] pdf;
    private String text;
    private Long stelleId;
    private Long studentId;
}
