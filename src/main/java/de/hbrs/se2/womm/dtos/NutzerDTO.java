package de.hbrs.se2.womm.dtos;

import lombok.Data;

@Data
public class NutzerDTO {
    private Long nutzerId;
    private String email;
    private boolean aktiv;
    private String ort;
    private byte[] profilbild;
}
