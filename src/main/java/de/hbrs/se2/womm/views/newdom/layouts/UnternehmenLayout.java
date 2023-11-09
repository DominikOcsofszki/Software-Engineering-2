package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.newdom.HomepageUnternehmenView;
import de.hbrs.se2.womm.views.newdom.JobProjectWorkshopDisplayView;

public class UnternehmenLayout extends AbstractLayout {


    protected UnternehmenLayout(SecurityService securityService) {
        super.createHeaderWithLogoutButton(new Button("Log out: " +
                securityService.getAuthenticatedUser().getUsername(), e -> securityService.logout()));
    }


    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("JobProjectWorkshopDisplayView", JobProjectWorkshopDisplayView.class),
                new RouterLink("ApplicationsView", ApplicationsView.class),
                new RouterLink("EditFirmProfileDisplayView", EditFirmProfileDisplayView.class),
                new RouterLink("HomepageUnternehmenView", HomepageUnternehmenView.class),
                new RouterLink("StelleAnzeigeErstellenView", StelleAnzeigeErstellenView.class),
                new RouterLink("StudentProfileDisplayView", StudentProfileDisplayView.class),
                new RouterLink("---ApplicationView", ApplicationView.class),
                new RouterLink("---ChatView", ChatView.class),
                new RouterLink("---FirmProfileDisplayView", FirmProfileDisplayView.class)
        ));
    }
}