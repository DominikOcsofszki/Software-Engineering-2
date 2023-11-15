package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "SFirmProfileDisplayView", layout = StudentLayout.class)
@PageTitle("FirmProfileDisplayView")
@RolesAllowed({"UNTERNEHMEN", "ADMIN", "STUDENT"})
public class SFirmProfileDisplayView extends VerticalLayout {
    public SFirmProfileDisplayView() {
        // Header
        H1 header = new H1("Firm Profile");
        add(header);


        // Banner
        Div banner = new Div();
        banner.addClassName("company-banner");
        Image companyLogo = new Image("themes/theme1/womm_text_logo.png", "");
        companyLogo.setWidth("150px"); // Adjust the width as needed
        banner.add(companyLogo);
        banner.add(new H2("Firm Name")); // Replace with actual company name
        add(banner);

        // Content
        FormLayout contentLayout = new FormLayout();
        contentLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
        contentLayout.setWidth("50%"); // Adjust the width as needed

        // Add form fields or other components to display firm profile information
        contentLayout.addFormItem(new H2("Firm Name"), new Div()); // Replace Div() with an actual component displaying the firm name
        contentLayout.addFormItem(new H2("Description"), new Div()); // Replace Div() with an actual component displaying the firm description

        add(contentLayout);

        // Edit button
        Button editButton = new Button("Edit Profile");
        editButton.addClickListener(e -> {
            // Logic to navigate to the edit profile view
            getUI().ifPresent(ui -> ui.navigate("EditFirmProfileDisplayView"));
        });
        add(editButton);
    }
}
