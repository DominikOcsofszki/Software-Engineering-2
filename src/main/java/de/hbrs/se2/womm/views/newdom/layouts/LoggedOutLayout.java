package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.views.newdom.HomepageStudentViewDo;
import de.hbrs.se2.womm.views.newdom.HomepageUnternehmenViewDo;
import de.hbrs.se2.womm.views.newdom.LoginViewDo;
import de.hbrs.se2.womm.views.newdom.PreviewDo;
//import de.hbrs.se2.womm.views.newdom.PreviewDo;

public class LoggedOutLayout extends AbstractLayout {

    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("Login", LoginViewDo.class),
                new RouterLink("Register - ToDo", LoginViewDo.class),
                new RouterLink("Preview ", PreviewDo.class),

                //                new RouterLink("JobProjectWorkshopDisplayView", JobProjectWorkshopDisplayView.class),
                new RouterLink("HomepageStudentView", HomepageStudentViewDo.class),
//                new RouterLink("AboStudentView", AboStudentView.class),
//                new RouterLink("ApplicationView", ApplicationView.class),
//                new RouterLink("ApplicationsView", ApplicationsView.class),
//                new RouterLink("ChatView", ChatView.class),
//                new RouterLink("CreateChangeStudentProfileView", CreateChangeStudentProfileView.class),
//                new RouterLink("EditFirmProfileDisplayView", EditFirmProfileDisplayView.class),
//                new RouterLink("FirmProfileDisplayView", FirmProfileDisplayView.class),
                new RouterLink("HomepageUnternehmenView", HomepageUnternehmenViewDo.class)
//                new RouterLink("LandingPageView", LandingPageView.class),
//                new RouterLink("LogInView", LogInView.class),
//                new RouterLink("NotificationView", NotificationView.class),
//                new RouterLink("RegistrierungStudentView", RegistrierungStudentView.class),
//                new RouterLink("StelleAnzeigeErstellenView", StelleAnzeigeErstellenView.class),
//                new RouterLink("StudentProfileDisplayView", StudentProfileDisplayView.class)
        ));
    }
}