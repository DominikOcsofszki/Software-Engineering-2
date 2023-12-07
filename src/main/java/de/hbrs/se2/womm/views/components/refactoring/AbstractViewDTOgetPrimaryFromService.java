package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;

public abstract class AbstractViewDTOgetPrimaryFromService<ExtendsAbstractController extends AbstractControllerWomm,
        ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    private ExtendsAbstractDTO dto;

    public String getPrimaryKeyFromSecurityService() {
        return primaryKeyFromSecurityService;
    }

    protected String primaryKeyFromSecurityService;
    public void getDtoFromControllerWithSetPrimaryKey(){
        String primaryKey = setPrimaryKey();
        dto = (ExtendsAbstractDTO) controller.getDTObyPrimaryKey(primaryKey).getBody();
    }
    abstract String setPrimaryKey();

    public ExtendsAbstractDTO getDto() {
        return dto;
    }


    public ExtendsAbstractController getController() {
        return controller;
    }

    protected AbstractViewDTOgetPrimaryFromService(ExtendsAbstractController controller, SecurityService securityService){
        super();
        this.primaryKeyFromSecurityService = securityService.getLoggedInPrimaryKey();
        this.controller = controller;
    }


}
