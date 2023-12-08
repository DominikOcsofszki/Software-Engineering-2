package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.components.refactoring.VaadinBuilderWomm;
import org.springframework.security.core.userdetails.UserDetails;

public class StudentLayout extends AbstractLayoutLoggedIn {
    private final SecurityService securityService;
//    private final long nutzerId;//ToDo changed here

    protected StudentLayout(SecurityService securityService) {
//        nutzerId  = ((NutzerDTO)securityService.getAuthenticatedUser()).getNutzerId();//ToDo changed here
        this.securityService = securityService;
        String username = securityService.getAuthenticatedUser() == null ?
                "no user": securityService.getAuthenticatedUser().getUsername();
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + username,
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

}
