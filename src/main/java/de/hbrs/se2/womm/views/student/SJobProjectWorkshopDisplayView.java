package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.model.ApplicationStatus;
import de.hbrs.se2.womm.services.*;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.Optional;

@Route(value = ROUTING.STUDENT.SJobProjectWorkshopDisplayView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("JobProjectWorkshopDisplayView")
public class SJobProjectWorkshopDisplayView extends AViewWomm implements HasUrlParameter<Long> {
    SecurityService securityService;
    StelleService stelleService;
    BewerbungService bewerbungService;
    StudentService studentService;
    StelleDTO stelleDTO;
    long stelleId;
    VerticalLayout applicationForm;
    boolean formToggle = false;

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter Long parameter) {
        if (parameter != null) {
            System.out.println("Parameter: " + parameter);
            this.stelleId = parameter;
            try {
                Optional<StelleDTO> checkStelleDTO = stelleService.getById(this.stelleId);
                if (checkStelleDTO.isEmpty()) {
                    System.out.println("StelleDTO ist null");
                    add(new H1("Keine Stelle in der DB für ID: "+this.stelleId+" gefunden"));
                } else {
                    this.stelleDTO = checkStelleDTO.get();
                    System.out.println("Parameter: " + parameter);
                    setUpBanner();
                    setUpHeader();
                    setUpStellenanzeige();
                    setUpButtons();
                }
            } catch (Exception e) {
                System.out.println(e);
                add(new H1("Keine Stelle gefunden"));
            }

        } else {
            add(new H1("Keine Stelle gefunden - Parameter ist null"));
        }

    }

    public SJobProjectWorkshopDisplayView(StelleService stelleService,
                                          SecurityService securityService,
                                          BewerbungService bewerbungService,
                                          StudentService studentService) {

        this.securityService = securityService;
        this.bewerbungService = bewerbungService;
        this.studentService = studentService;
        this.stelleService = stelleService;
        this.applicationForm = new VerticalLayout();
    }
    //ToDo Banner anpassen

    private void setUpBanner() {
        VerticalLayout banner = new VerticalLayout();
        Image i = new Image("themes/theme_1/banner.jpg", "https://unsplash.com/de/fotos/%EC%B2%AD%EB%A1%9D%EC%83%89-led-%ED%8C%A8%EB%84%90-EUsVwEOsblE");
        i.setWidth("100%");
        banner.add(i);
        add(banner);
    }

    //ToDo bestimmten FirmenNamen + FirmenLogo anzeigen

    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        ImageService imageService = new ImageService();

        //Logo
//        Image i = new Image(ASSETS.RANDOM.USER, "Alternative image text");
//        Image i = this.stelleDTO.getStelleUnternehmen().PlaceholderOrImage(); //ToDo Changed

//        Image i = imageService.getImage(this.stelleDTO.getStelleUnternehmen().getNutzer()); //ToDo Changed
//        Image i = imageService.test();
        Image i = imageService.getRandomImageHeight(100);
//        i.setWidth("25%");
        header.add(i);

        //Ueberschrift
//        header.add(new H1("Unternehmenname"));
        String unternehmenName = this.stelleDTO.getStelleUnternehmen().getName(); //ToDo Changed
        header.add(new H1(unternehmenName));
//        header.add(new H1("Unternehmenname"));
        add(header);
    }


    private void setUpStellenanzeige() {
        VerticalLayout stellenanzeige = new VerticalLayout();


        //ToDo bestimmete StelleTitel anzeigen
        //Textfeld StelleTitel
//        Paragraph titel = new Paragraph();
        Paragraph titel = new Paragraph();
        String stelleTitel = this.stelleDTO.getStelleTitel(); //ToDo Changed
        titel.setText(stelleTitel);
//        titel.setText("Werksstudenten-Stelle");

        stellenanzeige.add(titel);

        //ToDo bestimmete StelleOrt anzeigen
        //Textfeld StelleOrt
        Paragraph ort = new Paragraph();
        String stelleOrt = this.stelleDTO.getStelleOrt(); //ToDo Changed
        ort.setText(stelleOrt);
//        ort.setText("Bonn");

        stellenanzeige.add(ort);

        //ToDo bestimmete StelleOrt anzeigen
        //Textfeld StelleWebsite
        Paragraph website = new Paragraph();
        String stelleWebsite = this.stelleDTO.getStelleWebsite(); //ToDo Changed
        website.setText(stelleWebsite);
//        website.setText("https://www.google.com/");

        stellenanzeige.add(website);

        //ToDo bestimmte StelleBeschreibung anzeigen
        //Textfeld StelleBeschreibung
        Paragraph beschreibung = new Paragraph();
        beschreibung.setWidthFull();
        String stelleBeschreibung = this.stelleDTO.getStelleBeschreibung(); //ToDo Changed
        beschreibung.setText(stelleBeschreibung);
//        beschreibung.setText("Hier könnte ihre Werbung für einen ausbeutenden Job stehen.");

        stellenanzeige.add(beschreibung);

        add(stellenanzeige);

    }

    private void setUpButtons() {
        HorizontalLayout buttons = new HorizontalLayout();

        //ToDo Bewerbung für bestimmten Studenten öffnen
        //Erstellen-Button
        Button bewerbungButton = new Button(getWommBuilder().translateText("Apply now"), new Icon(VaadinIcon.PENCIL));
        bewerbungButton.addClickListener(e -> {
            if (formToggle) {
                applicationForm.removeAll();
                remove(applicationForm);
                bewerbungButton.setText(getWommBuilder().translateText("Apply now"));
                bewerbungButton.setIcon(new Icon(VaadinIcon.PENCIL));
                setFormToggle(!formToggle);
            } else {
                displayApplicationForm();
                bewerbungButton.setText(getWommBuilder().translateText("Apply later"));
                bewerbungButton.setIcon(new Icon(VaadinIcon.ANGLE_UP));
                setFormToggle(!formToggle);
            }
        });
        buttons.add(bewerbungButton);

        add(buttons);
    }

    private void displayApplicationForm() {
        applicationForm.setPadding(false);

        TextArea textArea = new TextArea();
        textArea.setPlaceholder(getWommBuilder().translateText("Write a short application here"));
        textArea.setWidthFull();
        textArea.setMinHeight("200px");

        applicationForm.add(textArea);

        //Erstellen-Button
        Button erstellenButton = new Button(getWommBuilder().translateText("Send"));
        erstellenButton.addClickListener(e -> {
            if (textArea.getValue().trim().isEmpty()) createErrorNotification(getWommBuilder().translateText("Please enter your application into the text field!"));
            else if (stelleService.getById(stelleId).isPresent()) {
                StelleDTO currentStelle = stelleService.getById(stelleId).get();
                long studentId = securityService.getLoggedInNutzerID();
                StudentDTO currentUser = studentService.getByNutzerId(studentId);
                var returned = bewerbungService.saveBewerbung(BewerbungDTO.builder()
                        .bewerbungStelle(currentStelle)
                        .bewerbungStudent(currentUser)
                        .bewerbungStatus(ApplicationStatus.PENDING.toString())
                        .bewerbungText(textArea.getValue()).build());
                if (returned != null) {
                    createSuccessNotification();
                }
            } else {
                createErrorNotification(getWommBuilder().translateText("The job offer is not available anymore :("));
            }
        });

        applicationForm.add(erstellenButton);

        add(applicationForm);
    }

    private void setFormToggle(boolean formToggle) {
        this.formToggle = formToggle;
    }

    private void createErrorNotification(String errorText) {
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        Div text = new Div(new Text(errorText));

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.addClickListener(e -> notification.close());

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();
    }

    private void createSuccessNotification() {
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

        Div text = new Div(getWommBuilder().Text.create(getWommBuilder().translateText("Deine Bewerbung wurde erfolgreich versendet")));

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.addClickListener(e -> {
            notification.close();
            UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
        });

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();
    }
}
