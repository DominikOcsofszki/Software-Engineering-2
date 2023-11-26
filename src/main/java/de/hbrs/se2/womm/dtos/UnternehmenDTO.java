package de.hbrs.se2.womm.dtos;

import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

//import java.awt.*;
import com.vaadin.flow.component.html.Image;

@Data
@Builder
@Getter
public class UnternehmenDTO {
    private Long unternehmenId;
    private String name;
    private String beschreibung;
    private String gruendung;
    private Nutzer nutzer;
    public Image PlaceholderOrImage(){
        if(nutzer == null || nutzer.getNutzerProfilbild() == null) {
            return ASSETS.buildPlaceholder(50,50);
        }
        return new Image("data:image/png;base64,"
                + nutzer.getNutzerProfilbild(), "getImage");
    }
}
