package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Route(value = ROUTING.UNTERNEHMEN.UFirmProfileDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("FirmProfileDisplayView")
public class UFirmProfileDisplayView extends VerticalLayout {
    public UFirmProfileDisplayView() {
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
        linkIcon.setColor("grey"); // Set the color as needed
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

        // Job Advertisements
        Accordion jobAccordion = new Accordion();

        for (int i = 1; i <= 6; i++) {
            VerticalLayout jobLayout = createJobAdvertisementLayout(i);
            jobAccordion.add("Job Advertisement " + i, jobLayout);
        }

        add(jobAccordion);

        // Edit Button
        Button editButton = new Button("Edit Profile");
        editButton.addClickListener(e -> {
            // Logic to navigate to the edit profile view
            getUI().ifPresent(ui -> ui.navigate(ROUTING.UNTERNEHMEN.UEditFirmProfileDisplayView));
        });
        add(editButton);

        // Publish Time
        LocalDateTime publishTime = LocalDateTime.now().minus(13, ChronoUnit.HOURS);
        add(new Paragraph("Published " + calculateTimeSincePublish(publishTime) + " ago"));
    }

    private VerticalLayout createJobAdvertisementLayout(int jobNumber) {
        VerticalLayout jobLayout = new VerticalLayout();

        // Job Title
        jobLayout.add(new H3("Job Title " + jobNumber));

        // Company Name
        jobLayout.add(new Paragraph("Company Name"));

        // Location and Logo
        HorizontalLayout locationAndLogoLayout = new HorizontalLayout();
        locationAndLogoLayout.add(new Icon(VaadinIcon.LOCATION_ARROW_CIRCLE_O), new Span("Job Location " + jobNumber)); // Replace with the actual job location
        Image jobLogo = new Image("themes/theme1/job-logo.png", "");
        jobLogo.setWidth("50px"); // Adjust the width as needed
        locationAndLogoLayout.add(jobLogo);

        jobLayout.add(locationAndLogoLayout);

        // Job Description
        Details jobDetails = new Details("Job Description", new Paragraph("Job Description for Job " + jobNumber));
        jobLayout.add(jobDetails);

        return jobLayout;
    }

    private String calculateTimeSincePublish(LocalDateTime publishTime) {
        LocalDateTime currentTime = LocalDateTime.now();
        long hoursSincePublish = ChronoUnit.HOURS.between(publishTime, currentTime);
        if (hoursSincePublish < 1) {
            long minutesSincePublish = ChronoUnit.MINUTES.between(publishTime, currentTime);
            return minutesSincePublish + " minutes";
        } else {
            return hoursSincePublish + " hours";
        }
    }
}
