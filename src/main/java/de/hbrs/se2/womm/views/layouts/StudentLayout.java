package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;
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
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SAboStudentView"), SAboStudentView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SApplicationView"), SApplicationView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SApplicationsView"), SApplicationsView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SChatView"), SChatView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SCreateChangeStudentProfileView"), SCreateChangeStudentProfileView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SFirmProfileDisplayView"), SFirmProfileDisplayView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SHomepageStudentView"), SHomepageStudentView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SJobProjectWorkshopDisplayView"), SJobProjectWorkshopDisplayView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SNotificationView"), SNotificationView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SStudentProfileDisplayView"), SStudentProfileDisplayView.class)
        ));
    }

}
