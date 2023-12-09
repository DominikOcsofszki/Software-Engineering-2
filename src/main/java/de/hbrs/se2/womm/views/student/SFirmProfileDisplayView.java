package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.controller.UnternehmenController;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.views.unternehmen.UEditFirmProfileDisplayViewOld;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;
import javassist.NotFoundException;
import tools.generate.GenerateUnternehmenDTO;

import java.util.ArrayList;
import java.util.List;

@Route(value = ROUTING.STUDENT.SFirmProfileDisplayView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("FirmProfileDisplayView")
public class SFirmProfileDisplayView extends VerticalLayout implements HasUrlParameter<String> {

    private String parameter;
    UnternehmenController unternehmenController;
    UnternehmenDTO unternehmenDTO = GenerateUnternehmenDTO.generateUnternehmenDTO(1).get(0);
    long unternehmenId = 1;
    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        this.parameter = parameter;
        if(this.parameter != null) this.unternehmenId = Long.parseLong(this.parameter);
        System.out.println("Parameter: " + this.parameter);
        try {
            this.unternehmenDTO = setUpUnternehmenDTO(this.unternehmenId);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private UnternehmenDTO setUpUnternehmenDTO(long id) throws NotFoundException {
        return unternehmenController.getUnternehmenById(id).getBody();
    }

    public SFirmProfileDisplayView(UnternehmenController unternehmenController) {
        this.unternehmenController=unternehmenController;
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

        // Subscribe Button
        Button subscribeButton = new Button("Subscribe");
        subscribeButton.addClickListener(e -> {
            // Logic for subscription
            // You can implement the subscription logic here
            Notification.show("Subscribed!");
        });
        logoAndSubscribeLayout.add(subscribeButton);

        // Chat Button
        Button chatButton = new Button("Chat");
        chatButton.addClickListener(e -> {
            // Logic for opening a chat
            Notification.show("Opening Chat...");
        });

        add(buttonsLayout);
        buttonsLayout.add(logoAndSubscribeLayout);
        buttonsLayout.add(chatButton);

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
        linkIcon.setColor(""); // Set the color as needed
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
                UI.getCurrent().navigate(UEditFirmProfileDisplayViewOld.class);
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






//package de.hbrs.se2.womm.views;
//
//import com.vaadin.flow.component.formlayout.FormLayout;
//import com.vaadin.flow.component.html.*;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import de.hbrs.se2.womm.views.layouts.ROUTING;
//import de.hbrs.se2.womm.views.layouts.StudentLayout;
//import jakarta.annotation.security.RolesAllowed;
//
//@Route(value = ROUTING.STUDENT.SFirmProfileDisplayView, layout = StudentLayout.class)
//@RolesAllowed({ "ADMIN", "STUDENT"})
//@PageTitle("FirmProfileDisplayView")
//public class SFirmProfileDisplayView extends VerticalLayout {
//    public SFirmProfileDisplayView() {
//        // Header
//        H1 header = new H1("Firm Profile");
//        add(header);
//
//
//        // Banner
//        Div banner = new Div();
//        banner.addClassName("company-banner");
//        Image companyLogo = new Image("themes/theme_1/Womm_text_logo.png", "");
//        companyLogo.setWidth("150px"); // Adjust the width as needed
//        banner.add(companyLogo);
//        banner.add(new H2("Firm Name")); // Replace with actual company name
//        add(banner);
//
//        // Content
//        FormLayout contentLayout = new FormLayout();
//        contentLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
//        contentLayout.setWidth("50%"); // Adjust the width as needed
//
//        // Add form fields or other components to display firm profile information
//        contentLayout.addFormItem(new H2("Firm Name"), new Div()); // Replace Div() with an actual component displaying the firm name
//        contentLayout.addFormItem(new H2("Description"), new Div()); // Replace Div() with an actual component displaying the firm description
//
//        add(contentLayout);
//
//        // Edit button
////        Button editButton = new Button("Edit Profile");
////        editButton.addClickListener(e -> {
////            // Logic to navigate to the edit profile view
////            getUI().ifPresent(ui -> ui.navigate("EditFirmProfileDisplayView"));
////        }); //ToDo commented out since only available for Unternehmen
////        add(editButton);
//    }
//}
