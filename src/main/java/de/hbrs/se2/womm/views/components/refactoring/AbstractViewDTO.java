//package de.hbrs.se2.womm.views.components.refactoring;
//
//import de.hbrs.se2.womm.controller.AbstractControllerWomm;
//import de.hbrs.se2.womm.dtos.AbstractDTO;
//
//public abstract class AbstractViewDTO<ExtendsAbstractController extends AbstractControllerWomm,
//        ExtendsAbstractDTO extends AbstractDTO>
//        extends AbstractViewNoController {
//
//    private final ExtendsAbstractController controller;
//    private ExtendsAbstractDTO dto;
//    public void getDtoFromControllerWithSetPrimaryKey(){
//        String primaryKey = setPrimaryKey();
//        dto = (ExtendsAbstractDTO) controller.getDTObyPrimaryKeyIfNegativeAll(primaryKey).getBody();
////        dto = (ExtendsAbstractDTO) controller.getDTObyNutzerId(primaryKey).getBody();
//    }
//    abstract String setPrimaryKey();
//
//    public ExtendsAbstractDTO getDto() {
//        return dto;
//    }
//
//
//    public ExtendsAbstractController getController() {
//        return controller;
//    }
//
//    protected AbstractViewDTO(ExtendsAbstractController controller) {
//        super();
//        this.controller = controller;
//    }
//
//
//}
