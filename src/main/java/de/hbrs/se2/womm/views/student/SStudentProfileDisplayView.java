package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

    //SetUp Data
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
    private long aktuelleNutzerID;

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
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.studentDTO = studentService.getByNutzerId(aktuelleNutzerID);
        setUpDataFromDTO();
        //ToDo Work with this!!! this.studentDTO
        Header();
        Profil();
    }

    private void Header() {
        HorizontalLayout header = new HorizontalLayout();
//        Button b = new Button("Home");
        Button b = getWommBuilder().Button.create("Home");
        header.add(b);
        b.addClickListener(e -> UI.getCurrent().navigate(SHomepageStudentView.class));//ToDo refactor to homepage
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//        b = new Button("Start Chatting");//ToDo Remove since chat with yourself???
//        b.addClickListener( e -> UI.getCurrent().navigate(SChatView.class));
//        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        header.add(b);
        b.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
        add(header);
    }

    private void Profil() {
        ////////////////////////Profilbild////////////////////////////////////////////////////////////////////////////////
        HorizontalLayout header = new HorizontalLayout();
        //Image i = new Image("themes/theme_1/user.png", "Image not found");
        Image i = studentProfilbild;
        i.setWidth("20%");
        i.setHeight("20%");
        //i.setHeight(300, Unit.PIXELS); //for fixed values
        header.add(i);
        ////////////////////////Name////////////////////////////////////////////////////////////////////////////////////
        VerticalLayout headervert = new VerticalLayout();
        VerticalLayout headervert2 = new VerticalLayout();
//        Span s = new Span("Name");
        Span s = getWommBuilder().Span.create("Name");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
//        Span s1 = new Span("Paul Stein");
        Span s1 = new Span( studentVorname+ " " + studentName);
        s1.getElement().getStyle().set("font-size", "45px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////Alias////////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("alias");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
        s1 = new Span("psteins2");
        //s1 = new Span(studentAlias);
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////Geburtstag///////////////////////////////////////////////////////////////////////////////
//        s = new Span("Geburtstag");
        s = getWommBuilder().Span.create("Date of Birth");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
//        s1 = new Span("01.01.2002");
        s1 = new Span(studentGeburtstag);

        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////////E-Mail//////////////////////////////////////////////////////////////////////////////////
//        s = new Span("E-Mail");
        s = getWommBuilder().Span.create("e-mail");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
//        s1 = new Span("p_stein@email.de");
        s1 = new Span(studentEmail);
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
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
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
        s1 = new Span(studentOrt);
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
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
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
        //s1 = new Span("2018 nach dem Abitur, Ausbildung als Einzelhandeskaufmann, 2021 nach der Ausbildung angestellt als Einzelhandelskaufmann, Seit 2022 Vollzeit-Informatikstudent.");
        s1 = new Span(studentBiographie);
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
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
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
        //s1 = new Span("Windows-User, Social-Media-Plattformen, Officeprogramme, diverse IDEs: viel Java-Coding Erfahrung, mäßige C-Coding  Erfahrung");
        s1 = new Span(studentSpezialisierungen);
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
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
        s.getElement().getStyle().set("color", "#C4CBD3");      //color grey
        //s1 = new Span("3.");
        s1 = new Span(studentSemester);
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");     //color black
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
