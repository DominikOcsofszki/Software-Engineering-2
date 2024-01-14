package de.hbrs.se2.womm.views.unternehmen;

import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import de.hbrs.se2.womm.views.sonardupplicates.BJobProjectWorkshopDisplayView;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.UNTERNEHMEN.UJobProjectWorkshopDisplayView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("JobProjectWorkshopDisplayView")
public class UJobProjectWorkshopDisplayView extends BJobProjectWorkshopDisplayView implements HasUrlParameter<Long> {

    public UJobProjectWorkshopDisplayView(StelleService stelleService, SecurityService securityService, BewerbungService bewerbungService, StudentService studentService) {
        super(stelleService, securityService, bewerbungService, studentService);
    }
}
