package de.hbrs.se2.womm.views.sonardupplicates;

import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import de.hbrs.se2.womm.views.unternehmen.UStelleAnzeigeErstellenView;
import jakarta.annotation.security.RolesAllowed;

import java.util.Optional;
@Route(value = ROUTING.UNTERNEHMEN.EditUJobProjectWorkshopDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("EditUJobProjectWorkshopDisplayView")
public class EditUJobProjectWorkshopDisplayView extends UStelleAnzeigeErstellenView implements HasUrlParameter<String> {
    StelleService stelleService;
    public EditUJobProjectWorkshopDisplayView(StelleService stelleService, UnternehmenService unternehmenService, SecurityService securityService, AboStudentUnternehmenService aboStudentUnternehmenService ) {
        super(stelleService, unternehmenService, securityService, aboStudentUnternehmenService);
        this.stelleService = stelleService;
    }

//    SecurityService securityService;
//    StelleService stelleService;
//    BewerbungService bewerbungService;
//    StudentService studentService;
//    StelleDTO stelleDTO;
//    long stelleId;
//    VerticalLayout applicationForm;
//    boolean formToggle = false;
//
//    public EditUJobProjectWorkshopDisplayView(StelleService stelleService,
//                                              SecurityService securityService,
//                                              BewerbungService bewerbungService,
//                                              StudentService studentService) {
//
//        this.securityService = securityService;
//        this.bewerbungService = bewerbungService;
//        this.studentService = studentService;
//        this.stelleService = stelleService;
//        this.applicationForm = new VerticalLayout();
//    }
//
    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
            Optional<StelleDTO> getCurrentStelleForEdit = stelleService.getById(Long.valueOf(parameter));
//            getCurrentStelleForEdit.ifPresent(this::setUpFieldForEdit);
            if(getCurrentStelleForEdit.isPresent())setUpFieldForEdit(getCurrentStelleForEdit.get());
        }
    }
//
//    private void setUpHeader() {
//        HorizontalLayout header = new HorizontalLayout();
//        ImageService imageService = new ImageService();
//        Image i = imageService.getRandomImageHeight(100);
//        header.add(i);
//        String unternehmenName = this.stelleDTO.getUnternehmen().getName(); //ToDo Changed
//        H1 name = new H1(unternehmenName);
//        if(securityService.isUserStudent()) {
//            String routingToUnternehmenWebsite = ROUTING.STUDENT.SFirmProfileDisplayView;
//            name.addClickListener(e -> UI.getCurrent()
//                    .navigate(routingToUnternehmenWebsite+ "/" + stelleDTO.getUnternehmen().getUnternehmenId()));
//            name.getStyle().set("cursor", "pointer");
//        }
//        header.add(name);
//        add(header);
//    }
//
//    private void setUpStellenanzeige() {
//        VerticalLayout stellenanzeige = new VerticalLayout();
//        HorizontalLayout ortLayout = new HorizontalLayout();
//        Icon ortsIcon = VaadinIcon.PIN.create();
//        ortLayout.add(ortsIcon);
//        Text ort = new Text(this.stelleDTO.getStelleOrt());
//        ortLayout.add(ort);
//        stellenanzeige.add(ortLayout);
//        HorizontalLayout linkLayout = new HorizontalLayout();
//        Icon linkIcon = VaadinIcon.LINK.create();
//        linkLayout.add(linkIcon);
//        Anchor website = new Anchor();
//        String url = this.stelleDTO.getStelleWebsite();
//        website.setText(url);
//        linkLayout.add(website);
//        stellenanzeige.add(linkLayout);
//        Div beschreibung = new Div();
//        beschreibung.getStyle().set("margin-top", "20px");
//        H3 titel = new H3();
//        String stelleTitel = this.stelleDTO.getStelleTitel();
//        titel.setText(stelleTitel);
//        beschreibung.add(titel);
//        List<String> paragraphs = List.of(this.stelleDTO.getStelleBeschreibung().split("\n\n"));
//        paragraphs.forEach(paragraph -> {
//            List.of(paragraph.split("\n")).forEach(subParagraph -> {
//                Paragraph newParagraph = new Paragraph();
//                newParagraph.setWidthFull();
//                newParagraph.setText(subParagraph);
//                beschreibung.add(newParagraph);
//            });
//            beschreibung.add(new Html("<br>"));
//        });
//        stellenanzeige.add(beschreibung);
//
//        add(stellenanzeige);
//
//    }
//
//
//    private void displayApplicationForm() {
//        applicationForm.setPadding(false);
//
//        TextArea textArea = new TextArea();
//        textArea.setPlaceholder(getWommBuilder().translateText("Write a short application here"));
//        textArea.setWidthFull();
//        textArea.setMinHeight("200px");
//
//        applicationForm.add(textArea);
//
//        Button erstellenButton = new Button(getWommBuilder().translateText("Send"));
//        erstellenButton.addClickListener(e -> {
//            if (textArea.getValue().trim().isEmpty())
//                createErrorNotification(getWommBuilder().translateText("Please enter your application into the text field!"));
//            else if (stelleService.getById(stelleId).isPresent()) {
//                StelleDTO currentStelle = stelleService.getById(stelleId).get();
//                long studentId = securityService.getLoggedInNutzerID();
//                StudentDTO currentUser = studentService.getByNutzerId(studentId);
//                UnternehmenDTO unternehmen = currentStelle.getUnternehmen();
//                var returned = bewerbungService.saveBewerbung(BewerbungDTO.builder()
//                        .bewerbungStelle(currentStelle)
//                        .bewerbungStudent(currentUser)
//                        .bewerbungUnternehmen(unternehmen)
//                        .bewerbungStatus(ApplicationStatus.AUSSTEHEND.toString())
//                        .bewerbungText(textArea.getValue()).build());
//                if (returned != null) {
//                    createSuccessNotification();
//                }
//            } else {
//                createErrorNotification(getWommBuilder().translateText("The job offer is not available anymore :("));
//            }
//        });
//
//        applicationForm.add(erstellenButton);
//
//        add(applicationForm);
//    }
//
//    private void setFormToggle(boolean formToggle) {
//        this.formToggle = formToggle;
//    }
//
//    private void createErrorNotification(String errorText) {
//        Notification notification = new Notification();
//        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
//
//        Div text = new Div(new Text(errorText));
//
//        Button closeButton = new Button(new Icon("lumo", "cross"));
//        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
//        closeButton.addClickListener(e -> notification.close());
//
//        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
//        layout.setAlignItems(Alignment.CENTER);
//
//        notification.add(layout);
//        notification.open();
//    }
//
//    private void createSuccessNotification() {
//        Notification notification = new Notification();
//        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
//
//        Div text = new Div(getWommBuilder().Text.create(getWommBuilder().translateText("Your application has been sent successfully")));
//
//        Button closeButton = new Button(new Icon("lumo", "cross"));
//        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
//        closeButton.addClickListener(e -> {
//            notification.close();
//            UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
//        });
//
//        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
//        layout.setAlignItems(Alignment.CENTER);
//
//        notification.add(layout);
//        notification.open();
//    }
//
//    private void setup404Page() {
//        add(new H1("404 Not Found! :("));
//    }

