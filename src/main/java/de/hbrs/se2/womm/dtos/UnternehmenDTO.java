package de.hbrs.se2.womm.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
@Data
@EqualsAndHashCode(callSuper = true)
public class UnternehmenDTO extends NutzerDTO {
    private Long unternehmenId;
    private String name;
    private String beschreibung;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String gruendung;
    private Long nutzerId;
}
