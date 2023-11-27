package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
