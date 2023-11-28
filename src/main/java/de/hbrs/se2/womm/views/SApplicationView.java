package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.BewerbungController;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.controller.UnternehmenController;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.views.components.using.ComponentImageUpload;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.io.IOException;
import java.io.InputStream;

@Route(value = ROUTING.STUDENT.SApplicationView, layout = StudentLayout.class)
@RolesAllowed({ "ADMIN", "STUDENT"})
@PageTitle("ApplicationView")
public class SApplicationView extends VerticalLayout implements HasUrlParameter<String> {

    byte[] bewerbungPdf;
    byte[] bewerbungPdf1;
    TextArea bewerbungText = new TextArea();

    StelleController stelleController;

    UnternehmenController unternehmenController;

    BewerbungController bewerbungController;

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

    public SApplicationView(BewerbungController bewerbungController,StelleController stelleController, UnternehmenController unternehmenController, SecurityService securityService) {
        this.bewerbungController = bewerbungController;
        this.stelleController = stelleController;
        this.unternehmenController = unternehmenController;
        this.securityService = securityService;
        setUpHeader();
        setUpBewerbung();
    }

    private void setUpHeader(){
        HorizontalLayout header = new HorizontalLayout();
        //Ueberschrift
        header.add(new H1("Bewerbung erstellen:"));

        add(header);
    }

    private void setUpBewerbung() {
        VerticalLayout bewerbung = new VerticalLayout();

        //TextfeldText
        bewerbungText.setPlaceholder("Bewerbungs-Text");
        bewerbungText.setClearButtonVisible(true);
        bewerbungText.setWidthFull();

        bewerbung.add(bewerbungText);

        //Bild

        add(new HorizontalLayout(new Paragraph("Bewerbungsfoto"),new ComponentImageUpload()));

        //Lebenslauf
        add(new HorizontalLayout(new Paragraph("Lebenslauf"),new ComponentImageUpload()));

           /* MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
            Upload upload = new Upload(buffer);

            upload.addSucceededListener(event -> {
                String fileName = event.getFileName();
                InputStream inputStream = buffer.getInputStream(fileName);
                try {
                    bewerbungPdf = inputStream.readAllBytes();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            bewerbung.add(upload);
            */
            add(bewerbung);



        //ToDo -Erstellung eines Datenbankobjekts mit StellenanzeigeTyp, StellenanzeigeBezeichnung, StellenanzeigeBeschreibung, FirmenLogo, FirmenName
        //ToDo -Routing zum korrekten UnternehmenView
        //Erstellen-Button
        Button erstellenButton = new Button("Erstellen");
        erstellenButton.addClickListener(e -> {
            //String stelleIdFromFunction = String.valueOf(bewerbungDTO());
            System.out.println(bewerbungPdf);
            System.out.println(bewerbungPdf1);
            UI.getCurrent().navigate(SApplicationView.class,"3");
            //getUI().ifPresent(ui -> stelleDTO());

        });

        // erstellenButton.addClickListener(e -> {
        //     getUI().ifPresent(ui -> ui.navigate(ROUTING.UNTERNEHMEN.UHomepageUnternehmenView));
        // });
        bewerbung.add(erstellenButton);

        add(bewerbung);



    }

    //Name Student

    //Bild Student



    /*
    private long bewerbungDTO(){

        long stelleId = 3l;
        long getUserId = 3l;
        StelleDTO stelleDTO = stelleController.getById(getUserId).getBody();
        StudentDTO studentDTO = studentController;
        Unternehmen unternehmen = UnternehmenMapper.INSTANCE.dtoZuUnternehmen(unternehmenDTO);
        BewerbungDTO erzeugDTO = BewerbungDTO.builder()
                .bewerbungPdf(bewerbungPdf)
                .bewerbungText(bewerbungText.getValue())
                .bewerbungStelle(stelleDTO)
                .bewerbungStudent(studentDTO)
                .build();
        stelleController.saveStelle(erzeugDTO);
        System.out.println(erzeugDTO);
        return stelleId;
    }


     */
}
