package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BenachrichtigungService;
import de.hbrs.se2.womm.views.unternehmen.*;

public class UnternehmenLayout extends AbstractLayoutLoggedIn {
    BenachrichtigungService benachrichtigungService;

    protected UnternehmenLayout(SecurityService securityService,
                            BenachrichtigungService benachrichtigungService) {
        super(securityService, benachrichtigungService);
        this.benachrichtigungService = benachrichtigungService;
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
                setUpMenuBarWomm("UHomepageUnternehmenView", UHomepageUnternehmenView.class, VaadinIcon.HOME),
                setUpMenuBarWomm("UFirmProfileDisplayView", UFirmProfileDisplayView.class, VaadinIcon.BUILDING),
                setUpMenuBarWomm("UApplicationsView", UApplicationsView.class, VaadinIcon.BRIEFCASE),
                setUpMenuBarWomm("UEditFirmProfileDisplayView", UEditFirmProfileDisplayView.class, VaadinIcon.EDIT),
                setUpMenuBarWomm("UStelleAnzeigeErstellenView", UStelleAnzeigeErstellenView.class, VaadinIcon.PLUS)
//                new RouterLink(VaadinBuilderWomm.translateTextStatic("UChatView"), UChatView.class), //TODO final check
//                new RouterLink(VaadinBuilderWomm.translateTextStatic("UNotificationView"), UNotificationView.class) //TODO Final CHECK
        ));
    }
}
/* Old way deelte later after approve
                new RouterLink(VaadinBuilderWomm.translateTextStatic("UApplicationView"), UApplicationView.class),
        new RouterLink(VaadinBuilderWomm.translateTextStatic("UApplicationsView"), UApplicationsView.class),
        new RouterLink(VaadinBuilderWomm.translateTextStatic("UEditFirmProfileDisplayView"), UEditFirmProfileDisplayView.class),
        new RouterLink(VaadinBuilderWomm.translateTextStatic("UFirmProfileDisplayView"), UFirmProfileDisplayView.class),
        new RouterLink(VaadinBuilderWomm.translateTextStatic("UHomepageUnternehmenView"), UHomepageUnternehmenView.class),
        new RouterLink(VaadinBuilderWomm.translateTextStatic("UStelleAnzeigeErstellenView"), UStelleAnzeigeErstellenView.class)
//                new RouterLink(VaadinBuilderWomm.translateTextStatic("UChatView"), UChatView.class), //TODO final check
//                new RouterLink(VaadinBuilderWomm.translateTextStatic("UNotificationView"), UNotificationView.class) //TODO Final CHECK*/
