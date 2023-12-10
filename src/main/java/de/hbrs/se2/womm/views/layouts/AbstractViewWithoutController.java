package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;

public abstract class AbstractViewWithoutController extends VerticalLayout {
    protected VaadinBuilderWomm vaadinBuilderWomm = new VaadinBuilderWomm();

    protected VaadinBuilderWomm getWommBuilder(){
        return vaadinBuilderWomm;
    }
    protected AbstractViewWithoutController( ) {
//        setWidth("100%");
//        setHeight("100%");
        getStyle().set("overflow", "auto");
    }


}
