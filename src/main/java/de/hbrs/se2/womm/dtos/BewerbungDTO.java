package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.entities.Student;
import lombok.Data;

@Data
public class BewerbungDTO extends AbstractDTO{
    private Long bewerbungId;
    private byte[] bewerbungPdf;
    private String bewerbungText;
    private Stelle bewerbungStelle;
    private Student bewerbungStudent;

    public static String[] getAllFilter(){
        return new String[]{
                "bewerbungId",
                "bewerbungPdf",
                "bewerbungText",
                "bewerbungStelle",
                "bewerbungStudent"
        };
    }
}
