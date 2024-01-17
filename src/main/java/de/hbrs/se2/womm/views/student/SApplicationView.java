package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.model.ApplicationStatus;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.services.ImageService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
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
    private final StelleService stelleService;
    private BewerbungDTO bewerbung;
    private String bewerbungText;
    private StudentDTO student;
    private StelleDTO stelleDTO;
    private Long studentID;
    private String studentName;
    private String studentVorname;

    public SApplicationView(BewerbungService bewerbungService, StudentService studentService, StelleService stelleService) {
        super();
        this.bewerbungService = bewerbungService;
        this.studentService = studentService;
        this.stelleService = stelleService;
    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter Long bewerbungID) {
        if (bewerbungID != null) {
            Optional<BewerbungDTO> fetchedBewerbung = bewerbungService.getById(bewerbungID);
            fetchedBewerbung.ifPresent(bewerbungDTO -> this.bewerbung = bewerbungDTO);
            Optional<StelleDTO> checkStelleDTO = stelleService.getById(bewerbung.getBewerbungStelle().getStelleId());
            this.stelleDTO = checkStelleDTO.orElse(null);
            setUpApplication();
        } else {
            setup404Page();
        }
    }

    void setUpApplication() {
        bewerbungText = bewerbung.getBewerbungText();
        studentID = bewerbung.getBewerbungStudent().getStudentId();
        Optional<StudentDTO> fetchedStudent = studentService.getById(studentID);
        fetchedStudent.ifPresent(studentDTO -> student = studentDTO);
        studentName = student.getStudentName();
        studentVorname = student.getStudentVorname();
        setUpTop();
        String status = bewerbung.getBewerbungStatus();
        setUpStatus(status);
        setUpAnschreiben();
    }

    private void setUpTop() {
        setUpHeader();
        setUpStellenanzeige();
    }

    private void setUpAnschreiben() {
        add(new H3(getWommBuilder().translateText("Your motivational letter:")));
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
            Icon icon = new Icon(VaadinIcon.HOURGLASS_START);
            icon.setColor("orange");
            layout.add(icon);
            text = new H3(getWommBuilder().translateText("Your application is awaiting review."));
            text.getStyle().setColor("orange");
            layout.add(text);
        }
        add(layout);
    }

    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        ImageService imageService = new ImageService();
        Image i = imageService.getRandomImageHeight(100);
        header.add(i);
        String unternehmenName = this.stelleDTO.getUnternehmen().getName();
        H1 name = new H1(unternehmenName);
        name.addClickListener(e -> UI.getCurrent()
                .navigate(ROUTING.STUDENT.SFirmProfileDisplayView + "/" + stelleDTO.getUnternehmen().getUnternehmenId()));
        name.getStyle().set("cursor", "pointer");
        header.add(name);
        add(header);
    }

    private void setUpStellenanzeige() {
        VerticalLayout stellenanzeige = new VerticalLayout();
        HorizontalLayout ortLayout = new HorizontalLayout();
        Icon ortsIcon = VaadinIcon.PIN.create();
        ortLayout.add(ortsIcon);
        Text ort = new Text(this.stelleDTO.getStelleOrt());
        ortLayout.add(ort);
        stellenanzeige.add(ortLayout);
        HorizontalLayout linkLayout = new HorizontalLayout();
        Icon linkIcon = VaadinIcon.LINK.create();
        linkLayout.add(linkIcon);
        Anchor website = new Anchor();
        String url = this.stelleDTO.getStelleWebsite();
        website.setText(url);
        linkLayout.add(website);
        stellenanzeige.add(linkLayout);
        Div beschreibung = new Div();
        beschreibung.getStyle().set("margin-top", "20px");
        H3 titel = new H3();
        String stelleTitel = this.stelleDTO.getStelleTitel();
        titel.setText(stelleTitel);
        beschreibung.add(titel);
        List<String> paragraphs = List.of(this.stelleDTO.getStelleBeschreibung().split("\n\n"));
        paragraphs.forEach(paragraph -> {
            List.of(paragraph.split("\n")).forEach(subParagraph -> {
                Paragraph newParagraph = new Paragraph();
                newParagraph.setWidthFull();
                newParagraph.setText(subParagraph);
                beschreibung.add(newParagraph);
            });
            beschreibung.add(new Html("<br>"));
        });

        stellenanzeige.add(beschreibung);

        add(stellenanzeige);

    }
    private void setup404Page() {
        add(new H1("404 Not Found! :("));
    }
}
