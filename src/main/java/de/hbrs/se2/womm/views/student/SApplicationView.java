package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.*;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.extra.ComponentImageUpload;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.STUDENT.SApplicationView, layout = StudentLayout.class)
@RolesAllowed({ "ADMIN", "STUDENT"})
@PageTitle("ApplicationView")
public class SApplicationView extends AViewWomm implements HasUrlParameter<String> {
//public class SApplicationView extends VerticalLayout implements HasUrlParameter<String> {
    //Changed
    StudentDTO studentDTO;
    StelleDTO stelleDTO;
    UnternehmenDTO unternehmenDTO;
    //
    byte[] bewerbungPdf;
    byte[] bewerbungPdf1;
    TextArea bewerbungText = new TextArea();

    StelleService stelleService;
    UnternehmenService unternehmenService;
    BewerbungService bewerbungService;
    SecurityService securityService;
    String valueFromQuerry;

    private long aktuelleNutzerID;

    public SApplicationView(BewerbungService bewerbungService,
                            StelleService stelleService,
                            UnternehmenService unternehmenService,
                            SecurityService securityService,
                            StudentService studentService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.studentDTO = studentService.getByNutzerId(aktuelleNutzerID);
        this.bewerbungService = bewerbungService;
        this.stelleService = stelleService;
        this.unternehmenService = unternehmenService;
        this.securityService = securityService;
        //SetUp:
        //
        setUpHeader();
        setUpBewerbung();
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        if (parameter == null) {
            valueFromQuerry = "";
        } else {
            add(String.format("parameter: %s.",
                    parameter));
            valueFromQuerry = parameter;
            long parameterLong = Long.parseLong(parameter);
//            this.stelleDTO = stelleService.getById(parameterLong) == null ? null :
//                    stelleService.getById(parameterLong);
            this.stelleDTO = stelleService.getById(parameterLong).isPresent() ?
                    stelleService.getById(parameterLong).get() : null;
            System.out.println("stelleDTO:" + stelleDTO);

        }
    }



    private void setUpHeader(){
        HorizontalLayout header = new HorizontalLayout();
        //Ueberschrift
        H1 h1 = getWommBuilder().H1.create("Bewerbung erstellen:");
        header.add(h1);

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
