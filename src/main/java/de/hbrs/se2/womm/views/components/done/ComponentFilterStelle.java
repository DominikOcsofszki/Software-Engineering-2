//package de.hbrs.se2.womm.views.components.done;
//
//import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.data.renderer.LitRenderer;
//import de.hbrs.se2.womm.controller.AbstractControllerWomm;
//import de.hbrs.se2.womm.dtos.NutzerDTO;
//import de.hbrs.se2.womm.dtos.StelleDTO;
//import de.hbrs.se2.womm.views.SFirmProfileDisplayView;
//import de.hbrs.se2.womm.views.SJobProjectWorkshopDisplayView;
//import tools.generate.GENERATOR;
//
//import java.util.List;
//
//public class ComponentFilterStelle extends AbstractComponentFilterWithController<StelleDTO>{
//    public ComponentFilterStelle(AbstractControllerWomm controller) {
//        super(controller);
//    }
//
//    @Override
//    protected List<?> getItemsFromControllerOrGenerate() {
//        return GENERATOR.generateStelleDTO(100);
//    }
//
//    @Override
//    protected void configureGrid() {
//            addClickableItemsToGridStelle("Titel");
//            //grid.addColumn(StelleDTO::getStelleId).setHeader("Id").setSortable(true).setComparator(StelleDTO::getStelleId);
////        grid.addColumn(StelleDTO::getStelleTitel).setHeader("Titel").setSortable(true).setComparator(StelleDTO::getStelleTitel);
//            //grid.addColumn(StelleDTO::getStelleTitel).setHeader("Titel").setSortable(true).setComparator(StelleDTO::getStelleTitel);
//            grid.addColumn(StelleDTO::getStelleOrt).setHeader("Ort").setSortable(true).setComparator(StelleDTO::getStelleOrt);
//            grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader("Beschreibung").setSortable(true).setComparator(StelleDTO::getStelleBeschreibung);
//            grid.addColumn(StelleDTO::getStelleWebsite).setHeader("Website").setSortable(true).setComparator(StelleDTO::getStelleWebsite);
////        grid.addColumn(StelleDTO::getStelleUnternehmen).setHeader("Unternehmen").setSortable(true).setComparator(StelleDTO::UnternehmenName);
//            addClickableItemsToGrid(grid,"Unternehmen");
//    }
//    private void addClickableItemsToGrid(Grid<StelleDTO> grid, String headerName) {
//        String LIT_TEMPLATE_HTML = """
//                <vaadin-button title="Go to ..."
//                               @click="${clickHandler}"
//                               theme="tertiary-inline small link">
//                    ${item.id}
//                </vaadin-button>""";
//        grid.addColumn(LitRenderer.<StelleDTO>of(LIT_TEMPLATE_HTML)
//                        .withProperty("id", StelleDTO::UnternehmenName)
//                        .withFunction("clickHandler", stelleDTO ->
//                                UI.getCurrent().navigate(
//                                        SFirmProfileDisplayView.class,
//                                        stelleDTO.getStelleUnternehmen().getUnternehmenId().toString())))
//                .setHeader(headerName)
//                .setWidth("25%")
//                .setSortable(true);
//    }
//    private void addClickableItemsToGridStelle(String headerName) {
//        String LIT_TEMPLATE_HTML = """
//                <vaadin-button title="Go to ..."
//                               @click="${clickHandler}"
//                               theme="tertiary-inline small link">
//                    ${item.id}
//                </vaadin-button>""";
//        grid.addColumn(LitRenderer.<StelleDTO>of(LIT_TEMPLATE_HTML)
//                        .withProperty("id", StelleDTO::getStelleTitel)
//                        .withFunction("clickHandler", stelleDTO ->
//                                UI.getCurrent().navigate(
//                                        SJobProjectWorkshopDisplayView.class,stelleDTO.getStelleId().toString())))
//                .setHeader(headerName)
//                .setSortable(true);
//    }
//
//    @Override
//    protected String checkItem(StelleDTO dto, String searchBy) {
//        return switch (searchBy) {
//            case "Titel" -> dto.getStelleTitel();
//            case "Ort" -> dto.getStelleOrt();
//            case "Beschreibung" -> dto.getStelleBeschreibung();
//            case "Website" -> dto.getStelleWebsite();
//            case "Unternehmen" -> dto.getStelleUnternehmen().getName();
//            default -> "";
//        };
//    }
//
//    @Override
//    protected String[] getFilterByItemsFromDTO() {
//        return new String[]{
//                "Titel",
//                "Ort",
//                "Beschreibung",
//                "Website",
//                "Unternehmen"
//        };
//    }
//}
