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
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.views.SJobProjectWorkshopDisplayView;
import tools.generate.GenerateAbonnementsDTOStillUnternehmen;
import tools.generate.GenerateBenachrichtigungenDTOStillUnternehmen;

import java.util.List;

public class ComponentFilterGridControllerBenachrichtigungen
        extends VerticalLayout implements HasUrlParameter<String> {
    TextField filterText = new TextField();
    Select<String> select = new Select<>();
    Grid<UnternehmenDTO> grid = new Grid<>();
    int demoNumber = 100;
    public static String[] filterByItemsFromDTO = new String[]{
            "Unternehmen",
            "Nachricht"
    };


    public ComponentFilterGridControllerBenachrichtigungen() {
        List<? extends AbstractDTO> itemsForGrid = getItemsForGrid();
        setUpGrid(itemsForGrid);
        add(getToolbar(), grid);
        setFilterBy(filterByItemsFromDTO[0]);
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }

    private List<? extends AbstractDTO> getItemsForGrid() {
//        return ((StelleController) controller).getAll().getBody(); //ToDo: change Cast here
        return GenerateBenachrichtigungenDTOStillUnternehmen.generateUnternehmenDTO(demoNumber);
    }

    private void setUpGrid(List<? extends AbstractDTO> itemsForGrid) {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
//        grid.setItems();
        grid.setItems((List<UnternehmenDTO>) itemsForGrid);


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

    private void addClickableItemsToGridStelle(String headerName) {
        grid.addColumn(LitRenderer.<UnternehmenDTO>of(TEMPLATE.LIT_TEMPLATE_HTML)
                        .withProperty("id", UnternehmenDTO::getName)
                        .withFunction("clickHandler", dto ->
                                UI.getCurrent().navigate(
                                        SJobProjectWorkshopDisplayView.class,
                                        dto.getUnternehmenId().toString())))
                .setHeader(headerName)
                .setSortable(true);
    }

    private void configureGrid() {
//        addComponentColumn(person -> {
        grid.addComponentColumn(UnternehmenDTO::getLogo50).setHeader("Logo");
//        grid.addColumn(UnternehmenDTO::getLogo).setHeader("Logo");
        addClickableItemsToGridStelle("Unternehmen");
        grid.addColumn(UnternehmenDTO::getBeschreibung).setHeader("Beschreibung")
                .setSortable(true).setComparator(UnternehmenDTO::getBeschreibung);
    }


    private void setFilterBy(String searchBy) {
        filterText.addValueChangeListener(
                (AbstractField.ComponentValueChangeEvent<TextField, String> event)
                        -> {
                    String inputSearchNameFilter = event.getValue();
                    ((ListDataProvider<UnternehmenDTO>) grid.getDataProvider()).
                            setFilter((UnternehmenDTO dto)
                                    -> filterFunction(dto, inputSearchNameFilter, searchBy));
                }
        );
    }

    private boolean filterFunction(UnternehmenDTO dto, String inputSearchNameFilter, String searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkUnternehmen = switch (searchBy) {
            case "Unternehmen" -> dto.getName().toString().toLowerCase();
            case "Nachricht" -> dto.getBeschreibung().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkUnternehmen.contains(inputSearchNameFilter);
    }

    @Override
    public void setParameter(BeforeEvent event, String parameter) {

    }
}
