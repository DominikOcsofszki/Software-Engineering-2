package de.hbrs.se2.womm.services;

import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.views.layouts.ASSETS;

import javax.swing.*;
import java.awt.Image;

public class ImageService {
    private com.vaadin.flow.component.html.Image getPlaceholderImage(){
        return ASSETS.buildPlaceholder(50,50);
    }
    public com.vaadin.flow.component.html.Image getImage(Nutzer nutzer){
        if(nutzer == null || nutzer.getNutzerProfilbild() == null) return getPlaceholderImage();
        return new com.vaadin.flow.component.html.Image("data:image/png;base64,"
                + nutzer.getNutzerProfilbild(), "getImage");
    }
}
