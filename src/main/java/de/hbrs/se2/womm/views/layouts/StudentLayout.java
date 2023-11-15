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
                new RouterLink("HomepageStudentView", SHomepageStudentView.class),
                new RouterLink("AboStudentView", SAboStudentView.class),
                new RouterLink("CreateChangeStudentProfileView", SCreateChangeStudentProfileView.class),
                new RouterLink("NotificationView", SNotificationView.class),
                new RouterLink("ApplicationView", SApplicationView.class),
                new RouterLink("ChatView", SChatView.class),
                new RouterLink("FirmProfileDisplayView", SFirmProfileDisplayView.class)
        ));
    }
}
