package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.UHomepageUnternehmenView;
import de.hbrs.se2.womm.views.SJobProjectWorkshopDisplayView;

public class UnternehmenLayout extends AbstractLayout {


    protected UnternehmenLayout(SecurityService securityService) {
        super.createHeaderWithLogoutButton(new Button("Log out: " +
                securityService.getAuthenticatedUser().getUsername(), e -> securityService.logout()), true);
    }


    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("JobProjectWorkshopDisplayView", SJobProjectWorkshopDisplayView.class),
                new RouterLink("ApplicationsView", UApplicationsView.class),
                new RouterLink("EditFirmProfileDisplayView", UEditFirmProfileDisplayView.class),
                new RouterLink("HomepageUnternehmenView", UHomepageUnternehmenView.class),
                new RouterLink("StelleAnzeigeErstellenView", UStelleAnzeigeErstellenView.class),
                new RouterLink("StudentProfileDisplayView", StudentProfileDisplayView.class),
                new RouterLink("ApplicationView", UApplicationView.class),
                new RouterLink("ChatView", UChatView.class),
                new RouterLink("FirmProfileDisplayView", UFirmProfileDisplayView.class)
        ));
    }
}