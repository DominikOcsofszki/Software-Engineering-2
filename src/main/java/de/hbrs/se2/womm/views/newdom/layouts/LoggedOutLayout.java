package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.views.SFirmProfileDisplayView;
import de.hbrs.se2.womm.views.LandingPageView;
import de.hbrs.se2.womm.views.newdom.LoginViewDo;
import de.hbrs.se2.womm.views.newdom.PreviewDo;
//import de.hbrs.se2.womm.views.newdom.PreviewDo;

public class LoggedOutLayout extends AbstractLayout {


    protected LoggedOutLayout() {
        super.createHeaderWithLogoutButton(null);
    }


    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("Login", LoginViewDo.class),
                new RouterLink("Register - ToDo", LoginViewDo.class),
                new RouterLink("Preview/LandingPage? ", PreviewDo.class),
                new RouterLink("LandingPage", LandingPageView.class),
                new RouterLink("FirmProfileDisplayView", SFirmProfileDisplayView.class)
        ));
    }
}