package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

@Route(value = ROUTING.UNTERNEHMEN.UFirmProfileDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("FirmProfileDisplayView")
public class UFirmProfileDisplayView extends AViewWomm {
    private UnternehmenDTO unternehmenDTO;
    private long aktuelleNutzerID;
    GridFilterStelle gridFilterStelle;

    public UFirmProfileDisplayView(UnternehmenService unternehmenService, StelleService stelleService, SecurityService securityService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        setUp();
        this.gridFilterStelle = new GridFilterStelle();
        List<StelleDTO> stelleDTOList = stelleService.getByNutzerId(aktuelleNutzerID);
        this.gridFilterStelle.setUpFromOutside(stelleDTOList);
        add(gridFilterStelle);
    }
    private String checkIfNullShowTextLink(String checkString){
        if(checkString == null) return "go to \"UEditFirmProfileDisplayView\" to add this information";
        return checkString;
    }



    private void setUp() {
        // Logo, Company Name, Subscribe and Chat Button
        HorizontalLayout buttonsLayout = new HorizontalLayout();

        // Logo, Company Name, Subscribe and Chat Buttons
        HorizontalLayout logoAndSubscribeLayout = new HorizontalLayout();
        Div logoAndName = new Div();
//            Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");
        Image companyLogo = unternehmenDTO.PlaceholderOrImage();
        // Image companyLogo = new Image("themes/theme_1/logo_placeholder.png", "");
        //companyLogo.setWidth("50px"); // Adjust the width as needed
        logoAndName.add(companyLogo);
        logoAndName.add(new H2(unternehmenDTO.getName())); // Replace with the actual company name
        logoAndSubscribeLayout.add(logoAndName);

        // Edit Button
        Button editButton = new Button("Edit firm profile");
        editButton.addClickListener(e -> {
            // Logic to navigate to the edit profile view
            UI.getCurrent().navigate(UEditFirmProfileDisplayView.class);
        });

        add(buttonsLayout);
        buttonsLayout.add(logoAndSubscribeLayout);
        buttonsLayout.add(editButton);

        // Rating with Number of Reviews
        HorizontalLayout ratingLayout = new HorizontalLayout();
        ratingLayout.add(new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR));
        ratingLayout.add(new Span(" (123 Reviews)")); // Replace with the actual number of reviews
//            ratingLayout.add(unternehmenDTO.getRating());
//            ratingLayout.add(new Span(unternehmenDTO.getNrOfReviews() + " Reviews"));
        add(ratingLayout);

        // Company Location, Number of Employees, and Company Website
        HorizontalLayout detailsLayout = new HorizontalLayout();

        // Company Location with Geo Tag Icon
        HorizontalLayout locationLayout = new HorizontalLayout();
        locationLayout.add(new Icon(VaadinIcon.MAP_MARKER), new Span(unternehmenDTO.getNutzer().getNutzerOrt())); // Replace with the actual location
//            locationLayout.add(new Icon(VaadinIcon.LOCATION_ARROW_CIRCLE_O), new Span("Company Location")); // Replace with the actual location
        detailsLayout.add(locationLayout);

        // Number of Employees
        HorizontalLayout employeesLayout = new HorizontalLayout();
//            employeesLayout.add(new Icon(VaadinIcon.USERS), new Span(unternehmenDTO.getNrOfEmplooyeeee())); // Replace with the actual number of employees
//            employeesLayout.add(new Icon(VaadinIcon.USERS), new Span("Number of Employees: 100")); // Replace with the actual number of employees
        employeesLayout.add(new Icon(VaadinIcon.USERS), new Span(checkIfNullShowTextLink(null))); // Replace with the actual number of employees

        detailsLayout.add(employeesLayout);

        // Link to Company Website with Icon
        HorizontalLayout websiteLayout = new HorizontalLayout();
        Icon linkIcon = new Icon(VaadinIcon.EXTERNAL_LINK);
        linkIcon.setColor(""); // Set the color as needed #hex vaadin blue ????
        websiteLayout.add(linkIcon, new Anchor(checkIfNullShowTextLink(null), checkIfNullShowTextLink(null)));
        detailsLayout.add(websiteLayout);

        add(detailsLayout);
        Paragraph companyDescription = new Paragraph(unternehmenDTO.getBeschreibung());
        add(companyDescription);
    }
}