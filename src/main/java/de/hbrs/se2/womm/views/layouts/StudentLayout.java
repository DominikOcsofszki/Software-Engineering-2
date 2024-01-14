package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.views.student.*;


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
                setUpMenuBarWomm("SHomepageStudentView", SHomepageStudentView.class, VaadinIcon.HOME),
                setUpMenuBarWomm("SStudentProfileDisplayView", SStudentProfileDisplayView.class, VaadinIcon.USER),
                setUpMenuBarWomm("SAboStudentView", SAboStudentView.class, VaadinIcon.BOOKMARK),
                setUpMenuBarWomm("SApplicationsView", SApplicationsView.class, VaadinIcon.BRIEFCASE),
                setUpMenuBarWomm("SCreateChangeStudentProfileView", SCreateChangeStudentProfileView.class, VaadinIcon.EDIT)

  /* Old way deelte later after approve
   new RouterLink(VaadinBuilderWomm.translateTextStatic("SAboStudentView"), SAboStudentView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SApplicationsView"), SApplicationsView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SCreateChangeStudentProfileView"), SCreateChangeStudentProfileView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SHomepageStudentView"), SHomepageStudentView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SStudentProfileDisplayView"), SStudentProfileDisplayView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SAboStudentView"), SAboStudentView.class)
*/





        ));
    }

}
