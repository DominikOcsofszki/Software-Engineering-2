package de.hbrs.se2.womm.dtos;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Image;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
public class UnternehmenDTO extends AbstractDTO{
    private Long unternehmenId;
    private String name;
    private String beschreibung;
    private String gruendung;
    private NutzerDTO nutzer;
    public Image PlaceholderOrImage(){
        return ASSETS.buildPlaceholder(50);

//        if(nutzer == null || nutzer.getNutzerProfilbild() == null) {
//            return ASSETS.buildPlaceholder(50,50);
//        }
//        return new Image("data:image/png;base64,"
//                + nutzer.getNutzerProfilbild(), "getImage");
    }
    public Image getLogo(){
        Image image = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        image.setHeight(20, Unit.PIXELS);
        return image;
    }
    public Image getLogo50(){
        Image image = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        image.setHeight(50, Unit.PIXELS);
        return image;
    }
}
