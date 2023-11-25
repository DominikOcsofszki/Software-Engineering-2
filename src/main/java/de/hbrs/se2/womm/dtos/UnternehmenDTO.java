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
    private Image getPlaceholderImage(){
        return ASSETS.buildPlaceholder(50,50);
//        return new com.vaadin.flow.component.html.Image("data:image/png;base64,"
//                + nutzer.getNutzerProfilbild(), "Profilbild");
    }
    public Image getImage(){
        return getPlaceholderImage();
    }


//    public static boolean filterFunction(UnternehmenDTO anyDTO, String inputSearchNameFilter, SEARCHFILTER searchBy) {
//
//        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
//        String checkUnternehmen = switch (searchBy) {
////            case unternehmenId -> itemsToStringToLowerCase(anyDTO.getUnternehmenId()).toString().toLowerCase();
//            case UNTERNEHMENID -> itemsToStringToLowerCase(anyDTO.getUnternehmenId());
//            case NAME -> itemsToStringToLowerCase(anyDTO.getName());
//            case BESCHREIBUNG -> itemsToStringToLowerCase(anyDTO.getBeschreibung());
//            case GRUENDUNG -> itemsToStringToLowerCase(anyDTO.getGruendung());
//            case NUTZER -> itemsToStringToLowerCase(anyDTO.getNutzer().toString());
//            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
//        };
////        String checkUnternehmen;
////        switch (searchBy) {
////            case unternehmenId:
////                checkUnternehmen = anyDTO.getUnternehmenId().toString().toLowerCase();
////                break;
////            case name:
//////                checkUnternehmen = anyDTO.getName().toLowerCase();
//////                break;
//////            case beschreibung:
//////                checkUnternehmen = anyDTO.getBeschreibung().toLowerCase();
//////                break;
//////            case gruendung:
//////                checkUnternehmen = anyDTO.getGruendung().toLowerCase();
//////                break;
//////            case nutzer:
//////                checkUnternehmen = anyDTO.getNutzer().toString().toLowerCase();
//////                break;
////            default:
////                throw new IllegalStateException("Unexpected value: " + searchBy);
////        }
//
//        return checkUnternehmen.contains(inputSearchNameFilter);
//    }
//    private static String itemsToStringToLowerCase(Object item) {
//        return item.toString().toLowerCase();
//    }



}
