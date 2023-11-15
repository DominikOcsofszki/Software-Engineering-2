package de.hbrs.se2.womm.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = true)
public class StudentRegistrationRequest extends RegistrationRequest {
    private String firstname;
    private String lastname;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;
}
