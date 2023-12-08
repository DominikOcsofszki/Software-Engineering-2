//package de.hbrs.se2.womm.views.components.done;
//
//import com.vaadin.flow.component.AbstractField;
//import com.vaadin.flow.component.grid.Grid;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.component.select.Select;
//import com.vaadin.flow.component.textfield.TextField;
//import com.vaadin.flow.data.provider.ListDataProvider;
//import com.vaadin.flow.data.value.ValueChangeMode;
//import de.hbrs.se2.womm.controller.AbstractControllerWomm;
//import de.hbrs.se2.womm.dtos.AbstractDTO;
//
//import java.util.List;
//
//public abstract class AbstractComponentFilterWithController<ExtendAbstractDTO extends AbstractDTO> extends VerticalLayout {
//    TextField filterText = new TextField();
//    Select<String> select = new Select<>();
//    protected Grid<ExtendAbstractDTO> grid = new Grid<>();
//    public static String[] filterByItemsFromDTO;
//    protected AbstractControllerWomm controller;
//
//    public AbstractComponentFilterWithController(AbstractControllerWomm controller) {
//        this.controller = controller;
//        this.filterByItemsFromDTO = getFilterByItemsFromDTO();
//        setUpFilter();
//        setUpGrid(getItemsFromControllerOrGenerate());
//        setUpToolbarAndAddGrid();
//    }
//
//
//    private void setUpFilter() {
//        setFilterBy(filterByItemsFromDTO[0]);
//        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
//    }
//
//    abstract protected List<?> getItemsFromControllerOrGenerate();
////    {
////        return getItemsFromController();
////    }
//    protected List<?> getItemsFromController(){
//        if (controller != null) return controller.getAll().getBody();
//        return null;
//    }
//
//    private <T extends AbstractDTO> void setUpGrid(List<?> itemsForGrid) {
//        addClassName("list-view");
//        setSizeFull();
//        configureGrid();
//        List<ExtendAbstractDTO> list = (List<ExtendAbstractDTO>) itemsForGrid;
//        grid.setItems(list);
//    }
//
//
//    protected abstract void configureGrid();
//
//    private void setUpToolbarAndAddGrid() {
//        filterText.setPlaceholder("Filter by...");
//        filterText.setClearButtonVisible(true);
//        filterText.setValueChangeMode(ValueChangeMode.LAZY);
//        filterText.setValueChangeTimeout(300);
//        select.setPlaceholder("Filter");
//        select.setItems(filterByItemsFromDTO);
//        HorizontalLayout toolbar = new HorizontalLayout(filterText, select);
//        toolbar.addClassName("toolbar");
//        add(toolbar, grid);
//    }
//
//    private void setFilterBy(String searchBy) {
//        filterText.addValueChangeListener(
//                (AbstractField.ComponentValueChangeEvent<TextField, String> event)
//                        -> {
//                    String inputSearchNameFilter = event.getValue();
//                    ((ListDataProvider<ExtendAbstractDTO>) grid.getDataProvider()).
//                            setFilter((ExtendAbstractDTO dto)
//                                    -> filterFunction(dto, inputSearchNameFilter, searchBy));
//                }
//        );
//    }
//
//    boolean compareFilteringToLowerCase(String checkItem, String inputSearchNameFilter) {
//        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
//        return checkItem.contains(inputSearchNameFilter);
//    }
//
//    boolean filterFunction(ExtendAbstractDTO dto, String inputSearchNameFilter, String searchBy) {
//        String checkItem = checkItem(dto, searchBy);
//        return compareFilteringToLowerCase(checkItem, inputSearchNameFilter);
//    }
//
//    protected abstract String[] getFilterByItemsFromDTO();
//    protected abstract String checkItem(ExtendAbstractDTO dto, String searchBy);
//
//}
