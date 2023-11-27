package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.security.AuthenticationContext;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.SHomepageStudentView;
import org.springframework.security.core.userdetails.UserDetails;

public class StudentLayout extends AbstractLayout {

    private final transient AuthenticationContext authContext;

    protected StudentLayout(AuthenticationContext authContext) {
        this.authContext = authContext;
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + authContext.getAuthenticatedUser(UserDetails.class).get().getUsername(),
                        e -> authContext.logout()), true
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
