package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.NutzerDTO;
import org.springframework.security.core.userdetails.UserDetails;

abstract class AbstractLayoutLoggedIn extends AbstractLayout {
    protected final SecurityService securityService;
    protected final UserDetails userDetails;
    protected final long nutzerId;
    protected final String username;

    AbstractLayoutLoggedIn(SecurityService securityService) {
        this.securityService = securityService;
        this.userDetails = securityService.getAuthenticatedUser();
        System.out.println("userDetails: " + userDetails);
        this.nutzerId  = userDetails == null ? -1 : ((NutzerDTO) userDetails).getNutzerId();
        this.username = userDetails == null ? null : userDetails.getUsername();
        super.createHeaderWithLogoutButton(new Button("Log out: " + this.username,
                        e -> securityService.logout()),
                true);
    }
}
