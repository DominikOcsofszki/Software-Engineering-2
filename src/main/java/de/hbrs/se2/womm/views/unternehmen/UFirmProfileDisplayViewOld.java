package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.controller.UnternehmenController;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.AbstractViewDTObyNutzerID;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.ArrayList;
import java.util.List;

@Route(value = ROUTING.UNTERNEHMEN.UFirmProfileDisplayView+"old", layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("FirmProfileDisplayView")
//public class UFirmProfileDisplayView extends VerticalLayout {
public class UFirmProfileDisplayViewOld extends AbstractViewDTObyNutzerID<UnternehmenController, UnternehmenDTO> {
    private long aktuelleNutzerID;
    private UnternehmenDTO unternehmenDTO;
    public UFirmProfileDisplayViewOld(UnternehmenService unternehmenService, StelleController stelleController, SecurityService securityService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        setUp();
//        add(new FilterGridStelleByLoggedInNutzerId(stelleController, selectNutzerIDfromLoggedInForDB()));
    }
        private void setUp(){

        // Logo, Company Name, Subscribe and Chat Button
        HorizontalLayout buttonsLayout = new HorizontalLayout();

        // Logo, Company Name, Subscribe and Chat Buttons
        HorizontalLayout logoAndSubscribeLayout = new HorizontalLayout();
        Div logoAndName = new Div();
        Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");
        // Image companyLogo = new Image("themes/theme_1/logo_placeholder.png", "");
        companyLogo.setWidth("150px"); // Adjust the width as needed
        logoAndName.add(companyLogo);
        logoAndName.add(new H2("Firm Name")); // Replace with the actual company name
        logoAndSubscribeLayout.add(logoAndName);

        // Edit Button
        Button editButton = new Button("Edit firm profile");
        editButton.addClickListener(e -> {
            // Logic to navigate to the edit profile view
            UI.getCurrent().navigate(UEditFirmProfileDisplayViewOld.class);
        });

//        // Subscribe Button
//        Button subscribeButton = new Button("Subscribe");
//        subscribeButton.addClickListener(e -> {
//            // Logic for subscription
//            // You can implement the subscription logic here
//            Notification.show("Subscribed!");
//        }); //ToDo Delete since only for student
//        logoAndSubscribeLayout.add(subscribeButton);
//
//        // Chat Button
//        Button chatButton = new Button("Chat");
//        chatButton.addClickListener(e -> {
//            // Logic for opening a chat
//            Notification.show("Opening Chat...");
//        }); //ToDo Delete since only for student
//

        add(buttonsLayout);
        buttonsLayout.add(logoAndSubscribeLayout);
        buttonsLayout.add(editButton);
//        buttonsLayout.add(chatButton);

        // Rating with Number of Reviews
        HorizontalLayout ratingLayout = new HorizontalLayout();
        ratingLayout.add(new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR));
        ratingLayout.add(new Span(" (123 Reviews)")); // Replace with the actual number of reviews
        add(ratingLayout);

        // Company Location, Number of Employees, and Company Website
        HorizontalLayout detailsLayout = new HorizontalLayout();

        // Company Location with Geo Tag Icon
        HorizontalLayout locationLayout = new HorizontalLayout();
        locationLayout.add(new Icon(VaadinIcon.LOCATION_ARROW_CIRCLE_O), new Span("Company Location")); // Replace with the actual location
        detailsLayout.add(locationLayout);

        // Number of Employees
        HorizontalLayout employeesLayout = new HorizontalLayout();
        employeesLayout.add(new Icon(VaadinIcon.USERS), new Span("Number of Employees: 100")); // Replace with the actual number of employees
        detailsLayout.add(employeesLayout);

        // Link to Company Website with Icon
        HorizontalLayout websiteLayout = new HorizontalLayout();
        Icon linkIcon = new Icon(VaadinIcon.EXTERNAL_LINK);
        linkIcon.setColor(""); // Set the color as needed #hex vaadin blue ????
        websiteLayout.add(linkIcon, new Anchor("http://www.companywebsite.com", "Company Website"));
        detailsLayout.add(websiteLayout);

        add(detailsLayout);
        // Company Description
        Paragraph companyDescription = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        add(companyDescription);

        // Job Advertisements - Grid zur Anzeige der Stellenanzeigen
        Grid<Stelle> jobGrid = new Grid<>();

        //jobGrid.addColumn(i -> new Image(ASSETS.IMG.IMG11, "Firmen Logo Hier")).setHeader("Preview");
        //jobGrid.addComponentColumn(person -> new Image(person.getImageUrl(), "alt text")).setHeader("Preview"); // Valeska
        jobGrid.addColumn(Stelle::getStelleTitel).setHeader("Job title");
        jobGrid.addColumn(Stelle::getStelleTitel).setHeader("Job description");
        jobGrid.addColumn(Stelle::getStelleOrt).setHeader("Location");


        List<Stelle> stellenanzeigen = createDummyStellenanzeigen(); // Annahme: Methode zum Erstellen von Dummy-Stellenanzeigen
        jobGrid.setItems(stellenanzeigen);

        jobGrid.addItemClickListener(event -> {
            Stelle selectedStelle = event.getItem();
            if (selectedStelle != null) {
                UI.getCurrent().navigate(UApplicationView.class);
            }
        });

        add(jobGrid);
    }
    // Dummy-Stellenanzeigen erstellen (nur für Testzwecke)
    private List<Stelle> createDummyStellenanzeigen() {
        List<Stelle> dummyStellenanzeigen = new ArrayList<>();
        // Hier könntest du echte Stellenanzeigen aus einer Datenquelle laden oder Dummy-Daten verwenden
        for (int i = 1; i <= 5; i++) {
            Stelle stelle = new Stelle();
            stelle.setStelleId(i);
            stelle.setStelleTitel("Job " + i);
            stelle.setStelleTitel("Description " + i);
            stelle.setStelleOrt("Location " + i);
            // Weitere Stellenanzeigen-Eigenschaften setzen
            dummyStellenanzeigen.add(stelle);
        }
        return dummyStellenanzeigen;
    }
}
