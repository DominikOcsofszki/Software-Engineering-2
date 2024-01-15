package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.AboDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.Date;
import java.util.List;

@Route(value = ROUTING.UNTERNEHMEN.UStelleAnzeigeErstellenView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("StelleAnzeigeErstellenView")
public class UStelleAnzeigeErstellenView extends AViewWomm
        implements HasUrlParameter<String> {

    TextField stelleTitel = new TextField();
    TextField stelleOrt = new TextField();
    TextField stelleWebsite = new TextField();
    TextArea stelleBeschreibung = new TextArea();
    Select<String> stellenanzeigenTyp;
    String chosenTyp;
    StelleService stelleService;
    UnternehmenService unternehmenService;
    SecurityService securityService;
    AboStudentUnternehmenService aboStudentUnternehmenService;
    String valueFromQuerry;
    private long aktuelleNutzerID;
    private UnternehmenDTO unternehmenDTO;
    private StelleDTO stelleToEdit;
    private int stellePrimaryKey;

    private static final String URL_REGEX = "(https://www.)|(www.)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter == null) {
            valueFromQuerry = "";
        } else {
            add(String.format("parameter: %s.",
                    parameter));
            valueFromQuerry = parameter;
        }
    }

    public UStelleAnzeigeErstellenView(StelleService stelleService,
                                       UnternehmenService unternehmenService,
                                       SecurityService securityService,
                                       AboStudentUnternehmenService aboStudentUnternehmenService) {
        super();
        this.stelleToEdit = null;
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        this.stelleService = stelleService;
        this.unternehmenService = unternehmenService;
        this.securityService = securityService;
        this.aboStudentUnternehmenService = aboStudentUnternehmenService;
        this.chosenTyp = "Werkstudenten-Stelle";
        setUpHeader();
        setUpStellenanzeige();
    }

    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        //Ueberschrift
        header.add(new H1("Stellenausschreibung erstellen:"));

        add(header);
    }

    private void setUpStellenanzeige() {
        VerticalLayout stellenanzeige = new VerticalLayout();

        //Selector
        this.stellenanzeigenTyp = new Select<>("Stellenanzeigen-Typ", this::selectComponentListener);
        stellenanzeigenTyp.setWidth("min-content");
        stellenanzeigenTyp.setItems("Workshop", "Projekt", "Werkstudenten-Stelle");
        stellenanzeigenTyp.setValue("Werkstudenten-Stelle");

        stellenanzeige.add(stellenanzeigenTyp);

        //TextfeldTitel
        stelleTitel.setPlaceholder("Stellenbezeichnung");
        stelleTitel.setClearButtonVisible(true);

        stellenanzeige.add(stelleTitel);

        //Textfeld StelleOrt
        stelleOrt.setPlaceholder("Ortsname");
        stelleOrt.setClearButtonVisible(true);

        stellenanzeige.add(stelleOrt);

        //Textfeld StelleWebsite
        stelleWebsite.setPlaceholder("URL");
        stelleWebsite.setClearButtonVisible(true);

        stelleWebsite.setPattern(URL_REGEX);
        stelleWebsite.setRequiredIndicatorVisible(true);

        stellenanzeige.add(stelleWebsite);

        //Textfeld StelleBeschreibung
        stelleBeschreibung.setWidthFull();
        stelleBeschreibung.setPlaceholder("Stellenbeschreibung");
        stelleBeschreibung.setClearButtonVisible(true);

        stellenanzeige.add(stelleBeschreibung);

        //ToDo -Erstellung eines Datenbankobjekts mit StellenanzeigeTyp, StellenanzeigeBezeichnung, StellenanzeigeBeschreibung, FirmenLogo, FirmenName
        //ToDo -Routing zum korrekten UnternehmenView
        //Erstellen-Button
        Button erstellenButton = getWommBuilder().Button.create("Erstellen");
        erstellenButton.addClickListener(e -> {
            if (stelleWebsite.getValue().matches(URL_REGEX)) {
                buildAndSaveStelleDTO();
//                UI.getCurrent().navigate(UFirmProfileDisplayView.class);
            } else {
                Notification notification = new Notification();
                notification.setText("Bitte überprüfen Sie ihre Eingaben!");
                notification.open();
                notification.setDuration(3000);
            }

        });

        // erstellenButton.addClickListener(e -> {
        //     getUI().ifPresent(ui -> ui.navigate(ROUTING.UNTERNEHMEN.UHomepageUnternehmenView));
        // });
        stellenanzeige.add(erstellenButton);

        add(stellenanzeige);

    }

    protected void setUpFieldForEdit(StelleDTO stelleDTO) {
                stelleToEdit = stelleDTO;
//                stellenanzeigenTyp.setValue(stelleDTO.());
                stellePrimaryKey = stelleDTO.getStelleId().intValue();
                stelleTitel.setValue(stelleDTO.getStelleTitel());
                stelleOrt.setValue(stelleDTO.getStelleOrt());
                stelleWebsite.setValue(stelleDTO.getStelleWebsite());
                stelleBeschreibung.setValue(stelleDTO.getStelleBeschreibung());
                unternehmenDTO = stelleDTO.getUnternehmen();
    }
    private void buildAndSaveStelleDTO() {
        System.out.println("UnternehmenDTO: " + unternehmenDTO);
        StelleDTO erzeugDTO = StelleDTO.builder()
                .stelleId(stelleToEdit == null ? null : stelleToEdit.getStelleId())
                .stelleTyp(chosenTyp)
                .stelleTitel(stelleTitel.getValue())
                .stelleOrt(stelleOrt.getValue())
                .stelleWebsite(stelleWebsite.getValue())
                .stelleBeschreibung(stelleBeschreibung.getValue())
                .unternehmen(unternehmenDTO)
                .erstellungsdatum((new Date()))
                .build();
//        StelleDTO stelleDTO = stelleService.saveStelle(erzeugDTO);
        stelleService.saveStelle(erzeugDTO);
        List<AboDTO> allAboDTO =
                aboStudentUnternehmenService.getByNutzerId(unternehmenDTO.getNutzer().getNutzerId());
//        List<AboDTO> allAboDTO =
//                aboStudentUnternehmenService.getAll();
        System.out.println("-----------------------------------");
        System.out.println("allAboDTO: " + allAboDTO);
        System.out.println("-----------------------------------");

        allAboDTO.forEach(
                AboDTO -> {
                    if (AboDTO.getAboBenachrichtigungen()) {
                        Notification notification = new Notification();
                        notification.setText("Neue Stelle: " + erzeugDTO.getStelleTitel());
                        notification.setText("Student Informed: " + AboDTO.getStudent().getStudentVorname()
                                + " " + AboDTO.getStudent().getStudentName());
                        System.out.println("Neue Stelle: " + erzeugDTO.getStelleTitel());
                        notification.open();
                        notification.setDuration(5000);
                    }
                });
    }

    private void selectComponentListener(AbstractField.ComponentValueChangeEvent<Select<String>, String> e) {
        this.chosenTyp = e.getValue();
    }

}
