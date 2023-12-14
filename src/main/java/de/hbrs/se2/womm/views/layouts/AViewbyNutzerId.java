package de.hbrs.se2.womm.views.layouts;
import de.hbrs.se2.womm.config.SecurityService;
public abstract class AViewbyNutzerId extends AbstractViewWithoutController {
    protected long nutzerIDfromLoggedInForDB;
    protected AViewbyNutzerId(SecurityService securityService) {
        super();
        nutzerIDfromLoggedInForDB = securityService.getLoggedInNutzerID();;
    }
    protected abstract Object getDTOFromServiceByNutzerId();
}
