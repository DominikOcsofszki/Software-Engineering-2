package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.components.GridFilterStelle;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Route(value = ROUTING.UNTERNEHMEN.UEditFirmProfileDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("EditFirmProfileDisplayView")
public class UEditFirmProfileDisplayView extends AViewWomm {


    UnternehmenDTO unternehmenDTO;
    TextArea descriptionTextArea = new TextArea("Company Description");
    TextArea gruendung = new TextArea("Since");
    TextField locationField = getWommBuilder().TextField.create("Company Location");
    TextField websiteField = getWommBuilder().TextField.create("Company Website");

    private long aktuelleNutzerID;
    private UnternehmenService unternehmenService;
    GridFilterStelle gridFilterStelle;


    protected UEditFirmProfileDisplayView(UnternehmenService unternehmenService, StelleService stelleService, SecurityService securityService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        this.unternehmenService = unternehmenService;
        setUp();
        this.gridFilterStelle = new GridFilterStelle();
        List<StelleDTO> stelleDTOList = stelleService.getByNutzerId(aktuelleNutzerID);
        this.gridFilterStelle.setUpFromOutside(stelleDTOList);
//        add(gridFilterStelle); //TODO deleted, since wrong place?
//        add(new FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative(stelleController, unternehmenDTO.getUnternehmenId()));
    }

    void setupStars(int stars, HorizontalLayout ratingLayout) {
        for (int i = 1; i <= stars; i++) {
            ratingLayout.add(new Icon(VaadinIcon.STAR));
        }
    }


    private void setUp() {
//        Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");
        Image companyLogo = unternehmenDTO.PlaceholderOrImage();
        H2 firmName = new H2(unternehmenDTO.getName());
        String companyDescription = unternehmenDTO.getBeschreibung() == null ?
                "Company Description" : unternehmenDTO.getBeschreibung();
        long nrOfReviews = 123;//ToDo DTO Reviews ---> Anzahl von Bewertungen
        HorizontalLayout ratingLayout = new HorizontalLayout();//ToDo refactored
        int starsRating = 5;

        String companyLocation = unternehmenDTO.getNutzer().getNutzerOrt() == null ?
                "Company Location" : unternehmenDTO.getNutzer().getNutzerOrt();
        String companyWebsite = unternehmenDTO.getWebsite_url() == null ?
                "Company Website" : unternehmenDTO.getWebsite_url();
        String reviews = " (" + nrOfReviews + " Reviews)";
        setupStars(starsRating, ratingLayout);
//Set up Fields:
        descriptionTextArea.setValue(companyDescription);
        String gruendung1 = unternehmenDTO.getGruendung() == null ?
                "Company Since" : unternehmenDTO.getGruendung();
        gruendung.setValue(gruendung1);

        // Logo, Company Name, and Edit Firm Profile Button
        HorizontalLayout buttonsLayout = new HorizontalLayout();

        HorizontalLayout logoAndEditLayout = new HorizontalLayout();
        Div logoAndName = new Div();

        logoAndName.add(companyLogo);
        logoAndName.add(firmName);//ToDo put at top, refactored
        logoAndEditLayout.add(logoAndName);
        companyLogo.setWidth(200 + "px");
        companyLogo.setHeight(200 + "px");

        //Save Button
        Button saveButton = getWommBuilder().Button.create("Save Changes");
        saveButton.addClickListener(e -> {
            unternehmenService.saveUnternehmen(newUnternehmenDTOFromFields());
            UI.getCurrent().getPage().reload();
        });

        descriptionTextArea.setWidth("100%");
        descriptionTextArea.setHeight("200px");
        add(buttonsLayout);
        buttonsLayout.add(logoAndEditLayout);
        buttonsLayout.add(saveButton);

        ratingLayout.add(new Span(reviews));//ToDo Refactored
        add(ratingLayout);

        locationField.setValue(companyLocation);

        websiteField.setValue(companyWebsite);

        add(locationField, websiteField);

        add(descriptionTextArea, gruendung);
    }

    private UnternehmenDTO newUnternehmenDTOFromFields() {
        unternehmenDTO.setBeschreibung(descriptionTextArea.getValue());
        unternehmenDTO.setGruendung(gruendung.getValue());
        unternehmenDTO.getNutzer().setNutzerOrt(locationField.getValue());
        unternehmenDTO.setWebsite_url(websiteField.getValue());
        return unternehmenDTO;
    }
}
