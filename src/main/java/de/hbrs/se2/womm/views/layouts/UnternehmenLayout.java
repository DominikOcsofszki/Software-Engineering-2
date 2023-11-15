package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.HomepageUnternehmenView;
import de.hbrs.se2.womm.views.JobProjectWorkshopDisplayView;

public class UnternehmenLayout extends AbstractLayout {


    protected UnternehmenLayout(SecurityService securityService) {
        super.createHeaderWithLogoutButton(new Button("Log out: " +
                securityService.getAuthenticatedUser().getUsername(), e -> securityService.logout()), true);
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
                new RouterLink("ApplicationView", UApplicationView.class),
                new RouterLink("ChatView", UChatView.class),
                new RouterLink("FirmProfileDisplayView", UFirmProfileDisplayView.class)
        ));
    }
}