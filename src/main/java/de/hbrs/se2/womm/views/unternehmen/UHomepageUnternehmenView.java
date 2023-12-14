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
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.components.FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UHomepageUnternehmenView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("HomepageUnternehmenView")
public class UHomepageUnternehmenView extends VerticalLayout {
    UnternehmenDTO unternehmenDTO;
    public UHomepageUnternehmenView(UnternehmenService unternehmenController, SecurityService securityService, StelleController stelleController) {
        long id = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenController.getByNutzerID(id);
        setUpHeader();
        setUpBanner();

        setUpSearchFields();
        add(new FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative(stelleController, unternehmenDTO.getUnternehmenId()));
    }

    private void setUpComponentFilterGridControllerStellen() { //ToDo: this was added
//        add(new ComponentFilterGridControllerStellen(controller));
//        add(new ComponentFilterStelle(controller));
    }


    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        //Buttons
        Button b1 = new Button("Create advertisement", new Icon(VaadinIcon.PLUS));
        b1.addClickListener(e -> UI.getCurrent().navigate(UStelleAnzeigeErstellenView.class));
        header.add(b1);
        Button b2 = new Button("View applications", new Icon(VaadinIcon.EYE));
        b2.addClickListener(e -> UI.getCurrent().navigate(UApplicationsView.class));
        header.add(b2);
        Button b3 = new Button("Notifications", new Icon(VaadinIcon.BELL));
        b3.addClickListener(e -> UI.getCurrent().navigate(UNotificationView.class));
        header.add(b3);
        Button b4 = new Button("Chat", new Icon(VaadinIcon.COMMENTS_O));
        b4.addClickListener(e -> UI.getCurrent().navigate(UChatView.class));
        header.add(b4);
        Button b5 = new Button("Edit profile", new Icon(VaadinIcon.PENCIL));
        b5.addClickListener(e -> UI.getCurrent().navigate(UEditFirmProfileDisplayView.class));
        header.add(b5);
        //header.add(new Button("Logout Firmname", new Icon(VaadinIcon.EXIT_O)));
        add(header);
        // Layout (letzten zwei buttons nach rechts)
        b5.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
    }

    private void setUpBanner() {
        VerticalLayout banner = new VerticalLayout();
//        Image i = new Image("themes/theme_1/banner.jpg", "https://unsplash.com/de/fotos/%EC%B2%AD%EB%A1%9D%EC%83%89-led-%ED%8C%A8%EB%84%90-EUsVwEOsblE");
        Image i = new Image(ASSETS.BANNER.BANNER2, "alt text");

        i.setWidth("100%");
        banner.add(i);
        add(banner);
    }

    private void setUpSearchFields() {
        /*
        HorizontalLayout searchFields = new HorizontalLayout();
        //Offer type
        MultiSelectComboBox filter1 = new MultiSelectComboBox("Offer type");
        filter1.setItems("Job offer", "Project", "Workshop", "Internship");
        filter1.setWidth("min-content");
        searchFields.add(filter1);
        //Industry
        MultiSelectComboBox filter2 = new MultiSelectComboBox("Industry");
        filter2.setWidth("min-content");
        filter2.setItems("Informationstechnologie (IT)", "Gesundheitswesen", "Finanzdienstleistungen", "Bildung",
                "Ingenieurwesen", "Marketing und Werbung", "Medien und Unterhaltung", "Verkauf und Vertrieb",
                "Gastgewerbe und Tourismus", "Rechtswesen", "Soziale Dienste und gemeinnützige Organisationen",
                "Fertigung und Produktion", "Transport und Logistik", "Bauwesen", "Energie und Umwelt",
                "Forschung und Entwicklung", "Design und Kunst", "Landwirtschaft", "Personalwesen", "Telekommunikation");
        searchFields.add(filter2);
        //Suchfeld
        TextField textField = new TextField();
        textField.setLabel("Firm or ad name");
        textField.setPlaceholder("Search");
        textField.setPrefixComponent(VaadinIcon.SEARCH.create());
        searchFields.add(textField);
        // Suche-Button
        Button b = new Button("Search", new Icon(VaadinIcon.SEARCH));
        searchFields.add(b);
        b.getElement().getStyle().set("margin-top", "auto");

        add(searchFields);
        */
        setUpComponentFilterGridControllerStellen();
    }
}
