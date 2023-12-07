package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility;
import de.hbrs.se2.womm.views.components.refactoring.VaadinBuilderWomm;

abstract class AbstractLayoutLoggedIn extends AbstractLayout {
    abstract public String getPrimaryFromLoggedInUser();
}
