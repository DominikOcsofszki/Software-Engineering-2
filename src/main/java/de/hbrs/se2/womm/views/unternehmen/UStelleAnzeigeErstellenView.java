package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.controller.UnternehmenController;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UStelleAnzeigeErstellenView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("StelleAnzeigeErstellenView")
public class UStelleAnzeigeErstellenView extends VerticalLayout
        implements HasUrlParameter<String> {

    TextField stelleTitel = new TextField();
    TextField stelleOrt = new TextField();
    TextField stelleWebsite = new TextField();
    TextArea stelleBeschreibung = new TextArea();

    StelleController stelleController;

    UnternehmenController unternehmenController;

    SecurityService securityService;

    String valueFromQuerry;

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

    public UStelleAnzeigeErstellenView(StelleController stelleController, UnternehmenController unternehmenController, SecurityService securityService) {
        this.stelleController = stelleController;
        this.unternehmenController = unternehmenController;
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
            String stelleIdFromFunction = String.valueOf(stelleDTO());
//            UI.getCurrent().navigate(UStelleAnzeigeErstellenView.class,stelleIdFromFunction);//ToDo refactored
//            UI.getCurrent().navigate(UFirmProfileDisplayView.class,stelleIdFromFunction);
            UI.getCurrent().navigate(UFirmProfileDisplayView.class);

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
        long id = securityService.getLoggedInNutzerID();
        UnternehmenDTO unternehmenDTO = unternehmenController.getUnternehmenById(id).getBody();
        System.out.println("UnternehmenDTO: " + unternehmenDTO);
//        Unternehmen unternehmen = UnternehmenMapper.INSTANCE.dtoZuUnternehmen(unternehmenDTO);
        StelleDTO erzeugDTO = StelleDTO.builder()
                .stelleTitel(stelleTitel.getValue())
                .stelleOrt(stelleOrt.getValue())
                .stelleWebsite(stelleWebsite.getValue())
                .stelleBeschreibung(stelleBeschreibung.getValue())
                .stelleUnternehmen(unternehmenDTO)
                .build();
        StelleDTO stelleDTO = stelleController.saveStelle(erzeugDTO).getBody();
        System.out.println(stelleDTO.getStelleId());
        return stelleDTO.getStelleId();
    }




}
