package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.controller.ApplicationController;
import de.hbrs.se2.womm.controller.BewerbungController;
import de.hbrs.se2.womm.views.components.using.ComponentFilterGridControllerBewerbung;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UApplicationsView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("ApplicationsView")
public class UApplicationsView extends VerticalLayout {

    public UApplicationsView(BewerbungController controller){
        add(new ComponentFilterGridControllerBewerbung(controller));
    }
}
