package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NutzerLoginDTO {
    private String nutzerName;
    private String nutzerPasswort;
    private String nutzerRolle;
}
