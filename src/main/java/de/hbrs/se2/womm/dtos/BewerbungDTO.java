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

    public String bewerbungStelleBezeichnung(){
        return bewerbungStelle.getStelleTitel();
    }
    public String bewerbungStudentName(){
        return bewerbungStudent.getStudentName();
    }
    public  BewerbungDTO selfThis() {
        return this;
    }
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
