package de.hbrs.se2.womm.views.unternehmen;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.components.GridFilterStelle;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;
import java.util.List;
@Route(value = ROUTING.UNTERNEHMEN.UFirmProfileDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("FirmProfileDisplayView")
public class UFirmProfileDisplayView extends AViewWomm {
    private UnternehmenDTO unternehmenDTO;
    private long aktuelleNutzerID;
    GridFilterStelle gridFilterStelle;
    public UFirmProfileDisplayView(UnternehmenService unternehmenService, StelleService stelleService, SecurityService securityService) {
        super();
        this.aktuelleNutzerID = securityService.getLoggedInNutzerID();
        this.unternehmenDTO = unternehmenService.getByNutzerId(aktuelleNutzerID);
        setUp();
        this.gridFilterStelle = new GridFilterStelle();
        List<StelleDTO> stelleDTOList = stelleService.getByNutzerId(aktuelleNutzerID);
        this.gridFilterStelle.setUpFromOutside(stelleDTOList);
        gridFilterStelle.setColumnClickListener(ROUTING.UNTERNEHMEN.UJobProjectWorkshopDisplayView);
        add(gridFilterStelle);
    }
    private String checkIfNullShowTextLink(String checkString){
        if(checkString == null) return "go to \"UEditFirmProfileDisplayView\" to add this information";
        return checkString;
    }
    private void setUp() {
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        HorizontalLayout logoAndSubscribeLayout = new HorizontalLayout();
        Div logoAndName = new Div();
        Image companyLogo = unternehmenDTO.PlaceholderOrImage();
        companyLogo.setWidth(200 + "px");
        companyLogo.setHeight(200 + "px");
        logoAndName.add(companyLogo);
        logoAndName.add(new H2(unternehmenDTO.getName())); 
        logoAndSubscribeLayout.add(logoAndName);
        Button editButton = new Button("Edit firm profile");
        editButton.addClickListener(e -> {
            UI.getCurrent().navigate(UEditFirmProfileDisplayView.class);
        });
        add(buttonsLayout);
        buttonsLayout.add(logoAndSubscribeLayout);
        buttonsLayout.add(editButton);
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
}
