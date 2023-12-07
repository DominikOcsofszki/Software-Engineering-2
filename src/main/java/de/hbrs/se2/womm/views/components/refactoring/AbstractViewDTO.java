package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.AbstractDTO;

public class AbstractViewDTO<ExtendsAbstractController extends AbstractControllerWomm,
        ExtendsAbstractDTO extends AbstractDTO>
        extends AbstractViewNoController {

    private final ExtendsAbstractController controller;
    private ExtendsAbstractDTO dto;
    public void getDtoFromController(String primaryKey){
        dto = (ExtendsAbstractDTO) controller.getDTObyID(primaryKey).getBody();
    }

    public ExtendsAbstractDTO getDto() {
        return dto;
    }


    public ExtendsAbstractController getController() {
        return controller;
    }

    protected AbstractViewDTO(ExtendsAbstractController controller) {
        super();
        this.controller = controller;
    }


}
