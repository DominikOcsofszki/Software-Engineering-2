package de.hbrs.se2.womm.views.student;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.AboDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Stelle;
import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.components.GridFilterStelle;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;
import de.hbrs.se2.womm.dtos.AboDTO;
import java.util.ArrayList;
import java.util.List;
@Route(value = ROUTING.STUDENT.SFirmProfileDisplayView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("FirmProfileDisplayView")
public class SFirmProfileDisplayView extends AViewWomm implements HasUrlParameter<Long> {
    private UnternehmenService unternehmenService;
    private StelleService stelleService;
    private UnternehmenDTO unternehmenDTO;
    private Long unternehmenID;
    private Long studentID;
    GridFilterStelle gridFilterStelle;
    SecurityService securityService;
    StudentService studentService;
    AboStudentUnternehmenService aboStudentUnternehmenService;
    public SFirmProfileDisplayView(UnternehmenService unternehmenService, StelleService stelleService,
                                   SecurityService securityService, StudentService studentService,
                                   AboStudentUnternehmenService aboStudentUnternehmenService) {
        this.unternehmenService = unternehmenService;
        this.stelleService = stelleService;
        this.securityService = securityService;
        this.studentService = studentService;
        this.studentID = studentService.getByNutzerId(securityService.getLoggedInNutzerID()).getStudentId();
        this.aboStudentUnternehmenService = aboStudentUnternehmenService;
    }
    @Override
    public void setParameter(BeforeEvent beforeEvent, Long parameter) {
        this.unternehmenID = parameter;
        this.unternehmenDTO = unternehmenService.getUnternehmenPerID(unternehmenID);
        setUp();
        this.gridFilterStelle = new GridFilterStelle();
        List<StelleDTO> stelleDTOList = stelleService.getByUnternehmenId(unternehmenID);
        this.gridFilterStelle.setUpFromOutside(stelleDTOList);
        gridFilterStelle.setColumnClickListener(ROUTING.STUDENT.SJobProjectWorkshopDisplayView);
        add(gridFilterStelle);
    }
    private AboDTO returnAboDTO() {
        AboDTO AboDTO = de.hbrs.se2.womm.dtos.AboDTO.builder().build();
        AboDTO.setAboBenachrichtigungen(true);
        AboDTO.setStudent(studentService.getById(studentID).get());
        AboDTO.setUnternehmen(unternehmenService.getUnternehmenPerID(unternehmenID));
        return AboDTO;
    }
    void setUpSubscrition() {
        aboStudentUnternehmenService.saveAboStudentUnternehmen(returnAboDTO());
    }
    private void setUp() {
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        HorizontalLayout logoAndSubscribeLayout = new HorizontalLayout();
        Div logoAndName = new Div();
        Image companyLogo = new Image(ASSETS.IMG.PLACEHOLDER, "placeholder");
        companyLogo.setWidth(200 + "px");
        companyLogo.setHeight(200 + "px");
        logoAndName.add(companyLogo);
        logoAndName.add(new H2(unternehmenDTO.getName())); 
        logoAndSubscribeLayout.add(logoAndName);
        Button subscribeButton = new Button("Subscribe");
        subscribeButton.addClickListener(e -> {
            setUpSubscrition();
            Notification.show("Subscribed!");
        });
        logoAndSubscribeLayout.add(subscribeButton);
        Button chatButton = new Button("Chat");
        chatButton.addClickListener(e -> {
            Notification.show("Opening Chat...");
        });
        add(buttonsLayout);
        buttonsLayout.add(logoAndSubscribeLayout);
        buttonsLayout.add(chatButton);
        HorizontalLayout detailsLayout = new HorizontalLayout();
        HorizontalLayout locationLayout = new HorizontalLayout();
        locationLayout.add(new Icon(VaadinIcon.MAP_MARKER), new Span(unternehmenDTO.getNutzer().getNutzerOrt())); 
        detailsLayout.add(locationLayout);
        HorizontalLayout websiteLayout = new HorizontalLayout();
        Icon linkIcon = new Icon(VaadinIcon.EXTERNAL_LINK);
        linkIcon.setColor(""); 
        websiteLayout.add(linkIcon, new Anchor(checkIfNullShowTextLink(null), checkIfNullShowTextLink(null)));
        detailsLayout.add(websiteLayout);
        add(detailsLayout);
        Paragraph companyDescription = new Paragraph(unternehmenDTO.getBeschreibung());
        add(companyDescription);
    }
    private List<Stelle> createDummyStellenanzeigen() {
        List<Stelle> dummyStellenanzeigen = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Stelle stelle = new Stelle();
            stelle.setStelleId(i);
            stelle.setStelleTitel("Job " + i);
            stelle.setStelleTitel("Description " + i);
            stelle.setStelleOrt("Location " + i);
            dummyStellenanzeigen.add(stelle);
        }
        return dummyStellenanzeigen;
    }
    private String checkIfNullShowTextLink(String checkString) {
        if (checkString == null) return "N/A";
        return checkString;
    }
}
