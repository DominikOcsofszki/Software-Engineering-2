package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.SHomepageStudentView;
public class StudentLayout extends AbstractLayout {


    protected StudentLayout(SecurityService securityService) {
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + securityService.getAuthenticatedUser().getUsername(),
                        e -> securityService.logout()), true
        );
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
