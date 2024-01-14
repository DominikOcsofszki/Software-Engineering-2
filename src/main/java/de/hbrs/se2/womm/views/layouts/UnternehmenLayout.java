package de.hbrs.se2.womm.views.layouts;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;
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
                setUpMenuBarWomm("UHomepageUnternehmenView", UHomepageUnternehmenView.class, VaadinIcon.HOME),
                setUpMenuBarWomm("UFirmProfileDisplayView", UFirmProfileDisplayView.class, VaadinIcon.BUILDING),
                setUpMenuBarWomm("UApplicationsView", UApplicationsView.class, VaadinIcon.BRIEFCASE),
                setUpMenuBarWomm("UEditFirmProfileDisplayView", UEditFirmProfileDisplayView.class, VaadinIcon.EDIT),
                setUpMenuBarWomm("UStelleAnzeigeErstellenView", UStelleAnzeigeErstellenView.class, VaadinIcon.PLUS)
        ));
    }
}
