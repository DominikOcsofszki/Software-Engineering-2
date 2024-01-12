package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.*;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.components.GridFilterBewerbungStudents;
import de.hbrs.se2.womm.views.extra.TEMPLATE;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.Arrays;
import java.util.List;

@Route(value = ROUTING.STUDENT.SApplicationsView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("ApplicationsView")
public class SApplicationsView extends VerticalLayout {

    StelleService stelleService;
    BewerbungService bewerbungService;
    StudentDTO studentDTO;
    List<BewerbungDTO> listOfBewerbungDTO;
    private long aktuelleNutzerID;


    public SApplicationsView(BewerbungService bewerbungService, StelleService stelleService, StudentService studentService, SecurityService securityService) {
        this.stelleService = stelleService;
        this.bewerbungService = bewerbungService;
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.studentDTO = studentService.getByNutzerId(aktuelleNutzerID);
        System.out.println(aktuelleNutzerID);
        this.listOfBewerbungDTO = bewerbungService.getByStudentNutzerId(aktuelleNutzerID);
        if (!listOfBewerbungDTO.isEmpty()) {
            System.out.println(this.listOfBewerbungDTO.get(0).getBewerbungStelle().getStelleTitel());
        }
        GridFilterBewerbungStudents gridFilterBewerbungStudent = new GridFilterBewerbungStudents();
        gridFilterBewerbungStudent.setUpFromOutside(listOfBewerbungDTO);


        setUpHeader();
        //setUpApplications();

        add(gridFilterBewerbungStudent);

    }


    private class demoInhaltSApplications {
        String unternehmen;
        String stelle;
        String status;

        String getUnternehmen() {
            return unternehmen;
        }

        String getStelle() {
            return stelle;
        }

        String getStatus() {
            return status;
        }

        demoInhaltSApplications(String unternehmen, String stelle, String status) {
            this.unternehmen = unternehmen;
            this.stelle = stelle;
            this.status = status;
        }
    }

    private void setUpHeader() {

        HorizontalLayout header = new HorizontalLayout();

        //Ueberschrift
        header.add(new H1("Bewerbungen:"));

        add(header);

    }

    private void setUpApplications() {

        VerticalLayout notification = new VerticalLayout();

        TextField searchField = new TextField();
        searchField.setWidth("50%");
        searchField.setPlaceholder("Suche");
        searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
        searchField.setValueChangeMode(ValueChangeMode.EAGER);

        List<demoInhaltSApplications> inhalt = Arrays.asList(
                new demoInhaltSApplications("Apple", "Software-Tester", "Offen"),
                new demoInhaltSApplications("Microsoft", "UI/UX-Designer", "Abgelehnt"),
                new demoInhaltSApplications("HBRS", "Programmierer", "Angenommen"),
                new demoInhaltSApplications("W.O.M.M", "Hausmeister", "Offen"));

        Grid<demoInhaltSApplications> grid = new Grid<>(demoInhaltSApplications.class, false);

        grid.setItems(inhalt);


        //ToDo Verlinkung zum entsprechenden Unternehmen anpassen

        grid.addColumn(demoInhaltSApplications::getUnternehmen).setHeader("Unternehmen").setWidth("40%");
        grid.addColumn(LitRenderer.<demoInhaltSApplications>of(TEMPLATE.LIT_TEMPLATE_HTML)
                .withProperty("id", demoInhaltSApplications::getStelle)
                .withFunction("clickHandler", person -> {
                    UI.getCurrent().navigate(SApplicationView.class);
                })).setHeader("Name").setWidth("40%").setSortable(true);
        grid.addColumn(demoInhaltSApplications::getStatus).setHeader("Status").setWidth("20%");
        notification.add(grid);
        grid.recalculateColumnWidths();

        notification.setWidth("100%");

        add(notification);
    }

}
