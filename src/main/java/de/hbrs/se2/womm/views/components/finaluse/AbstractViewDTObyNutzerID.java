package de.hbrs.se2.womm.views.components.finaluse;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.views.components.refactoring.AbstractViewNoController;

import java.util.List;

public abstract class AbstractViewDTObyNutzerID
        <ExtendsAbstractController extends AbstractControllerWomm, ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    protected final List<ExtendsAbstractDTO> dto;
    SecurityService securityService;
    protected long selectNutzerIDfromLoggedInForDB(){
        return securityService.getLoggedInNutzerID();
    }

    public ExtendsAbstractDTO getDto() {
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

//        dto = (ExtendsAbstractDTO) controller.getDTObyPrimaryKey(primaryKey).getBody();
//        dto = controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey) == null ? null :
//                (ExtendsAbstractDTO) controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey).getBody();
        dto = controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey) == null ? null :
                (List<ExtendsAbstractDTO>) controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey).getBody();
        System.out.println(dto);
    }

}
