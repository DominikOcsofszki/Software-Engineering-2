package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BenachrichtigungService;
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
                setUpMenuBarWommAndTranslateName("Homepage", SHomepageStudentView.class, VaadinIcon.HOME),
                setUpMenuBarWommAndTranslateName("New Advertisements", SNotificationView.class, VaadinIcon.BELL),
                setUpMenuBarWommAndTranslateName("Profile", SStudentProfileDisplayView.class, VaadinIcon.USER),
                setUpMenuBarWommAndTranslateName("Subscriptions", SAboStudentView.class, VaadinIcon.BOOKMARK),
                setUpMenuBarWommAndTranslateName("Applications", SApplicationsView.class, VaadinIcon.BRIEFCASE),
                setUpMenuBarWommAndTranslateName("Edit profile", SCreateChangeStudentProfileView.class, VaadinIcon.EDIT)

                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SChatView"), SChatView.class),//TODO final Check
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SFirmProfileDisplayView"), SFirmProfileDisplayView.class),//TODO check again: delete info was next to it
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SJobProjectWorkshopDisplayView"), SJobProjectWorkshopDisplayView.class),//TODO check again: delete info was next to it
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SNotificationView"), SNotificationView.class), //TODO fianl Check
                //                new RouterLink(VaadinBuilderWomm.translateTextStatic("SApplicationView"), SApplicationView.class), //TODO check again: delete info was next to it
        ));
    }

}
