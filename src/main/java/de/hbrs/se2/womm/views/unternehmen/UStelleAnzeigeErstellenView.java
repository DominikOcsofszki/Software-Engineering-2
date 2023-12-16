package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UStelleAnzeigeErstellenView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("StelleAnzeigeErstellenView")
public class UStelleAnzeigeErstellenView extends AViewWomm
        implements HasUrlParameter<String> {

    TextField stelleTitel = new TextField();
    TextField stelleOrt = new TextField();
    TextField stelleWebsite = new TextField();
    TextArea stelleBeschreibung = new TextArea();

    StelleService stelleService;

    UnternehmenService unternehmenService;

    SecurityService securityService;

    String valueFromQuerry;
    private long aktuelleNutzerID;
    private UnternehmenDTO unternehmenDTO;

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
                                       SecurityService securityService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        this.stelleService = stelleService;
        this.unternehmenService = unternehmenService;
        this.securityService = securityService;
        setUpHeader();
        setUpStellenanzeige();
    }

    private void setUpHeader(){
        HorizontalLayout header = new HorizontalLayout();
        //Ueberschrift
        header.add(new H1("Stellenausschreibung erstellen:"));

        add(header);
    }

    private void setUpStellenanzeige() {
        VerticalLayout stellenanzeige = new VerticalLayout();

        //Combobox
        ComboBox stellenanzeigenTyp = new ComboBox("Stellenanzeigen-Typ");
        stellenanzeigenTyp.setWidth("min-content");
        stellenanzeigenTyp.setItems("Workshop", "Projekt", "Werksstudenten-Stelle");

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
        Button erstellenButton = new Button("Erstellen");
        erstellenButton.addClickListener(e -> {
            if(stelleWebsite.getValue().matches(URL_REGEX)) {
                String stelleIdFromFunction = String.valueOf(stelleDTO());
//            UI.getCurrent().navigate(UStelleAnzeigeErstellenView.class,stelleIdFromFunction);//ToDo refactored
//            UI.getCurrent().navigate(UFirmProfileDisplayView.class,stelleIdFromFunction);
                UI.getCurrent().navigate(UFirmProfileDisplayView.class);
            }else{
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

    private long stelleDTO(){
//        long stelleId = 3l;
//        long getUserId = 1l;
//        UnternehmenDTO unternehmenDTO = unternehmenController.getUnternehmenById(getUserId).getBody();
        System.out.println("UnternehmenDTO: " + unternehmenDTO);
//        Unternehmen unternehmen = UnternehmenMapper.INSTANCE.dtoZuUnternehmen(unternehmenDTO);
        StelleDTO erzeugDTO = StelleDTO.builder()
                .stelleTitel(stelleTitel.getValue())
                .stelleOrt(stelleOrt.getValue())
                .stelleWebsite(stelleWebsite.getValue())
                .stelleBeschreibung(stelleBeschreibung.getValue())
                .stelleUnternehmen(unternehmenDTO)
                .build();
        StelleDTO stelleDTO = stelleService.saveStelle(erzeugDTO);
        System.out.println(stelleDTO.getStelleId());
        return stelleDTO.getStelleId();
    }




}
