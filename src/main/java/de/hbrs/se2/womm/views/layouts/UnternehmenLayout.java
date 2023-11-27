package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.spring.security.AuthenticationContext;
import de.hbrs.se2.womm.views.*;
import de.hbrs.se2.womm.views.UHomepageUnternehmenView;
import org.springframework.security.core.userdetails.UserDetails;

public class UnternehmenLayout extends AbstractLayout {

    private final transient AuthenticationContext authContext;

    protected UnternehmenLayout(AuthenticationContext authContext) {
        this.authContext = authContext;
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + authContext.getAuthenticatedUser(UserDetails.class).get().getUsername(),
                        e -> authContext.logout()), true
        );
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