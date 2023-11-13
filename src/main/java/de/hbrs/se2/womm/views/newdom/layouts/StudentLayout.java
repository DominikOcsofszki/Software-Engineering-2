package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.newdom.HomepageStudentView;
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
                new RouterLink("HomepageStudentView", HomepageStudentView.class),
                new RouterLink("AboStudentView", AboStudentView.class),
                new RouterLink("CreateChangeStudentProfileView", CreateChangeStudentProfileView.class),
                new RouterLink("NotificationView", NotificationView.class),
                new RouterLink("---ApplicationView", ApplicationView.class),
                new RouterLink("---ChatView", ChatView.class),
                new RouterLink("---FirmProfileDisplayView", FirmProfileDisplayView.class)
        ));
    }
}
