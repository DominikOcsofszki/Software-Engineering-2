//package de.hbrs.se2.womm.views.components.done;
//
//import de.hbrs.se2.womm.controller.AbstractControllerWomm;
//import de.hbrs.se2.womm.dtos.UnternehmenDTO;
//
//import java.util.List;
//
//public class ComponentDTOTest extends AbstractComponentFilterWithController <UnternehmenDTO>{
//    public ComponentDTOTest(AbstractControllerWomm controller) {
//        super(controller);
//    }
//
//    @Override
//    protected List<?> getItemsFromControllerOrGenerate() {
//        return getItemsFromController();
//    }
//
//    @Override
//    protected void configureGrid() {
//        grid.addColumn(UnternehmenDTO::getName).setHeader("getname").
//                setSortable(true).setComparator(UnternehmenDTO::getName);
//    }
//
//    @Override
//    protected String[] getFilterByItemsFromDTO() {
//        return new String[]{
//            "Unternehmen",
//            "Nachricht"
//        };
//    }
//
//    @Override
//    protected String checkItem(UnternehmenDTO dto, String searchBy) {
//        return switch (searchBy) {
//            case "Unternehmen" -> dto.getName().toString().toLowerCase();
//            case "Nachricht" -> dto.getBeschreibung().toString().toLowerCase();
//            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
//        };
//    }
//}
