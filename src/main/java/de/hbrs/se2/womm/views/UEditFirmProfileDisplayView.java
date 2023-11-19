package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.ArrayList;
import java.util.List;

@Route(value = ROUTING.UNTERNEHMEN.UEditFirmProfileDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("EditFirmProfileDisplayView")
public class UEditFirmProfileDisplayView extends VerticalLayout {
    public UEditFirmProfileDisplayView() {

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
        Image companyLogo = new Image(ASSETS.IMG.IMG9, "Firmen Logo Hier");
        companyLogo.setWidth("150px");
        logoAndName.add(companyLogo);
        logoAndName.add(new H2("Firm Name"));
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
            // Logic to save changes made to the firm profile
            // Implement your saving logic here
        });

        add(buttonsLayout);
        buttonsLayout.add(logoAndEditLayout);
        buttonsLayout.add(saveButton);

        // Rating with Number of Reviews
        HorizontalLayout ratingLayout = new HorizontalLayout();
        ratingLayout.add(new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR), new Icon(VaadinIcon.STAR));
        ratingLayout.add(new Span(" (123 Reviews)"));
        add(ratingLayout);

        // Company Location, Number of Employees, and Company Website (Editable Fields)
        TextField locationField = new TextField("Company Location");
        locationField.setValue("Your Company's Location");

        TextField employeesField = new TextField("Number of Employees");
        employeesField.setValue("Number of Employees");

        TextField websiteField = new TextField("Company Website");
        websiteField.setValue("http://www.companywebsite.com");

        add(locationField, employeesField, websiteField);

        // Job Advertisements - Grid for Displaying Job Postings
        Grid<Stelle> jobGrid = new Grid<>();
        jobGrid.addColumn(Stelle::getStelleTitel).setHeader("Job title");
        jobGrid.addColumn(Stelle::getStelleBeschreibung).setHeader("Job description");
        jobGrid.addColumn(Stelle::getStelleOrt).setHeader("Location");

        List<Stelle> stellenanzeigen = createDummyStellenanzeigen();
        jobGrid.setItems(stellenanzeigen);

        add(jobGrid);
    }

    private List<Stelle> createDummyStellenanzeigen() {
        List<Stelle> dummyStellenanzeigen = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Stelle stelle = new Stelle();
            stelle.setStelleId(i);
            stelle.setStelleTitel("Job " + i);
            stelle.setStelleBeschreibung("Description " + i);
            stelle.setStelleOrt("Location " + i);
            dummyStellenanzeigen.add(stelle);
        }
        return dummyStellenanzeigen;
    }
}
