package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
