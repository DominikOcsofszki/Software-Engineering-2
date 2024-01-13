package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;

public abstract class AViewWomm extends VerticalLayout {
    protected VaadinBuilderWomm vaadinBuilderWomm = new VaadinBuilderWomm();

    protected VaadinBuilderWomm getWommBuilder(){
        return vaadinBuilderWomm;
    }
    protected AViewWomm( ) {
//        setWidth("100%");
//        setHeight("100%");
        getStyle().set("overflow", "auto");
        Span inboxCounter = new Span("12");
        inboxCounter.getElement().getThemeList().add("badge contrast pill");
        inboxCounter.getElement().setAttribute("aria-label", "12 unread messages");
        ContextMenu menu = new ContextMenu();
        menu.setOpenOnClick(true);
        menu.setTarget(inboxCounter);
        menu.addItem("This is ContextMenu");
        menu.addItem("Consider Using");
        menu.addItem("ContextMenu");
        menu.addItem("Instead of Notifications");
        add(menu);
        add(inboxCounter);
    }
//    ContextMenu addBenachrichtigungen() {
//
//        ContextMenu menu = new ContextMenu();
//        menu.setOpenOnClick(true);
//        menu.setTarget(inboxCounter);
//        menu.addItem("This is ContextMenu");
//        menu.addItem("Consider Using");
//        menu.addItem("ContextMenu");
//        menu.addItem("Instead of Notifications");
//        return menu;
//    }


}
