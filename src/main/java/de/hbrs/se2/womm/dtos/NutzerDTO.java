package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class NutzerDTO {
    private long nutzerId;
    private String nutzerMail;
    private Boolean nutzerAktiv;
    private String nutzerOrt;
    private byte[] nutzerProfilbild;
}