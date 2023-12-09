package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.extra.TEMPLATE;
import de.hbrs.se2.womm.views.layouts.AbstractViewWithoutController;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.Arrays;
import java.util.List;

@Route(value = ROUTING.STUDENT.SAboStudentView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("AboStudentView")
public class SAboStudentView extends AbstractViewWithoutController {

    public SAboStudentView() {
        setUpSearchFields();
        setUpSubscription();
    }

    private void setUpSearchFields() {
        HorizontalLayout searchFields = new HorizontalLayout();

        //Suchfeld
        H1 abonnements = getWommBuilder().H1.create("Subscriptions");
        searchFields.add(abonnements);
//        searchFields.add(new H1("Abonnements"));

        TextField textField = getWommBuilder().TextField.
                create("","Enter keyword");
//        TextField textField = new TextField();
        textField.focus();
//        textField.setPlaceholder("Stichwort eingeben");
        textField.setPrefixComponent(VaadinIcon.SEARCH.create());
        textField.setWidth("20%");
        //textField.setHeight(50, Unit.PIXELS);
        searchFields.add(textField);

        // Suche-Button
//        Button b = new Button("Search", new Icon(VaadinIcon.SEARCH));
        Button b = getWommBuilder().Button.create("Search", new Icon(VaadinIcon.SEARCH));
        searchFields.add(b);
        textField.getElement().getStyle().set("margin-left", "auto");
        searchFields.setWidthFull();
        add(searchFields);
    }

    private void setUpSubscription() {
        VerticalLayout notification = new VerticalLayout();

        //Todo Für Studenten zugehörige Benachrichtigungen anzeigen
        //ToDo demoInhalte ersetzen

        TextField searchField = new TextField();
        searchField.setWidth("50%");
        searchField.setPlaceholder("Suche");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchField.setValueChangeMode(ValueChangeMode.EAGER);

        Image image1 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image2 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image3 = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        Image image4 = new Image(ASSETS.RANDOM.USER, "Alternative image text");

        image1.setHeight(20, Unit.PIXELS);
        image2.setHeight(20, Unit.PIXELS);
        image3.setHeight(20, Unit.PIXELS);
        image4.setHeight(20, Unit.PIXELS);

        List<demoInhaltSubscription> inhalt = Arrays.asList(
                new demoInhaltSubscription(image1,"Apple", "Small Tech Companyar!"),
                new demoInhaltSubscription(image2,"Microsoft", "Another Small Tech Company"),
                new demoInhaltSubscription(image3,"HBRS", "Organisatorisches Wunder"),
                new demoInhaltSubscription(image4,"W.O.M.M", "Software Engineering 2 Team"));

        Grid<demoInhaltSubscription> grid = new Grid<>(demoInhaltSubscription.class, false);

        grid.setItems(inhalt);

        //ToDo Verlinkung zum entsprechenden Unternehmen anpassen

        grid.addComponentColumn(demoInhaltSubscription::getImage).setHeader("Logo").setWidth("5%");
        grid.addColumn(LitRenderer.<demoInhaltSubscription>of(TEMPLATE.LIT_TEMPLATE_HTML)
                .withProperty("id", demoInhaltSubscription::getName)
                .withFunction("clickHandler", person -> {
                    UI.getCurrent().navigate(SFirmProfileDisplayView.class);
                })).setHeader("Name").setWidth("25%").setSortable(true);
        grid.addColumn(demoInhaltSubscription::getMessage).setHeader("Beschreibung").setWidth("70%").getStyle().setFont("OpenSanse");
        notification.add(grid);
        grid.recalculateColumnWidths();

        notification.setWidth("100%");

        add(notification);
    }

    private class demoInhaltSubscription{
        Image image;
        String name;
        String message;

        Image getImage(){
            return image;
        }
        String getName(){
            return name;
        }
        String getMessage(){
            return message;
        }

        demoInhaltSubscription(Image image,String name, String message){
            this.image = image;
            this.name = name;
            this.message = message;
        }
    }



}
