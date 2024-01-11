package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.button.Button;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;

abstract class AbstractLayoutLoggedIn extends AbstractLayout {
    protected final SecurityService securityService;

    AbstractLayoutLoggedIn(SecurityService securityService) {
        this.securityService = securityService;
        String username = securityService.getAuthenticatedUser() == null ? null :
                securityService.getAuthenticatedUser().getUsername();
        long nutzerId = securityService.getLoggedInNutzerID();

        String text = VaadinBuilderWomm.translateTextStatic("Log out"); //TODO better change to this?
//        String text = VaadinBuilderWomm.translateTextStatic("Log out(") + nutzerId + "): " + username;
        Button logoutButton = new Button(text, e -> securityService.logout());
        super.createHeaderWithLogoutButton(logoutButton, true);
    }
}
