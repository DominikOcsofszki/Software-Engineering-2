package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.student.*;

//@Component
public class StudentLayout extends AbstractLayoutLoggedIn {

    protected StudentLayout(SecurityService securityService) {
        super(securityService);
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (securityService.getAuthenticatedUser() == null ||
                (!securityService.isUserStudent() && !securityService.isUserAdmin()))
            UI.getCurrent().navigate(ROUTING.ALL.AccessDeniedView);
    }

    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                new RouterLink("SAboStudentView ", SAboStudentView.class),
                new RouterLink("SApplicationView ", SApplicationView.class),
                new RouterLink("SChatView ", SChatView.class),
                new RouterLink("SCreateChangeStudentProfileView ", SCreateChangeStudentProfileView.class),
                new RouterLink("SFirmProfileDisplayView ", SFirmProfileDisplayView.class),
                new RouterLink("SHomepageStudentView ", SHomepageStudentView.class),
                new RouterLink("SJobProjectWorkshopDisplayView ", SJobProjectWorkshopDisplayView.class),
                new RouterLink("SNotificationView ", SNotificationView.class),
                new RouterLink("SStudentProfileDisplayView ", SStudentProfileDisplayView.class)
        ));
    }

}
