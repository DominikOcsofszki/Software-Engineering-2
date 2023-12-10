package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;
import de.hbrs.se2.womm.views.unternehmen.*;

public class UnternehmenLayout extends AbstractLayoutLoggedIn {
    protected UnternehmenLayout(SecurityService securityService) {
        super(securityService);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (securityService.getAuthenticatedUser() == null ||
                (!securityService.isUserUnternehmen() && !securityService.isUserAdmin()))
            UI.getCurrent().navigate(ROUTING.ALL.AccessDeniedView);
    }

    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink(VaadinBuilderWomm.translateText("UApplicationView"), UApplicationView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UApplicationsView"), UApplicationsView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UChatView"), UChatView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UEditFirmProfileDisplayView"), UEditFirmProfileDisplayView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UFirmProfileDisplayView"), UFirmProfileDisplayView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UHomepageUnternehmenView"), UHomepageUnternehmenView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UStelleAnzeigeErstellenView"), UStelleAnzeigeErstellenView.class),
                new RouterLink(VaadinBuilderWomm.translateText("UNotificationView"), UNotificationView.class)
        ));
    }
}