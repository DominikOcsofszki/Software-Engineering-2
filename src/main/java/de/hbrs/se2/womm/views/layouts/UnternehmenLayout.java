package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.services.SecurityService;
import de.hbrs.se2.womm.views.*;

public class UnternehmenLayout extends AbstractLayout {

    private final SecurityService securityService;

    protected UnternehmenLayout(SecurityService securityService) {
        this.securityService = securityService;
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + securityService.getAuthenticatedUser().getUsername(),
                        e -> securityService.logout()), true
        );
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (!securityService.isUserUnternehmen() && !securityService.isUserAdmin())
            UI.getCurrent().navigate(ROUTING.ALL.AccessDeniedView);
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