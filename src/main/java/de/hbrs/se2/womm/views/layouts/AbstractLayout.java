package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

abstract class AbstractLayout extends AppLayout {

    public AbstractLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 name = new H1("w.o.m.m.");
        Image logo = new Image("themes/theme_1/logo.png", "An image in the theme");

        logo.setWidth(50, Unit.PIXELS);
        logo.setHeight(50, Unit.PIXELS);
        logo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.MEDIUM);
        var header = new HorizontalLayout(new DrawerToggle(), logo, name);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.addClassNames(
                LumoUtility.Padding.Vertical.NONE,
                LumoUtility.Padding.Horizontal.MEDIUM);
        addToNavbar(header);

    }

    abstract void createDrawer();
}

/*
    @Override
    void createDrawer() {
        addToDrawer(new VerticalLayout(
//                new RouterLink("JobProjectWorkshopDisplayView", JobProjectWorkshopDisplayView.class),
                new RouterLink("HomepageStudentView", HomepageStudentView.class)
//                new RouterLink("AboStudentView", AboStudentView.class),
//                new RouterLink("ApplicationView", ApplicationView.class),
//                new RouterLink("ApplicationsView", ApplicationsView.class),
//                new RouterLink("ChatView", ChatView.class),
//                new RouterLink("CreateChangeStudentProfileView", CreateChangeStudentProfileView.class),
//                new RouterLink("EditFirmProfileDisplayView", EditFirmProfileDisplayView.class),
//                new RouterLink("FirmProfileDisplayView", FirmProfileDisplayView.class),
//                new RouterLink("HomepageUnternehmenView", HomepageUnternehmenView.class),
//                new RouterLink("LandingPageView", LandingPageView.class),
//                new RouterLink("LogInView", LogInView.class),
//                new RouterLink("NotificationView", NotificationView.class),
//                new RouterLink("RegistrierungStudentView", RegistrierungStudentView.class),
//                new RouterLink("StelleAnzeigeErstellenView", StelleAnzeigeErstellenView.class),
//                new RouterLink("StudentProfileDisplayView", StudentProfileDisplayView.class)
        ));
    }*/
