package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.views.LoginViewDo;

public class LoggedOutLayout extends AbstractLayout {

    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("Login", LoginViewDo.class),
                new RouterLink("Register - ToDo", LoginViewDo.class)
        ));
    }
}