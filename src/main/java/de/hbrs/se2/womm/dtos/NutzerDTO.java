package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@Builder
@Getter
@Data
public class NutzerDTO extends AbstractDTO{
    private Long nutzerId;
    private String email;
    private boolean aktiv;
    private String ort;
    private byte[] profilbild;

    public byte[] getNutzerProfilbild() {
        return profilbild;
    }
}
