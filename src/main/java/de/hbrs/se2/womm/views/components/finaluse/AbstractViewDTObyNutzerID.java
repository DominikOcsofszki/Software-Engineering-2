package de.hbrs.se2.womm.views.components.finaluse;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.entities.NutzerLogin;
import de.hbrs.se2.womm.views.components.refactoring.AbstractViewNoController;

public abstract class AbstractViewDTObyNutzerID
        <ExtendsAbstractController extends AbstractControllerWomm, ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    protected final ExtendsAbstractDTO dto;
    SecurityService securityService;
    protected String selectNutzerIDforDB(){
        return securityService.getLoggedInNutzerID();
    }

//    public ExtendsAbstractDTO getDto() {
//        return dto;
//    }
//
//
//    public ExtendsAbstractController getController() {
//        return controller;
//    }

    protected AbstractViewDTObyNutzerID(ExtendsAbstractController controller, SecurityService securityService) {
        super();
        this.controller = controller;
        this.securityService = securityService;
        String primaryKey = selectNutzerIDforDB();
        dto = (ExtendsAbstractDTO) controller.getDTObyPrimaryKey(primaryKey).getBody();
    }

}
