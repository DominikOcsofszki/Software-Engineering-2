package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.*;
import org.springframework.security.core.userdetails.UserDetails;

public class UnternehmenLayout extends AbstractLayoutLoggedIn {

    private final SecurityService securityService;
    public final String primaryKey;
    protected UnternehmenLayout(SecurityService securityService) {
        primaryKey = securityService.getAuthenticatedUser().getUsername();
        this.securityService = securityService;
//        UserDetails getUser = securityService.getAuthenticatedUser();
//        String username = getUser == null ? null : getUser.getUsername();
        String username = securityService.getAuthenticatedUser() == null ?
                 null: securityService.getAuthenticatedUser().getUsername();
        super.createHeaderWithLogoutButton(
                new Button("Log out: " + username,
                        e -> securityService.logout()), true
        );
//        super.createHeaderWithLogoutButton(
//                new Button("Log out: " + securityService.getAuthenticatedUser().getUsername(),
//                        e -> securityService.logout()), true
//        );
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