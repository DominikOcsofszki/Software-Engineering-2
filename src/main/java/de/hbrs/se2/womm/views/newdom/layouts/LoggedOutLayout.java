package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.views.newdom.LoginViewDo;
import de.hbrs.se2.womm.views.newdom.PreviewDo;
//import de.hbrs.se2.womm.views.newdom.PreviewDo;

public class LoggedOutLayout extends AbstractLayout {


    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("Login", LoginViewDo.class),
                new RouterLink("Register - ToDo", LoginViewDo.class),
                new RouterLink("Preview ", PreviewDo.class)
        ));
    }
}