package de.hbrs.se2.womm.views.components.finaluse;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;

public abstract class AbstractViewNoController extends VerticalLayout {
    protected VaadinBuilderWomm vaadinBuilderWomm = new VaadinBuilderWomm();

    protected VaadinBuilderWomm getVaadinBuilderWomm(){
        return vaadinBuilderWomm;
    }
    protected AbstractViewNoController( ) {
//        setWidth("100%");
//        setHeight("100%");
        getStyle().set("overflow", "auto");
    }


}
