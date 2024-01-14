package de.hbrs.se2.womm.views.student;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.components.GridFilterStelle;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;
@Route(value = ROUTING.STUDENT.SHomepageStudentView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("HomepageStudentView")
public class SHomepageStudentView extends AViewWomm {
    StelleService stelleService;
    StudentDTO studentDTO;
    private long aktuelleNutzerID;
    private GridFilterStelle gridFilterStelle;
    public SHomepageStudentView(StelleService stelleService, StudentService studentService, SecurityService securityService) {
        super();
        this.stelleService = stelleService;
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.studentDTO = studentService.getByNutzerId(aktuelleNutzerID);
        this.gridFilterStelle = new GridFilterStelle();
        this.gridFilterStelle.setUpFromOutside(stelleService.getAllByFilter("",""));
        this.gridFilterStelle.setColumnClickListener(ROUTING.STUDENT.SJobProjectWorkshopDisplayView);
        setUpHeader();
        setUpSearchFields();
        add(this.gridFilterStelle);
    }
    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        String button1 = getWommBuilder().translateText("View subscriptions");
        Button b1 = new Button(button1, new Icon(VaadinIcon.EYE));
        b1.addClickListener(e -> UI.getCurrent().navigate(SAboStudentView.class));
        header.add(b1);
        String button2 = getWommBuilder().translateText("Notifications");
        Button b2 = new Button(button2, new Icon(VaadinIcon.BELL));
        b2.addClickListener(e -> UI.getCurrent().navigate(SNotificationView.class));
        header.add(b2);
        String button3 = getWommBuilder().translateText("Chat");
        Button b3 = new Button(button3, new Icon(VaadinIcon.COMMENTS_O));
        b3.addClickListener(e -> UI.getCurrent().navigate(SChatView.class));
        header.add(b3);
        String button4 = getWommBuilder().translateText("Edit profile");
        Button b4 = new Button(button4, new Icon(VaadinIcon.PENCIL));
        b4.addClickListener(e -> UI.getCurrent().navigate(SCreateChangeStudentProfileView.class));
        header.add(b4);
        add(header);
        b4.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
    }
    private void setUpSearchFields() {
    }
}
