package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;

@Builder
@Getter
@Data
public class NutzerDTO {
    private Long nutzerId;
    private String email;
    private boolean aktiv;
    private String ort;
    private byte[] profilbild;

    public String getNutzerProfilbild() {
        return Arrays.toString(profilbild);
    }
}
