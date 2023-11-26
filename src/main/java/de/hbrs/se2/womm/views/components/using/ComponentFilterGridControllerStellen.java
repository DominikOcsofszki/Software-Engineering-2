package de.hbrs.se2.womm.views.components.using;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import de.hbrs.se2.womm.controller.AbstractControllerForFilter;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;

import java.util.List;

public class ComponentFilterGridControllerStellen extends VerticalLayout {
    TextField filterText = new TextField();
    Select<String> select = new Select<>();
    Grid<StelleDTO> grid = new Grid<>();
    String[] filterByItemsFromDTO = StelleDTO.getAllFilter();

    public ComponentFilterGridControllerStellen(AbstractControllerForFilter controller) {
        List<? extends AbstractDTO> itemsForGrid = getItemsForGrid(controller);
        setUpGrid(itemsForGrid);
        add(getToolbar(), grid);
        setFilterBy(filterByItemsFromDTO[0]);
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }
    private List<? extends AbstractDTO> getItemsForGrid(AbstractControllerForFilter controller){
        return ((StelleController)controller).getAll().getBody(); //ToDo: change Cast here
    }

    private void setUpGrid(List<? extends AbstractDTO> itemsForGrid){
        addClassName("list-view");
        setSizeFull();
        configureGrid();
//        grid.setItems();
        grid.setItems((List<StelleDTO>)itemsForGrid); //TODO: change Cast here

    }
    private Select<String> selectFilterMenu() {
        select.setPlaceholder("Filter");
        select.setItems(filterByItemsFromDTO);
        return select;
    }
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setValueChangeTimeout(300);
        Select<String> selecterMenu = selectFilterMenu();
        var toolbar = new HorizontalLayout(filterText,selecterMenu);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addColumn(StelleDTO::getStelleId).setHeader("StelleId").setSortable(true).setComparator(StelleDTO::getStelleId);
        grid.addColumn(StelleDTO::getStelleTitel).setHeader("StelleTitel").setSortable(true).setComparator(StelleDTO::getStelleTitel);
        grid.addColumn(StelleDTO::getStelleOrt).setHeader("StelleOrt").setSortable(true).setComparator(StelleDTO::getStelleOrt);
        grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader("StelleBeschreibung").setSortable(true).setComparator(StelleDTO::getStelleBeschreibung);
        grid.addColumn(StelleDTO::getStelleWebsite).setHeader("StelleWebsite").setSortable(true).setComparator(StelleDTO::getStelleWebsite);
        grid.addColumn(StelleDTO::getStelleUnternehmen).setHeader("StelleUnternehmen").setSortable(true).setComparator(StelleDTO::UnternehmenName);
    }


    private void setFilterBy(String searchBy) {
        filterText.addValueChangeListener(
                (AbstractField.ComponentValueChangeEvent<TextField, String> event)
                        -> {
                    String inputSearchNameFilter = event.getValue();
                    ((ListDataProvider<StelleDTO>) grid.getDataProvider()).
                            setFilter((StelleDTO stelleDTO)
                                    -> filterFunction(stelleDTO, inputSearchNameFilter, searchBy));
                }
        );
    }
    private boolean filterFunction(StelleDTO stelleDTO, String inputSearchNameFilter, String searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkUnternehmen = switch (searchBy) {
            case  "stelleId" -> stelleDTO.getStelleId().toString().toLowerCase();
            case  "stelleTitel" -> stelleDTO.getStelleTitel().toString().toLowerCase();
            case  "stelleOrt" -> stelleDTO.getStelleOrt().toString().toLowerCase();
            case  "stelleBeschreibung" -> stelleDTO.getStelleBeschreibung().toString().toLowerCase();
            case  "stelleWebsite" -> stelleDTO.getStelleWebsite().toString().toLowerCase();
            case  "stelleUnternehmen" -> stelleDTO.getStelleUnternehmen().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkUnternehmen.contains(inputSearchNameFilter);
    }
}