package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BenachrichtigungService;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;
import de.hbrs.se2.womm.views.student.*;

//@Component
public class StudentLayout extends AbstractLayoutLoggedIn {
    BenachrichtigungService benachrichtigungService;

    protected StudentLayout(SecurityService securityService,
                           BenachrichtigungService benachrichtigungService) {
        super(securityService, benachrichtigungService);
        this.benachrichtigungService = benachrichtigungService;
    }
//    protected StudentLayout(SecurityService securityService) {
//        super(securityService);
//    }}

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (securityService.getAuthenticatedUser() == null ||
                (!securityService.isUserStudent() && !securityService.isUserAdmin()))
            UI.getCurrent().navigate(ROUTING.ALL.AccessDeniedView);
    }

//        MenuItem share = menuBar.addItem("Share");
//        SubMenu shareSubMenu = share.getSubMenu();
//        MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
//        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
//        socialMediaSubMenu.addItem("Facebook", listener);
//        socialMediaSubMenu.addItem("Twitter", listener);
//        socialMediaSubMenu.addItem("Instagram", listener);


    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
                setUpMenuBarWomm("Homepage", SHomepageStudentView.class, VaadinIcon.HOME),
                setUpMenuBarWomm("Profile", SStudentProfileDisplayView.class, VaadinIcon.USER),
                setUpMenuBarWomm("Subscriptions", SAboStudentView.class, VaadinIcon.BOOKMARK),
                setUpMenuBarWomm("Applications", SApplicationsView.class, VaadinIcon.BRIEFCASE),
                setUpMenuBarWomm("Notifications", SNotificationView.class, VaadinIcon.BELL),
                setUpMenuBarWomm("Edit profile", SCreateChangeStudentProfileView.class, VaadinIcon.EDIT)

  /* Old way deelte later after approve
   new RouterLink(VaadinBuilderWomm.translateTextStatic("SAboStudentView"), SAboStudentView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SApplicationsView"), SApplicationsView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SCreateChangeStudentProfileView"), SCreateChangeStudentProfileView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SHomepageStudentView"), SHomepageStudentView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SStudentProfileDisplayView"), SStudentProfileDisplayView.class),
                new RouterLink(VaadinBuilderWomm.translateTextStatic("SAboStudentView"), SAboStudentView.class)
*/
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SChatView"), SChatView.class),//TODO final Check
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SFirmProfileDisplayView"), SFirmProfileDisplayView.class),//TODO check again: delete info was next to it
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SJobProjectWorkshopDisplayView"), SJobProjectWorkshopDisplayView.class),//TODO check again: delete info was next to it
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SNotificationView"), SNotificationView.class), //TODO fianl Check
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SApplicationView"), SApplicationView.class), //TODO check again: delete info was next to it
        ));
    }

}
