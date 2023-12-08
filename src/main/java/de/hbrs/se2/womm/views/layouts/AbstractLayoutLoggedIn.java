package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import de.hbrs.se2.womm.config.SecurityService;

abstract class AbstractLayoutLoggedIn extends AbstractLayout {
    protected final SecurityService securityService;

    AbstractLayoutLoggedIn(SecurityService securityService) {
        this.securityService = securityService;
//        UserDetails userDetails = securityService.getAuthenticatedUser();
//        System.out.println("userDetails: " + userDetails); //ToDo delete later
//        String username = userDetails == null ? null : userDetails.getUsername();
        String username = securityService.getAuthenticatedUser() == null ? null :
                securityService.getAuthenticatedUser().getUsername();
        super.createHeaderWithLogoutButton(new Button("Log out: " + username,
                        e -> securityService.logout()), true);
    }
}
