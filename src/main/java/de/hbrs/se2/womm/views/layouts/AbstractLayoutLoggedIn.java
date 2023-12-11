package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import de.hbrs.se2.womm.config.SecurityService;

abstract class AbstractLayoutLoggedIn extends AbstractLayout {
    protected final SecurityService securityService;

    AbstractLayoutLoggedIn(SecurityService securityService) {
        this.securityService = securityService;
        String username = securityService.getAuthenticatedUser() == null ? null :
                securityService.getAuthenticatedUser().getUsername();
        long nutzerId = securityService.getLoggedInNutzerID();
        Button logoutButton = new Button("Log out("+nutzerId+"): " + username,
                e -> securityService.logout());
        logoutButton.setId("womm-logout-button");
        super.createHeaderWithLogoutButton(logoutButton, true);
    }
}
