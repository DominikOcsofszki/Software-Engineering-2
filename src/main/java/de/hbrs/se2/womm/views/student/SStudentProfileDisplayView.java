package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.STUDENT.SStudentProfileDisplayView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("StudentProfileDisplayView")
public class SStudentProfileDisplayView extends AViewWomm {
    StudentDTO studentDTO;
    String studentName;
    String studentVorname;
    String studentAlias = "do we need this???"; //ToDo in DTO?
    String studentGeburtstag;
    String studentEmail;
    String studentOrt;
    String studentBiographie;
    String studentSpezialisierungen;
    String studentSemester;
    Image studentProfilbild;

    private void setUpDataFromDTO() {
        studentName = studentDTO.getStudentName();
        studentVorname = studentDTO.getStudentVorname();
//        studentAlias = studentDTO.getStudentAlias(); //ToDo in DTO?
        studentGeburtstag = studentDTO.getStudentGeburtstag();
        studentEmail = studentDTO.getNutzer().getNutzerMail();
        studentOrt = studentDTO.getNutzer().getNutzerOrt();
        studentBiographie = studentDTO.getStudentBio();
        studentSpezialisierungen = studentDTO.getStudentSpezialisierung();
        studentSemester = String.valueOf(studentDTO.getStudentSemester());
        studentProfilbild = studentDTO.PlaceholderOrImage();
    }

    public SStudentProfileDisplayView(StudentService studentService, SecurityService securityService) {
        super();
        this.studentDTO = studentService.getByNutzerId(securityService.getLoggedInNutzerID());
        setUpDataFromDTO();
        Header();
        Profil();
    }

    private void Header() {
        HorizontalLayout header = new HorizontalLayout();;
        Button b = getWommBuilder().Button.create("Home");
        header.add(b);
        b.addClickListener(e -> UI.getCurrent().navigate(SHomepageStudentView.class));
//        b = new Button("Start Chatting");//ToDo Remove since chat with yourself???
//        b.addClickListener( e -> UI.getCurrent().navigate(SChatView.class));
        header.add(b);
        b.getElement().getStyle().set("margin-right", "auto");
        header.setWidth("100%");
        add(header);
    }

    private void Profil() {
        ////////////////////////Profilbild////////////////////////////////////////////////////////////////////////////////
        HorizontalLayout header = new HorizontalLayout();
        Image i = studentProfilbild;
        i.setWidth("20%");
        i.setHeight("20%");
        header.add(i);
        ////////////////////////Name////////////////////////////////////////////////////////////////////////////////////
        VerticalLayout headervert = new VerticalLayout();
        VerticalLayout headervert2 = new VerticalLayout();
        Span s = getWommBuilder().Span.create("Name");
        s.getElement().getStyle().set("font-size", "20px");
        Span s1 = new Span( studentVorname+ " " + studentName);
        s1.getElement().getStyle().set("font-size", "45px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////Alias////////////////////////////////////////////////////////////////////////////////////
        /*s = getWommBuilder().Span.create("alias");    //nicht im Backend implementiert
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span("psteins2");
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();*/
        ////////////////////////Geburtstag///////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Date of Birth");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentGeburtstag);
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////E-Mail//////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("e-mail");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentEmail);
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////Ort/////////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Location");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentOrt);
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        headervert.setWidth("50%");
        ////////////////////////Biographie///////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Biography");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentBiographie);
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////Spezialisierungen////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Specializations");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentSpezialisierungen);
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////Semester////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Current semester");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentSemester);
        s1.getElement().getStyle().set("font-size", "25px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        header.add(headervert);
        add(header);
    }
}
