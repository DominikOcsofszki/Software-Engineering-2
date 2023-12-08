package de.hbrs.se2.womm.views.components.finaluse;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.views.components.refactoring.AbstractViewNoController;

public abstract class AbstractViewDTOgetPrimaryFromSecurityService<ExtendsAbstractController extends AbstractControllerWomm,
        ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    private ExtendsAbstractDTO dto;
    protected String primaryKeyFromSecurityServiceWhenStartup;


    public String getPrimaryKeyAsFromSecurityServiceWhenStartupString() {
        return primaryKeyFromSecurityServiceWhenStartup;
    }

    private void setDtoFromControllerWithSetPrimaryKey(){
        String primaryKey = setPrimaryKey();
        dto = (ExtendsAbstractDTO) controller.getDTObyPrimaryKey(primaryKey).getBody();
    }
    abstract String setPrimaryKey();
//    String setPrimaryKey() {
//        return getPrimaryKeyAsFromSecurityServiceWhenStartupString();
//    }

    public ExtendsAbstractDTO getDto() {
        return dto;
    }


    public ExtendsAbstractController getController() {
        return controller;
    }

    protected AbstractViewDTOgetPrimaryFromSecurityService(ExtendsAbstractController controller, SecurityService securityService){
        super();
        this.primaryKeyFromSecurityServiceWhenStartup = securityService.getLoggedInPrimaryKey();
        this.controller = controller;
        setDtoFromControllerWithSetPrimaryKey();
    }


}
