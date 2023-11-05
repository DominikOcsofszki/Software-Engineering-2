package de.hbrs.se2.womm.views.newdom;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;

public abstract class AbstractView extends VerticalLayout {
    private final SecurityService securityService;

    protected AbstractView(SecurityService securityService) {
        this.securityService = securityService;
        String username = securityService.getAuthenticatedUser().getUsername();
        Button logout = new Button("Log out " + username, e -> securityService.logout());
        var header = new HorizontalLayout(new DrawerToggle(), logout);
        add(header);
    }





}
