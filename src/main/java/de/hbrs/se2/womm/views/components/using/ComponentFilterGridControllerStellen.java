package de.hbrs.se2.womm.views.components.using;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import de.hbrs.se2.womm.controller.AbstractControllerForFilter;
import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.views.SFirmProfileDisplayView;
import de.hbrs.se2.womm.views.SJobProjectWorkshopDisplayView;

import java.util.List;

public class ComponentFilterGridControllerStellen
        extends VerticalLayout implements HasUrlParameter<String> {
    TextField filterText = new TextField();
    Select<String> select = new Select<>();
    Grid<StelleDTO> grid = new Grid<>();
    //String[] filterByItemsFromDTO = StelleDTO.getAllFilter();
    String[] filterByItemsFromDTO = {
            //"Id",
            "Titel",
            "Ort",
            "Beschreibung",
            "Website",
            "Unternehmen"
    };

    public ComponentFilterGridControllerStellen(AbstractControllerForFilter controller) {
        List<? extends AbstractDTO> itemsForGrid = getItemsForGrid(controller);
        setUpGrid(itemsForGrid);
        add(getToolbar(), grid);
        setFilterBy(filterByItemsFromDTO[0]);
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }

    private List<? extends AbstractDTO> getItemsForGrid(AbstractControllerForFilter controller) {
        return ((StelleController) controller).getAll().getBody(); //ToDo: change Cast here
    }

    private void setUpGrid(List<? extends AbstractDTO> itemsForGrid) {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
//        grid.setItems();
        grid.setItems((List<StelleDTO>) itemsForGrid); //TODO: change Cast here

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
        var toolbar = new HorizontalLayout(filterText, selecterMenu);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private static final String LIT_TEMPLATE_HTML = """
            <vaadin-button title="Go to ..."
                           @click="${clickHandler}"
                           theme="tertiary-inline small link">
                ${item.id}
            </vaadin-button>""";

    private void addClickableItemsToGrid(Grid<StelleDTO> grid,String headerName) {
        String LIT_TEMPLATE_HTML = """
                <vaadin-button title="Go to ..."
                               @click="${clickHandler}"
                               theme="tertiary-inline small link">
                    ${item.id}
                </vaadin-button>""";
        grid.addColumn(LitRenderer.<StelleDTO>of(LIT_TEMPLATE_HTML)
                        .withProperty("id", StelleDTO::UnternehmenName)
                        .withFunction("clickHandler", stelleDTO ->
                            UI.getCurrent().navigate(
                                    SFirmProfileDisplayView.class,
                                    stelleDTO.getStelleUnternehmen().getUnternehmenId().toString())))
                .setHeader(headerName)
                .setWidth("25%")
                .setSortable(true);
    }
    private void addClickableItemsToGridStelle(String headerName) {
        String LIT_TEMPLATE_HTML = """
                <vaadin-button title="Go to ..."
                               @click="${clickHandler}"
                               theme="tertiary-inline small link">
                    ${item.id}
                </vaadin-button>""";
        grid.addColumn(LitRenderer.<StelleDTO>of(LIT_TEMPLATE_HTML)
                        .withProperty("id", StelleDTO::getStelleTitel)
                        .withFunction("clickHandler", stelleDTO ->
                                UI.getCurrent().navigate(
                                        SJobProjectWorkshopDisplayView.class,stelleDTO.getStelleId().toString())))
                .setHeader(headerName)
                .setSortable(true);
    }

    private void configureGrid() {
        addClickableItemsToGridStelle("Titel");
        //grid.addColumn(StelleDTO::getStelleId).setHeader("Id").setSortable(true).setComparator(StelleDTO::getStelleId);
//        grid.addColumn(StelleDTO::getStelleTitel).setHeader("Titel").setSortable(true).setComparator(StelleDTO::getStelleTitel);
        //grid.addColumn(StelleDTO::getStelleTitel).setHeader("Titel").setSortable(true).setComparator(StelleDTO::getStelleTitel);
        grid.addColumn(StelleDTO::getStelleOrt).setHeader("Ort").setSortable(true).setComparator(StelleDTO::getStelleOrt);
        grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader("Beschreibung").setSortable(true).setComparator(StelleDTO::getStelleBeschreibung);
        grid.addColumn(StelleDTO::getStelleWebsite).setHeader("Website").setSortable(true).setComparator(StelleDTO::getStelleWebsite);
//        grid.addColumn(StelleDTO::getStelleUnternehmen).setHeader("Unternehmen").setSortable(true).setComparator(StelleDTO::UnternehmenName);
        addClickableItemsToGrid(grid,"Unternehmen");
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
            //case  "Id" -> stelleDTO.getStelleId().toString().toLowerCase();
            case "Titel" -> stelleDTO.getStelleTitel().toString().toLowerCase();
            case "Ort" -> stelleDTO.getStelleOrt().toString().toLowerCase();
            case "Beschreibung" -> stelleDTO.getStelleBeschreibung().toString().toLowerCase();
            case "Website" -> stelleDTO.getStelleWebsite().toString().toLowerCase();
            case "Unternehmen" -> stelleDTO.getStelleUnternehmen().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkUnternehmen.contains(inputSearchNameFilter);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {

    }
}
