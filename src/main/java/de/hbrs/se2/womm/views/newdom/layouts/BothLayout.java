package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.ApplicationView;
import de.hbrs.se2.womm.views.ChatView;
import de.hbrs.se2.womm.views.FirmProfileDisplayView;

public class BothLayout extends AbstractLayout {


    protected BothLayout(SecurityService securityService) {
        super.createHeaderWithLogoutButton(new Button("Log out: " + securityService.getAuthenticatedUser().getUsername(),
                e -> securityService.logout()), true);
    }

    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("---ApplicationView", ApplicationView.class),
                new RouterLink("---ChatView", ChatView.class),
                new RouterLink("---FirmProfileDisplayView", FirmProfileDisplayView.class)

//                new RouterLink("JobProjectWorkshopDisplayView", JobProjectWorkshopDisplayView.class),
//                new RouterLink("HomepageStudentView", HomepageStudentView.class),
//                new RouterLink("AboStudentView", AboStudentView.class),
//                new RouterLink("ApplicationView", ApplicationView.class),
//                new RouterLink("ApplicationsView", ApplicationsView.class),
//                new RouterLink("ChatView", ChatView.class),
//                new RouterLink("CreateChangeStudentProfileView", CreateChangeStudentProfileView.class),
//                new RouterLink("EditFirmProfileDisplayView", EditFirmProfileDisplayView.class),
//                new RouterLink("FirmProfileDisplayView", FirmProfileDisplayView.class),
//                new RouterLink("HomepageUnternehmenView", HomepageUnternehmenView.class),
//                new RouterLink("LandingPageView", LandingPageView.class),
//                new RouterLink("LogInView", LoginViewDo.class),
//                new RouterLink("NotificationView", NotificationView.class),
//                new RouterLink("RegistrierungStudentView", RegistrierungStudentView.class),
//                new RouterLink("StelleAnzeigeErstellenView", StelleAnzeigeErstellenView.class),
//                new RouterLink("StudentProfileDisplayView", StudentProfileDisplayView.class),
//                new RouterLink("TODO: Problem BOTH SEE ALL ITEMS", JobProjectWorkshopDisplayView.class)
        ));
    }
}