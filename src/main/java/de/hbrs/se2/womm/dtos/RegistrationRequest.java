package de.hbrs.se2.womm.dtos;

import lombok.Data;

@Data
public class RegistrationRequest extends AbstractDTO{
    private String username;
    private String password;
    private String email;
    private String location;
}
