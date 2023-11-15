package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import lombok.Data;

@Data
public class LoginRequest {
    Nutzer n = Nutzer.builder().nutzerId(4).build();
    private String username;
    private String password;
}
