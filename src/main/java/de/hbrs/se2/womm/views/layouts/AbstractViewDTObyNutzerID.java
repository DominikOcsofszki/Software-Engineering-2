package de.hbrs.se2.womm.views.layouts;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;

import java.util.List;

public abstract class AbstractViewDTObyNutzerID
        <ExtendsAbstractController extends AbstractControllerWomm, ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    protected final List<? extends AbstractDTO> dto;
    SecurityService securityService;
    protected long selectNutzerIDfromLoggedInForDB(){
        return securityService.getLoggedInNutzerID();
    }

    public AbstractDTO getDtoAbstractCastNeeded() {
        return dto.get(0);
    }


    public ExtendsAbstractController getController() {
        return controller;
    }

    protected AbstractViewDTObyNutzerID(ExtendsAbstractController controller, SecurityService securityService) {
        super();
        this.controller = controller;
        this.securityService = securityService;
        long primaryKey = selectNutzerIDfromLoggedInForDB();

        dto = controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey) == null ? null :
                controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey).getBody();
    }

}
