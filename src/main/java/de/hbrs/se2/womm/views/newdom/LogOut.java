package de.hbrs.se2.womm.views.newdom;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.newdom.layouts.LoggedOutLayout;

@AnonymousAllowed
@Route(value = "logout", layout = LoggedOutLayout.class)
@PageTitle("Preview")
public class LogOut extends VerticalLayout {
    private final SecurityService securityService;

    public LogOut(SecurityService securityService) {
        this.securityService = securityService;
        setUpBanner();
    }


    private void setUpBanner() {
        Div banner = new Div();
        banner.add(new H1("Logout Page - missing"));
        add(banner);
    }

//    private void setUpBigCompanyAnnouncement() {
//        HorizontalLayout bigCompanyAnnouncement = new HorizontalLayout();
//        VerticalLayout bigCompanyAnnouncement1 = new VerticalLayout();
//        VerticalLayout bigCompanyAnnouncement2 = new VerticalLayout();
//        bigCompanyAnnouncement.add(bigCompanyAnnouncement1);
//        bigCompanyAnnouncement.add(bigCompanyAnnouncement2);
//        add(bigCompanyAnnouncement);
//    }
}
