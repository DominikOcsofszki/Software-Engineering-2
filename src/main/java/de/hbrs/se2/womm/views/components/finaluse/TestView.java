package de.hbrs.se2.womm.views.components.finaluse;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.views.layouts.StudentLayout;

@AnonymousAllowed
@Route(value = "test", layout = StudentLayout.class)
public class TestView extends AbstractViewDTObyNutzerID<StelleController, StelleDTO> {

    protected TestView(StelleController stelleController, SecurityService securityService) {
        super(stelleController, securityService);
        add(new FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative(stelleController, selectNutzerIDfromLoggedInForDB()));
    }

}
