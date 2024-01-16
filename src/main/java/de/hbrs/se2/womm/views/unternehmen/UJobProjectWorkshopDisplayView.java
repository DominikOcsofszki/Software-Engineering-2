package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BenachrichtigungService;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import de.hbrs.se2.womm.views.sonardupplicates.BJobProjectWorkshopDisplayView;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UJobProjectWorkshopDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("JobProjectWorkshopDisplayView")
public class UJobProjectWorkshopDisplayView extends BJobProjectWorkshopDisplayView implements HasUrlParameter<Long> {

    public UJobProjectWorkshopDisplayView(StelleService stelleService, SecurityService securityService,
                                          BewerbungService bewerbungService, StudentService studentService,
                                          BenachrichtigungService benachrichtigungService) {
        super(stelleService, securityService, bewerbungService, studentService, benachrichtigungService);
        add(new Button("Edit", e -> {
            UI.getCurrent().navigate(ROUTING.UNTERNEHMEN.EditUJobProjectWorkshopDisplayView + "/" + stelleId);
        }));
    }

    void addButtonEdit() {

    }
}
//    StelleService stelleService;
//    StelleDTO stelleDTO;
//    long stelleId;
//
//    public UJobProjectWorkshopDisplayView(StelleService stelleService) {
//        this.stelleService = stelleService;
//    }
//
//    @Override
//    public void setParameter(BeforeEvent event, @OptionalParameter Long parameter) {
//        if (parameter != null) {
//            System.out.println("Parameter: " + parameter);
//            this.stelleId = parameter;
//            Optional<StelleDTO> checkStelleDTO = stelleService.getById(this.stelleId);
//            if (checkStelleDTO.isEmpty()) {
//                System.out.println("StelleDTO ist null");
//                add(new H1("Keine Stelle in der DB für ID: " + this.stelleId + " gefunden"));
//            } else {
//                this.stelleDTO = checkStelleDTO.get();
//                System.out.println("Parameter: " + parameter);
//                setUpBanner();
//                setUpHeader();
//                setUpStellenanzeige();
//            }
//
//        } else {
//            setup404Page();
//        }
//
//    }
//
//    private void setUpBanner() {
//        VerticalLayout banner = new VerticalLayout();
//        Image i = new Image("themes/theme_1/banner.jpg", "https://unsplash.com/de/fotos/%EC%B2%AD%EB%A1%9D%EC%83%89-led-%ED%8C%A8%EB%84%90-EUsVwEOsblE");
//        i.setWidth("100%");
//        banner.add(i);
//        add(banner);
//    }
//
//    private void setUpHeader() {
//        HorizontalLayout header = new HorizontalLayout();
//        ImageService imageService = new ImageService();
//        Image i = imageService.getRandomImageHeight(100);
//        header.add(i);
//        String unternehmenName = this.stelleDTO.getUnternehmen().getName();
//        H1 name = new H1(unternehmenName);
//        header.add(name);
//        add(header);
//    }
//
//
//    private void setUpStellenanzeige() {
//        VerticalLayout stellenanzeige = new VerticalLayout();
//
//        // Ort
//
//        HorizontalLayout ortLayout = new HorizontalLayout();
//        Icon ortsIcon = VaadinIcon.PIN.create();
//        ortLayout.add(ortsIcon);
//
//        Text ort = new Text(this.stelleDTO.getStelleOrt());
//        ortLayout.add(ort);
//
//        stellenanzeige.add(ortLayout);
//
//        // Hyperlink
//
//        HorizontalLayout linkLayout = new HorizontalLayout();
//        Icon linkIcon = VaadinIcon.LINK.create();
//        linkLayout.add(linkIcon);
//
//        Anchor website = new Anchor();
//        String url = this.stelleDTO.getStelleWebsite();
//        website.setText(url);
//
//        linkLayout.add(website);
//
//        stellenanzeige.add(linkLayout);
//
//        // Beschreibung + Header
//
//        Div beschreibung = new Div();
//
//        beschreibung.getStyle().set("margin-top", "20px");
//
//        H3 titel = new H3();
//        String stelleTitel = this.stelleDTO.getStelleTitel();
//        titel.setText(stelleTitel);
//
//        beschreibung.add(titel);
//
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
//
//        stellenanzeige.add(beschreibung);
//
//        add(stellenanzeige);
//
//    }
//
//    private void setup404Page() {
//        add(new H1("404 Not Found! :("));
//    }
//}
