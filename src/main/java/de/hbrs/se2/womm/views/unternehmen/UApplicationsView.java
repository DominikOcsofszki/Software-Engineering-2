package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.BewerbungController;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UApplicationsView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("ApplicationsView")
public class UApplicationsView extends VerticalLayout {
    private long id;
    public UApplicationsView(BewerbungController controller, SecurityService securityService) {
//        this.id = Long.parseLong(securityService.getLoggedInNutzerID());//ToDo changed
        this.id = 1;
    }
}
