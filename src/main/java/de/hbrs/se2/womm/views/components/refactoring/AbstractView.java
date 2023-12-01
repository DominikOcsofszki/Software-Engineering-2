package de.hbrs.se2.womm.views.components.refactoring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import org.springframework.web.servlet.mvc.AbstractController;

public class AbstractView<ExtendsAbstractController extends AbstractControllerWomm> extends AbstractViewNoController {
    private ExtendsAbstractController controller;
//    protected VaadinBuilderWomm vaadinBuilderWomm = new VaadinBuilderWomm();

    protected AbstractView(ExtendsAbstractController controller) {
        super();
        this.controller = controller;
//        setWidth("100%");
//        setHeight("100%");
//        getStyle().set("overflow", "auto");
    }


}
