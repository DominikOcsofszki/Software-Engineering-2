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
    TextArea gruendung  = new TextArea("Since");

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
        add(gridFilterStelle);
//        add(new FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative(stelleController, unternehmenDTO.getUnternehmenId()));
    }

    void setupStars(int stars, HorizontalLayout ratingLayout) {
        for (int i = 1; i <= stars; i++) {
            ratingLayout.add(new Icon(VaadinIcon.STAR));
        }
    }
    private UnternehmenDTO newUnternehmenDTOFromFields(){
        UnternehmenDTO newUnternehmenDTO = UnternehmenDTO.builder()
                .unternehmenId(getUnternehmenDTO().getUnternehmenId())
                .name(getUnternehmenDTO().getName())
                .beschreibung(descriptionTextArea.getValue())
                .gruendung(gruendung.getValue())
                .nutzer(getUnternehmenDTO().getNutzer())
                .build();
        System.out.println(newUnternehmenDTO);
        return newUnternehmenDTO;
    }

    private void setUp() {
//        Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");
        Image companyLogo = getUnternehmenDTO().PlaceholderOrImage();
        H2 firmName = new H2(getUnternehmenDTO().getName());
        String companyDescription = getUnternehmenDTO().getBeschreibung();
        long nrOfReviews = 123;//ToDo DTO Reviews ---> Anzahl von Bewertungen
//        long nrOfReviews = getUnternehmenDTO().getNrOfRatings(); //ToDo DTO Reviews ---> Anzahl von Bewertungen
        HorizontalLayout ratingLayout = new HorizontalLayout();//ToDo refactored
        int starsRating = 5;
//        int starsRating = getUnternehmenDTO().getStars(); //ToDo DTO
        int nrOfEmployees = 999;
//        int nrOfEmployees = getUnternehmenDTO().getNumberOfEmployees(); //ToDo DTO

//        String companyLocation = "Company Location";
        String companyLocation = getUnternehmenDTO().getNutzer().getNutzerOrt() == null ?
                "Company Location" : getUnternehmenDTO().getNutzer().getNutzerOrt();
        String companyWebsite = "http://www.companywebsite.com";
//        String companyWebsite = getUnternehmenDTO().getWebsite();//ToDo DTO
        String reviews = " (" + nrOfReviews + " Reviews)";
        setupStars(starsRating, ratingLayout);
//Set up Fields:
        descriptionTextArea.setValue(companyDescription);
        gruendung.setValue(getUnternehmenDTO().getGruendung());

/*
        Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");//ToDo put at top
        H2 firmName = new H2("Firm Name");
        String companyDescription = "Company Description";
        long nrOfReviews = 123;
        HorizontalLayout ratingLayout = new HorizontalLayout();//ToDo refactored
        int starsRating = 2;
        int nrOfEmployees = 123;

        String companyLocation = "Company Location";
        String companyWebsite = "http://www.companywebsite.com";

        String reviews =" ("+nrOfReviews+" Reviews)";
        setupStars(starsRating, ratingLayout);
*/


        // Logo Upload
        Upload logoUpload = new Upload();
        logoUpload.setAcceptedFileTypes("image/*");
        logoUpload.addSucceededListener(event -> {
            // Logic to save the uploaded logo
            // Datenbank ...???
        });

        // Logo, Company Name, and Edit Firm Profile Button
        HorizontalLayout buttonsLayout = new HorizontalLayout();

        HorizontalLayout logoAndEditLayout = new HorizontalLayout();
        Div logoAndName = new Div();
//        Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");//ToDo put at top
        //companyLogo.setWidth("150px");
        logoAndName.add(companyLogo);
//        logoAndName.add(new H2("Firm Name"));//ToDo put at top, refactored
        logoAndName.add(firmName);//ToDo put at top, refactored
        logoAndEditLayout.add(logoAndName);

        /*Button editButton = new Button("Edit firm profile");
        editButton.addClickListener(e -> {
            // Logic to navigate to the edit profile view
            UI.getCurrent().navigate(UEditFirmProfileDisplayView.class);
        });
        logoAndEditLayout.add(editButton);*/

        //Save Button
        Button saveButton = new Button("Save Changes");
        saveButton.addClickListener(e -> {
            UnternehmenDTO newUnternehmenDTO = newUnternehmenDTOFromFields();
            unternehmenService.saveUnternehmen(newUnternehmenDTO);
            UI.getCurrent().getPage().reload();
            // Logic to save changes made to the firm profile
            // Implement your saving logic here
        });

        // Company description Text Area
//        TextArea descriptionTextArea = new TextArea("Company Description");//ToDo Refactored
//        descriptionTextArea.setValue(companyDescription);
//        TextArea descriptionTextArea = new TextArea(companyDescription);//ToDo Refactored
        descriptionTextArea.setWidth("100%");
        descriptionTextArea.setHeight("200px");
        add(buttonsLayout);
        buttonsLayout.add(logoAndEditLayout);
        buttonsLayout.add(saveButton);

        // Rating with Number of Reviews
//        HorizontalLayout ratingLayout = new HorizontalLayout();//ToDo refactored
//        ratingLayout.add(starsRating);//Refactored
//        ratingLayout.add(new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR));//Refactored
//        ratingLayout.add(new Span(" (123 Reviews)"));//ToDo Refactored
        ratingLayout.add(new Span(reviews));//ToDo Refactored
        add(ratingLayout);


        // Company Location, Number of Employees, and Company Website (Editable Fields)
        TextField locationField = new TextField("Company Location");
//        locationField.setValue("Your Company's Location");//ToDo changed
        locationField.setValue(companyLocation);

        TextField employeesField = new TextField("Number of Employees");
//        employeesField.setValue("Number of Employees");//ToDo changed
        employeesField.setValue(String.valueOf(nrOfEmployees));

        TextField websiteField = new TextField("Company Website");
//        websiteField.setValue("http://www.companywebsite.com");//ToDo changed
        websiteField.setValue(companyWebsite);

        add(locationField, employeesField, websiteField);

        add(descriptionTextArea, gruendung);

        // Job Advertisements - Grid for Displaying Job Postings
//        Grid<Stelle> jobGrid = new Grid<>();
//        jobGrid.addColumn(Stelle::getStelleTitel).setHeader("Job title");
//        jobGrid.addColumn(Stelle::getStelleBeschreibung).setHeader("Job description");
//        jobGrid.addColumn(Stelle::getStelleOrt).setHeader("Location");

//        List<Stelle> stellenanzeigen = createDummyStellenanzeigen();
//        jobGrid.setItems(stellenanzeigen);
//
//        jobGrid.addItemClickListener(event -> {
//            Stelle selectedStelle = event.getItem();
//            if (selectedStelle != null) {
//                UI.getCurrent().navigate(UEditFirmProfileDisplayView.class);
//            }
//
//        });
//        add(jobGrid);
    }

//    private List<Stelle> createDummyStellenanzeigen() {
//        List<Stelle> dummyStellenanzeigen = new ArrayList<>();
//        for (int i = 1; i <= 5; i++) {
//            Stelle stelle = new Stelle();
//            stelle.setStelleId(i);
//            stelle.setStelleTitel("Job " + i);
//            stelle.setStelleBeschreibung("Description " + i);
//            stelle.setStelleOrt("Location " + i);
//            dummyStellenanzeigen.add(stelle);
//        }
//        return dummyStellenanzeigen;
//    }
}
