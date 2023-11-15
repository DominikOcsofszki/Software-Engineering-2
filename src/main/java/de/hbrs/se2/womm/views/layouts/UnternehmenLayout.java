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

                new RouterLink("UApplicationView ", UApplicationView.class),
                new RouterLink("UApplicationsView ", UApplicationsView.class),
                new RouterLink("UChatView ", UChatView.class),
                new RouterLink("UEditFirmProfileDisplayView ", UEditFirmProfileDisplayView.class),
                new RouterLink("UFirmProfileDisplayView ", UFirmProfileDisplayView.class),
                new RouterLink("UHomepageUnternehmenView ", UHomepageUnternehmenView.class),
                new RouterLink("UStelleAnzeigeErstellenView ", UStelleAnzeigeErstellenView.class),
                new RouterLink("UNotificationView", UNotificationView.class)

        ));
    }
}