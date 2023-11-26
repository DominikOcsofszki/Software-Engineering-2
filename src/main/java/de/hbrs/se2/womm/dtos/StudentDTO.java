package de.hbrs.se2.womm.dtos;

import com.vaadin.flow.component.html.Image;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import lombok.Data;

@Data
public class StudentDTO extends AbstractDTO{
    private Nutzer nutzer;
    private Long studentId;
    private String studentVorname;
    private String studentName;
    private String studentGeburtstag;
    private boolean studentBenachrichtigung;
    private String studentBio;
    private String studentSpezialisierung;
    private Integer studentSemester;

    public Image PlaceholderOrImage(){
        if(nutzer == null || nutzer.getNutzerProfilbild() == null) {
            return ASSETS.buildPlaceholder(50,50);
        }
        return new Image("data:image/png;base64,"
                + nutzer.getNutzerProfilbild(), "getImage");
    }
    public static String[] getAllFilter(){
        return new String[]{
                "nutzer",
                "studentId",
                "studentVorname",
                "studentName",
                "studentGeburtstag",
                "studentBenachrichtigung",
                "studentBio",
                "studentSpezialisierung",
                "studentSemester"
        };
    }
}
