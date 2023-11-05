package de.hbrs.se2.womm.views.newdom.layouts;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
//import org.springdoc.core.service.SecurityService;

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
