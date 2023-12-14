package de.hbrs.se2.womm.views.layouts;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.UnternehmenService;

public class NView extends AViewbyNutzerId{
    UnternehmenDTO unternehmenDTO;
    UnternehmenService unternehmenService;
    protected NView(SecurityService securityService, UnternehmenService unternehmenService) {
        super(securityService);
        this.unternehmenService = unternehmenService;
        this.unternehmenDTO = getDTOFromServiceByNutzerId();
    }
    @Override
    protected UnternehmenDTO getDTOFromServiceByNutzerId() {
        return unternehmenService.getUnternehmenByNutzerID(nutzerIDfromLoggedInForDB);
    }
}
