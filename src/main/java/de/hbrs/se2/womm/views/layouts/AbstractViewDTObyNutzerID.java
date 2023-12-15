package de.hbrs.se2.womm.views.layouts;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;

import java.util.List;

public abstract class AbstractViewDTObyNutzerID
        <ExtendsAbstractController extends AbstractControllerWomm, ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewWithoutController {

    SecurityService securityService;
    protected long selectNutzerIDfromLoggedInForDB(){
        return securityService.getLoggedInNutzerID();
    }
}
