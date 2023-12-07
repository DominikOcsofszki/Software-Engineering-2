package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.components.refactoring.VaadinBuilderWomm;

public class StudentLayout extends AbstractLayoutLoggedIn {

    private final SecurityService securityService;

    protected StudentLayout(SecurityService securityService) {
        this.securityService = securityService;
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + securityService.getAuthenticatedUser().getUsername(),
                        e -> securityService.logout()), true
        );
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (securityService.getAuthenticatedUser() == null ||
                (!securityService.isUserStudent() && !securityService.isUserAdmin()))
            UI.getCurrent().navigate(ROUTING.ALL.AccessDeniedView);
    }

    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("SAboStudentView ", SAboStudentView.class),
                new RouterLink("SApplicationView ", SApplicationView.class),
                new RouterLink("SChatView ", SChatView.class),
                new RouterLink("SCreateChangeStudentProfileView ", SCreateChangeStudentProfileView.class),
                new RouterLink("SFirmProfileDisplayView ", SFirmProfileDisplayView.class),
                new RouterLink("SHomepageStudentView ", SHomepageStudentView.class),
                new RouterLink("SJobProjectWorkshopDisplayView ", SJobProjectWorkshopDisplayView.class),
                new RouterLink("SNotificationView ", SNotificationView.class),
                new RouterLink("SStudentProfileDisplayView ", SStudentProfileDisplayView.class)
        ));
    }

    @Override
    public String getPrimaryFromLoggedInUser() { //ToDo check if correct primary
        return securityService.getAuthenticatedUser().getUsername();
    }
}
