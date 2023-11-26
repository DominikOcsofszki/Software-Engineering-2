package de.hbrs.se2.womm.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class CompanyRegistrationRequest extends RegistrationRequest {
    private String name;
}
