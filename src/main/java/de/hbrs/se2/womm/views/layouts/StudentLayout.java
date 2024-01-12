package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.menubar.MenuBar;
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
    private MenuBar newMenu(){
        MenuBar menuBar = new MenuBar();
        Text selected = new Text("");
//        ComponentEventListener<ClickEvent<MenuItem>> listener = e -> selected
//                .setText(e.getSource().getText());
//        b2.addClickListener(e -> UI.getCurrent().navigate(SNotificationView.class));
        ComponentEventListener<ClickEvent<MenuItem>> listener = e ->
                UI.getCurrent().navigate(SNotificationView.class);
        Div message = new Div(new Text("Clicked item: "), selected);

        menuBar.addItem("View", listener);
        menuBar.addItem("Edit", listener);

        MenuItem share = menuBar.addItem("Share");
        SubMenu shareSubMenu = share.getSubMenu();
        MenuItem onSocialMedia = shareSubMenu.addItem("On social media");
        SubMenu socialMediaSubMenu = onSocialMedia.getSubMenu();
        socialMediaSubMenu.addItem("Facebook", listener);
        socialMediaSubMenu.addItem("Twitter", listener);
        socialMediaSubMenu.addItem("Instagram", listener);
        shareSubMenu.addItem("By email", listener);
        shareSubMenu.addItem("Get Link", listener);

        MenuItem move = menuBar.addItem("Move");
        SubMenu moveSubMenu = move.getSubMenu();
        moveSubMenu.addItem("To folder", listener);
        moveSubMenu.addItem("To trash", listener);

        menuBar.addItem("Duplicate", listener);
        return menuBar;
    }
    @Override
    void createDrawer() {
        header.add(newMenu());
        addToDrawer(newMenu());
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
