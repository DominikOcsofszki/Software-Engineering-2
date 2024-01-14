package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.components.GridFilterStelle;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Route(value = ROUTING.UNTERNEHMEN.UHomepageUnternehmenView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("HomepageUnternehmenView")
public class UHomepageUnternehmenView extends AViewWomm {
    UnternehmenDTO unternehmenDTO;
    private long aktuelleNutzerID;
    GridFilterStelle gridFilterStelle;
    public UHomepageUnternehmenView(UnternehmenService unternehmenService, SecurityService securityService, StelleService stelleService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        setUpHeader();


        setUpSearchFields();
        this.gridFilterStelle = new GridFilterStelle();
        List<StelleDTO> stelleDTOList = stelleService.getByNutzerId(aktuelleNutzerID);
        this.gridFilterStelle.setUpFromOutside(stelleDTOList);
        this.gridFilterStelle.setColumnClickListener(ROUTING.UNTERNEHMEN.UJobProjectWorkshopDisplayView);
        add(gridFilterStelle);


    }

    private void setUpComponentFilterGridControllerStellen() { //ToDo: this was added


    }


    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();

        String button1 = getWommBuilder().translateText("Create advertisement");
        Button b1 = new Button(button1, new Icon(VaadinIcon.PLUS));
        b1.addClickListener(e -> UI.getCurrent().navigate(UStelleAnzeigeErstellenView.class));
        header.add(b1);
        String button2 = getWommBuilder().translateText("View applications");
        Button b2 = new Button(button2, new Icon(VaadinIcon.EYE));
        b2.addClickListener(e -> UI.getCurrent().navigate(UApplicationsView.class));
        header.add(b2);
        String button3 = getWommBuilder().translateText("Notifications");
        Button b3 = new Button(button3, new Icon(VaadinIcon.BELL));
        b3.addClickListener(e -> UI.getCurrent().navigate(UNotificationView.class));
        header.add(b3);
        String button4 = getWommBuilder().translateText("Chat");
        Button b4 = new Button(button4, new Icon(VaadinIcon.COMMENTS_O));
        b4.addClickListener(e -> UI.getCurrent().navigate(UChatView.class));
        header.add(b4);
        String button5 = getWommBuilder().translateText("Edit profile");
        Button b5 = new Button(button5, new Icon(VaadinIcon.PENCIL));
        b5.addClickListener(e -> UI.getCurrent().navigate(UEditFirmProfileDisplayView.class));
        header.add(b5);

        add(header);

        b5.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
    }

/*    private void setUpBanner() {
        VerticalLayout banner = new VerticalLayout();

       Image i = new Image(ASSETS.BANNER.BANNER2, "alt text");

        i.setWidth("100%");
        banner.add(i);
        add(banner);
    }
*/
    private void setUpSearchFields() {
        /*
        HorizontalLayout searchFields = new HorizontalLayout();

        MultiSelectComboBox filter1 = new MultiSelectComboBox("Offer type");
        filter1.setItems("Job offer", "Project", "Workshop", "Internship");
        filter1.setWidth("min-content");
        searchFields.add(filter1);

        MultiSelectComboBox filter2 = new MultiSelectComboBox("Industry");
        filter2.setWidth("min-content");
        filter2.setItems("Informationstechnologie (IT)", "Gesundheitswesen", "Finanzdienstleistungen", "Bildung",
                "Ingenieurwesen", "Marketing und Werbung", "Medien und Unterhaltung", "Verkauf und Vertrieb",
                "Gastgewerbe und Tourismus", "Rechtswesen", "Soziale Dienste und gemeinnützige Organisationen",
                "Fertigung und Produktion", "Transport und Logistik", "Bauwesen", "Energie und Umwelt",
                "Forschung und Entwicklung", "Design und Kunst", "Landwirtschaft", "Personalwesen", "Telekommunikation");
        searchFields.add(filter2);

        TextField textField = new TextField();
        textField.setLabel("Firm or ad name");
        textField.setPlaceholder("Search");
        textField.setPrefixComponent(VaadinIcon.SEARCH.create());
        searchFields.add(textField);

        Button b = new Button("Search", new Icon(VaadinIcon.SEARCH));
        searchFields.add(b);
        b.getElement().getStyle().set("margin-top", "auto");

        add(searchFields);
        */
        setUpComponentFilterGridControllerStellen();
    }
}
