package de.hbrs.se2.womm.views.newdom.layouts;

//import de.hbrs.se2.womm.views.newdom.PreviewDo;

public class LoggedOutLayout extends AbstractLayout {


    protected LoggedOutLayout() {
        super.createHeaderWithLogoutButton(null, false);
    }


//    void createDrawer() {
//        addToDrawer(new VerticalLayout(
//                new RouterLink("Login", LoginViewDo.class),
//                new RouterLink("Register - ToDo", LoginViewDo.class),
//                new RouterLink("Preview/LandingPage? ", PreviewDo.class)
//        ));
//    }
}