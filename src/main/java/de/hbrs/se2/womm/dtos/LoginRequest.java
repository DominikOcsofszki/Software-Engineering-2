package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import lombok.Data;

@Data
public class LoginRequest extends AbstractDTO{
    private String username;
    private String password;
}
