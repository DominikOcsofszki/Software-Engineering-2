//package de.hbrs.se2.womm.views.unternehmen;
//
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.html.Image;
//import com.vaadin.flow.component.html.Paragraph;
//import com.vaadin.flow.component.icon.Icon;
//import com.vaadin.flow.component.icon.VaadinIcon;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.*;
//import de.hbrs.se2.womm.dtos.StelleDTO;
//import de.hbrs.se2.womm.services.ImageService;
//import de.hbrs.se2.womm.services.StelleService;
//import de.hbrs.se2.womm.views.layouts.ROUTING;
//import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
//import jakarta.annotation.security.RolesAllowed;
//import javassist.NotFoundException;
//import tools.generate.GenerateStelleDTO;
//
//@Route(value = ROUTING.UNTERNEHMEN.UJobProjectWorkshopDisplayView, layout = UnternehmenLayout.class)
//@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
//@PageTitle("JobProjectWorkshopDisplayView")
//public class UJobProjectWorkshopDisplayView extends VerticalLayout implements HasUrlParameter<String> {
//    private String parameter;
//    StelleService stelleService;
//    StelleDTO stelleDTO = GenerateStelleDTO.generateStelleDTO(1).get(0);
//     long stelleId = 1;
//    @Override
//    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
//        this.parameter = parameter;
//        if(this.parameter != null) this.stelleId = Long.parseLong(this.parameter);
//        System.out.println("Parameter: " + this.parameter);
//        try {
//            this.stelleDTO = setUpStelleDTO(this.stelleId);
//        } catch (NotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        setUpBanner();
//        setUpHeader();
//        setUpStellenanzeige();
//        setUpButtons();
//    }
//    public UJobProjectWorkshopDisplayView(StelleService stelleService) {
//        this.stelleService = stelleService;
////        setUpBanner();
////        setUpHeader();
////        setUpStellenanzeige();
////        setUpButtons();
//        //ToDo setUpStelleDTO running after setParameter
//    }
//    private StelleDTO setUpStelleDTO(long id) throws NotFoundException {
////            StelleDTO stelleDTO = stelleController.getById(Long.parseLong(parameter));
//            StelleDTO stelleDTO = stelleService.getById(id).get();
//            return stelleDTO;
//    }
//
//    //ToDo Banner anpassen
//
//    private void setUpBanner() {
//        VerticalLayout banner = new VerticalLayout();
//        Image i = new Image("themes/theme_1/banner.jpg", "https://unsplash.com/de/fotos/%EC%B2%AD%EB%A1%9D%EC%83%89-led-%ED%8C%A8%EB%84%90-EUsVwEOsblE");
//        i.setWidth("100%");
//        banner.add(i);
//        add(banner);
//    }
//
//    //ToDo bestimmten FirmenNamen + FirmenLogo anzeigen
//
//    private void setUpHeader() {
//        HorizontalLayout header = new HorizontalLayout();
//        ImageService imageService = new ImageService();
//
//        //Logo
////        Image i = new Image(ASSETS.RANDOM.USER, "Alternative image text");
////        Image i = this.stelleDTO.getStelleUnternehmen().PlaceholderOrImage(); //ToDo Changed
//
////        Image i = imageService.getImage(this.stelleDTO.getStelleUnternehmen().getNutzer()); //ToDo Changed
////        Image i = imageService.test();
//        Image i = imageService.getRandomImageHeight(100);
////        i.setWidth("25%");
//        header.add(i);
//
//        //Ueberschrift
////        header.add(new H1("Unternehmenname"));
//        String unternehmenName = this.stelleDTO.getStelleUnternehmen().getName(); //ToDo Changed
//        header.add(new H1(unternehmenName));
////        header.add(new H1("Unternehmenname"));
//        add(header);
//    }
//
//
//    private void setUpStellenanzeige() {
//        VerticalLayout stellenanzeige = new VerticalLayout();
//
//
//        //ToDo bestimmete StelleTitel anzeigen
//        //Textfeld StelleTitel
////        Paragraph titel = new Paragraph();
//        Paragraph titel = new Paragraph();
//        String stelleTitel = this.stelleDTO.getStelleTitel(); //ToDo Changed
//        titel.setText(stelleTitel);
////        titel.setText("Werksstudenten-Stelle");
//
//        stellenanzeige.add(titel);
//
//        //ToDo bestimmete StelleOrt anzeigen
//        //Textfeld StelleOrt
//        Paragraph ort = new Paragraph();
//        String stelleOrt = this.stelleDTO.getStelleOrt(); //ToDo Changed
//        ort.setText(stelleOrt);
////        ort.setText("Bonn");
//
//        stellenanzeige.add(ort);
//
//        //ToDo bestimmete StelleOrt anzeigen
//        //Textfeld StelleWebsite
//        Paragraph website = new Paragraph();
//        String stelleWebsite = this.stelleDTO.getStelleWebsite(); //ToDo Changed
//        website.setText(stelleWebsite);
////        website.setText("https://www.google.com/");
//
//        stellenanzeige.add(website);
//
//        //ToDo bestimmte StelleBeschreibung anzeigen
//        //Textfeld StelleBeschreibung
//        Paragraph beschreibung = new Paragraph();
//        beschreibung.setWidthFull();
//        String stelleBeschreibung = this.stelleDTO.getStelleBeschreibung(); //ToDo Changed
//        beschreibung.setText(stelleBeschreibung);
////        beschreibung.setText("Hier könnte ihre Werbung für einen ausbeutenden Job stehen.");
//
//        stellenanzeige.add(beschreibung);
//
//        add(stellenanzeige);
//
//    }
//
//    private void setUpButtons() {
//        HorizontalLayout buttons = new HorizontalLayout();
//
//        //ToDo Bewerbung für bestimmten Studenten öffnen
//        //Erstellen-Button
//        Button bewerbungButton = new Button("Bewerbung", new Icon(VaadinIcon.PENCIL));
//        bewerbungButton.addClickListener(e -> {
//            getUI().ifPresent(ui -> ui.navigate(ROUTING.STUDENT.SApplicationView));
//        });
//        buttons.add(bewerbungButton);
//
//        //ToDo Chat für bestimmete Studenten-Unternehmen Kombination öffnen
//        //Chat-Button
//        Button chatButton = new Button("Chat", new Icon(VaadinIcon.COMMENTS_O));
//        chatButton.addClickListener(e -> {
//            getUI().ifPresent(ui -> ui.navigate(ROUTING.STUDENT.SChatView));
//        });
//        buttons.add(chatButton);
//        add(buttons);
//    }
//
//
//}
