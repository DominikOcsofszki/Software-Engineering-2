package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import org.springframework.web.servlet.mvc.AbstractController;

public class AbstractView extends VerticalLayout {
    AbstractControllerWomm controller;
    protected AbstractView(AbstractControllerWomm controller) {
        this.controller = controller;
        setWidth("100%");
        setHeight("100%");
        getStyle().set("overflow", "auto");
    }
}
