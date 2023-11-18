package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.controller.OfferController;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.entities.StelleTag;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.Arrays;
import java.util.List;

@Route(value = ROUTING.STUDENT.SHomepageStudentView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("HomepageStudentView")
public class SHomepageStudentView extends VerticalLayout {
    //private List<String> currentTags1;
    //private List<String> currentTags2;
    public SHomepageStudentView() {
        setUpHeader();
        setUpBanner();
        setUpSearchFields();
        setUpBigCompanyAnnouncement();

    }

    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        //Buttons
        Button b1 = new Button("View subscriptions", new Icon(VaadinIcon.EYE));
        b1.addClickListener( e -> UI.getCurrent().navigate(SAboStudentView.class));
        header.add(b1);
        Button b2 = new Button("Notifications", new Icon(VaadinIcon.BELL));
        b2.addClickListener( e -> UI.getCurrent().navigate(SNotificationView.class));
        header.add(b2);
        Button b3 = new Button("Chat", new Icon(VaadinIcon.COMMENTS_O));
        b3.addClickListener( e -> UI.getCurrent().navigate(SChatView.class));
        header.add(b3);
        Button b4 = new Button("Edit profile", new Icon(VaadinIcon.PENCIL));
        b4.addClickListener( e -> UI.getCurrent().navigate(SCreateChangeStudentProfileView.class));
        header.add(b4);

        //header.add(new Button("Logout Studentname", new Icon(VaadinIcon.EXIT_O)));
        add(header);
        // Layout (letzten zwei buttons nach rechts)
        b4.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
    }

    private void setUpBanner() {
        VerticalLayout banner = new VerticalLayout();
        Image i = new Image("themes/theme_1/banner.jpg","https://unsplash.com/de/fotos/%EC%B2%AD%EB%A1%9D%EC%83%89-led-%ED%8C%A8%EB%84%90-EUsVwEOsblE");
        i.setWidth("100%");
        banner.add(i);
        add(banner);
    }

    private void setUpSearchFields() {
        HorizontalLayout searchFields = new HorizontalLayout();
        //Offer type
        MultiSelectComboBox filter1 = new MultiSelectComboBox("Offer type");
        filter1.setItems("Job offer", "Project", "Workshop", "Internship");
        filter1.setWidth("min-content");
        //currentTags1 = (List<String>) filter1.getSelectedItems();
        searchFields.add(filter1);
        //Industry
        MultiSelectComboBox filter2 = new MultiSelectComboBox("Industry");
        filter2.setWidth("min-content");
        filter2.setItems("Informationstechnologie (IT)", "Gesundheitswesen", "Finanzdienstleistungen", "Bildung",
                "Ingenieurwesen", "Marketing und Werbung", "Medien und Unterhaltung", "Verkauf und Vertrieb",
                "Gastgewerbe und Tourismus", "Rechtswesen", "Soziale Dienste und gemeinnützige Organisationen",
                "Fertigung und Produktion", "Transport und Logistik", "Bauwesen", "Energie und Umwelt",
                "Forschung und Entwicklung", "Design und Kunst", "Landwirtschaft", "Personalwesen", "Telekommunikation");
        //currentTags2 = (List<String>) filter2.getSelectedItems();

        searchFields.add(filter2);
        //Suchfeld
        TextField textField = new TextField();
        textField.setLabel("Firm or ad name");
        textField.setPlaceholder("Search");
        textField.setPrefixComponent(VaadinIcon.SEARCH.create());
        searchFields.add(textField);
        // Suche-Button
        Button b = new Button("Search", new Icon(VaadinIcon.SEARCH));
        searchFields.add(b);
        b.getElement().getStyle().set("margin-top", "auto");
        add(searchFields);
    }

    private void setUpBigCompanyAnnouncement() {
        VerticalLayout searchResults = new VerticalLayout();
        searchResults.add(new H2("Search Results"));
        searchResults.add(new Hr());
        //temp
        Stelle s1 = new Stelle();
        s1.setStelleId(1);
        s1.setStelleTitel("Softwareentwickler m/w/d");
        s1.setStelleOrt("Bonn");
        s1.setUnternehmen(new Unternehmen());
        s1.setStelleBeschreibung("beschreibungstext");
        s1.setStelleWebsite("www.beispiel.de");
        Stelle s2 = new Stelle();
        Stelle s3 = new Stelle();

        // filter mit currenTags?
        List<Stelle> ads = Arrays.asList(s1,s2,s3);;

        // Create a grid bound to the list
        Grid<Stelle> grid = new Grid<>();
        grid.setItems(ads);
        //grid.addColumn(Stelle::getStelleId).setHeader("ID"); // eher raus
        grid.addColumn(Stelle::getStelleTitel).setHeader("Stelle");
        grid.addColumn(Stelle::getStelleOrt).setHeader("Ort");
        grid.addColumn(Stelle::getUnternehmen).setHeader("Unternehmen");
        // add link firma?
        //grid.addColumn(Stelle::getStelleBeschreibung).setHeader("Beschreibung"); // vielleicht erst beim draufklicken
        grid.addColumn(Stelle::getStelleWebsite).setHeader("Website");
        grid.addItemClickListener(e -> UI.getCurrent().navigate(SJobProjectWorkshopDisplayView.class));

        searchResults.add(grid);
        add(searchResults);
    }
}
