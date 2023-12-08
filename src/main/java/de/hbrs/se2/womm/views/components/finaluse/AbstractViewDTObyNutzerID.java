package de.hbrs.se2.womm.views.components.finaluse;

import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.views.components.refactoring.AbstractViewNoController;

public abstract class AbstractViewDTObyNutzerID
        <ExtendsAbstractController extends AbstractControllerWomm, ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    private ExtendsAbstractDTO dto;
    protected String NutzerId;


    public String getPrimaryKeyAsFromSecurityServiceWhenStartupString() {
        return NutzerId;
    }

    private void setDtoFromControllerWithSetPrimaryKey() {
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

    protected AbstractViewDTObyNutzerID(ExtendsAbstractController controller, SecurityService securityService) {
        super();
        this.NutzerId = securityService.getLoggedInNutzerID();
        this.controller = controller;
        setDtoFromControllerWithSetPrimaryKey();
    }

}
