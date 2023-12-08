package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;

public abstract class AbstractViewDTOgetPrimaryFromSecurityServiceLast<ExtendsAbstractController extends AbstractControllerWomm,
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
//    abstract String setPrimaryKey();
    String setPrimaryKey() {
        return getPrimaryKeyAsFromSecurityServiceWhenStartupString();
    }

    public ExtendsAbstractDTO getDto() {
        return dto;
    }


    public ExtendsAbstractController getController() {
        return controller;
    }

    protected AbstractViewDTOgetPrimaryFromSecurityServiceLast(ExtendsAbstractController controller, SecurityService securityService){
        super();
        this.primaryKeyFromSecurityServiceWhenStartup = securityService.getLoggedInNutzerID();
        this.controller = controller;
        setDtoFromControllerWithSetPrimaryKey();
    }


}
