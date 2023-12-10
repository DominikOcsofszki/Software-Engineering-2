package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.entities.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BewerbungDTO extends AbstractDTO{
    private Long bewerbungId;
    private byte[] bewerbungPdf;
    private String bewerbungText;
    private StelleDTO bewerbungStelle;
    private StudentDTO bewerbungStudent;
}
