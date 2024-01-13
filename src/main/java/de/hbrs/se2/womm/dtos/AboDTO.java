package de.hbrs.se2.womm.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AboDTO {
    private Integer aboId;

    private Boolean aboBenachrichtigungen;

    private StudentDTO student;

    private UnternehmenDTO unternehmen;
}
