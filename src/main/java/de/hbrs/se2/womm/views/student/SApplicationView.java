package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.model.ApplicationStatus;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;
import java.util.Optional;

@Route(value = ROUTING.STUDENT.SApplicationView, layout = StudentLayout.class)
@RolesAllowed({"ADMIN", "STUDENT"})
@PageTitle("ApplicationView")
public class SApplicationView extends AViewWomm implements HasUrlParameter<Long> {
    private final BewerbungService bewerbungService;
    private final StudentService studentService;
    private BewerbungDTO bewerbung;
    private String bewerbungText;
    private StudentDTO student;
    private Long studentID;
    private String studentName;
    private String studentVorname;
    //private byte[] studentProfilePicture;

    public SApplicationView(BewerbungService bewerbungService,
                            StudentService studentService) {
        super();
        this.bewerbungService = bewerbungService;
        this.studentService = studentService;
    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Long bewerbungID) {
        Optional<BewerbungDTO> fetchedBewerbung = bewerbungService.getById(bewerbungID);
        fetchedBewerbung.ifPresent(bewerbungDTO -> this.bewerbung = bewerbungDTO);
        setUpApplication();
    }

    void setUpApplication() {
        bewerbungText = bewerbung.getBewerbungText();

        studentID = bewerbung.getBewerbungStudent().getStudentId();
        Optional<StudentDTO> fetchedStudent = studentService.getById(studentID);
        fetchedStudent.ifPresent(studentDTO -> student = studentDTO);
        fetchedStudent.ifPresent(studentDTO -> student = studentDTO);
        studentName = student.getStudentName();
        studentVorname = student.getStudentVorname();
        //studentProfilePicture = student.getNutzer().getNutzerProfilbild();

        setUpTop();

        String status = bewerbung.getBewerbungStatus();
        setUpStatus(status);

        setUpAnschreiben();

    }

    private void setUpTop() {
        HorizontalLayout top = new HorizontalLayout();
        top.setAlignItems(FlexComponent.Alignment.CENTER);
        top.setJustifyContentMode(JustifyContentMode.AROUND);
        Image image = new Image(ASSETS.IMG.IMG8, "placeholder");
        image.setWidth(200, Unit.PIXELS);
        image.setHeight(200, Unit.PIXELS);
        image.getStyle().set("border", "1px solid grey");
        image.getStyle().set("border-radius", "5px");
        top.add(image);
        H3 name = new H3(String.format("%s, %s", studentName, studentVorname));
        name.getStyle().set("cursor", "pointer");
        top.add(name);
        add(top);
    }

    private void setUpAnschreiben() {
        VerticalLayout anschreiben = new VerticalLayout();
        List.of(bewerbungText.split("\n\n")).forEach(paragraph -> {
            List.of(paragraph.split("\n")).forEach(subParagraph -> {
                Paragraph newParagraph = new Paragraph(subParagraph);
                anschreiben.add(newParagraph);
            });
        });
        add(anschreiben);
    }

    private void setUpDoesNotExist() {
        //TODO
    }

    private void setUpStatus(String bewerbungStatus) {
        HorizontalLayout layout = new HorizontalLayout();
        H3 text;
        if (ApplicationStatus.AKZEPTIERT.toString().equals(bewerbungStatus)) {
            Icon icon = new Icon(VaadinIcon.CHECK_CIRCLE);
            icon.setColor("green");
            layout.add(icon);
            text = new H3(getWommBuilder().translateText("Your application has been accepted."));
            text.getStyle().setColor("green");
            layout.add(text);
        } else if (ApplicationStatus.ABGELEHNT.toString().equals(bewerbungStatus)) {
            Icon icon = new Icon(VaadinIcon.CLOSE_CIRCLE);
            icon.setColor("red");
            layout.add(icon);
            text = new H3(getWommBuilder().translateText("Your application has been delcined."));
            text.getStyle().setColor("red");
            layout.add(text);
        } else if (ApplicationStatus.AUSSTEHEND.toString().equals(bewerbungStatus)) {
            /*
            Icon icon = new Icon(VaadinIcon.CHECK_CIRCLE);
            icon.setColor("green");
            layout.add(icon);
             */
            text = new H3(getWommBuilder().translateText("Your application is awaiting review."));
            layout.add(text);
        }
        add(layout);
    }
}
