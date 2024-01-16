package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BenachrichtigungService;
import de.hbrs.se2.womm.views.components.GridFilterMessages;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UNotificationView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("NotificationView")
public class UNotificationView extends AViewWomm {
    GridFilterMessages gridFilterMessages = new GridFilterMessages();
    BenachrichtigungService benachrichtigungService;
    SecurityService securityService;

    public UNotificationView(BenachrichtigungService benachrichtigungService,
                             SecurityService securityService) {
        this.benachrichtigungService = benachrichtigungService;
        this.securityService = securityService;
        setUpHeader();
        gridFilterMessages.setUpFromOutside(benachrichtigungService.getByNutzerId(securityService.getLoggedInNutzerID()));
        add(gridFilterMessages);
    }

    private void setUpHeader() {
        HorizontalLayout header = new HorizontalLayout();
        //Suchfeld
        header.add(new H1("Neue Benachrichtigungen"));
        add(header);
    }
}