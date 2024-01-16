package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BenachrichtigungService;
import de.hbrs.se2.womm.views.components.GridFilterMessages;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.STUDENT.SChatView, layout = StudentLayout.class)
@RolesAllowed({ "ADMIN", "STUDENT"})
@PageTitle("ChatView")
public class SChatView extends AViewWomm {
    GridFilterMessages gridFilterMessages = new GridFilterMessages();
    SecurityService securityService;
    BenachrichtigungService benachrichtigungService;
    public SChatView(SecurityService securityService,
                     BenachrichtigungService benachrichtigungService) {
        this.securityService = securityService;
        this.benachrichtigungService = benachrichtigungService;
        H1 headerText = getWommBuilder().H1.create("Notifications");
        add(headerText);
        gridFilterMessages.setUpFromOutside(benachrichtigungService.getByNutzerId(securityService.getLoggedInNutzerID()));
        add(gridFilterMessages);
    }
}
