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
    TextField locationField = new TextField("Company Location");
    TextField websiteField = new TextField("Company Website");
    private long aktuelleNutzerID;
    private UnternehmenService unternehmenService;
    GridFilterStelle gridFilterStelle;
    public UnternehmenDTO getUnternehmenDTO() {
        return unternehmenDTO;
    }
    protected UEditFirmProfileDisplayView(UnternehmenService unternehmenService, StelleService stelleService, SecurityService securityService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        this.unternehmenService = unternehmenService;
        setUp();
        this.gridFilterStelle = new GridFilterStelle();
        List<StelleDTO> stelleDTOList = stelleService.getByNutzerId(aktuelleNutzerID);
        this.gridFilterStelle.setUpFromOutside(stelleDTOList);
    }
    void setupStars(int stars, HorizontalLayout ratingLayout) {
        for (int i = 1; i <= stars; i++) {
            ratingLayout.add(new Icon(VaadinIcon.STAR));
        }
    }
    private void setUp() {
        Image companyLogo = getUnternehmenDTO().PlaceholderOrImage();
        H2 firmName = new H2(getUnternehmenDTO().getName());
        String companyDescription = getUnternehmenDTO().getBeschreibung() == null ?
                "Company Description" : getUnternehmenDTO().getBeschreibung();
        long nrOfReviews = 123;//ToDo DTO Reviews ---> Anzahl von Bewertungen
        HorizontalLayout ratingLayout = new HorizontalLayout();//ToDo refactored
        int starsRating = 5;
        int nrOfEmployees = 999;
        String companyLocation = getUnternehmenDTO().getNutzer().getNutzerOrt() == null ?
                "Company Location" : getUnternehmenDTO().getNutzer().getNutzerOrt();
        String companyWebsite = "http://www.companywebsite.com";
        String reviews = " (" + nrOfReviews + " Reviews)";
        setupStars(starsRating, ratingLayout);
        descriptionTextArea.setValue(companyDescription);
        String gruendung1 = getUnternehmenDTO().getGruendung() == null ?
                "Company Since" : getUnternehmenDTO().getGruendung();
        gruendung.setValue(gruendung1);
        Upload logoUpload = new Upload();
        logoUpload.setAcceptedFileTypes("image/*");
        logoUpload.addSucceededListener(event -> {
        });
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        HorizontalLayout logoAndEditLayout = new HorizontalLayout();
        Div logoAndName = new Div();
        logoAndName.add(companyLogo);
        logoAndName.add(firmName);//ToDo put at top, refactored
        logoAndEditLayout.add(logoAndName);
        companyLogo.setWidth(200 + "px");
        companyLogo.setHeight(200 + "px");
        /*Button editButton = new Button("Edit firm profile");
        editButton.addClickListener(e -> {
            UI.getCurrent().navigate(UEditFirmProfileDisplayView.class);
        });
        logoAndEditLayout.add(editButton);*/
        Button saveButton = new Button("Save Changes");
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
        TextField employeesField = new TextField("Number of Employees");
        employeesField.setValue(String.valueOf(nrOfEmployees));
        websiteField.setValue(companyWebsite);
        add(locationField, employeesField, websiteField);
        add(descriptionTextArea, gruendung);
    }
    private UnternehmenDTO newUnternehmenDTOFromFields() {
        unternehmenDTO.setBeschreibung(descriptionTextArea.getValue());
        unternehmenDTO.setGruendung(gruendung.getValue());
        unternehmenDTO.getNutzer().setNutzerOrt(locationField.getValue());
        return unternehmenDTO;
    }
}
