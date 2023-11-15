package de.hbrs.se2.womm.views.newdom.layouts;

public class LoggedOutLayout extends AbstractLayout {


    protected LoggedOutLayout() {
        super.createHeaderWithLogoutButton(null, false);
    }

}