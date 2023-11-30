package de.hbrs.se2.womm.views.components.refactoring;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.generate.GenerateBenachrichtigungenDTOStillUnternehmen;

import java.util.List;

public class ComponentFilterToRefactor<ExtendAbstractDTO extends AbstractDTO> extends VerticalLayout implements HasUrlParameter<String> {
    String parameter;
    TextField filterText = new TextField();
    Select<String> select = new Select<>();
    Grid<ExtendAbstractDTO> grid = new Grid<>();
    int demoNumber = 100;
    public static String[] filterByItemsFromDTO = new String[]{
            "Unternehmen",
            "xxx"
    };

    public ComponentFilterToRefactor() {
        setUpGrid(getItemsFromControllerOrGenerate());
        getToolbar();
        setUpFilter();
    }
    private void setUpFilter() {
        setFilterBy(filterByItemsFromDTO[0]);
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }
    private List<?> getItemsFromControllerOrGenerate() {
        return GenerateBenachrichtigungenDTOStillUnternehmen.generateBenachrichtigungenDTO(demoNumber);
    }

    private <T extends AbstractDTO> void setUpGrid(List<?> itemsForGrid) {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        List<ExtendAbstractDTO> list = (List<ExtendAbstractDTO>) itemsForGrid;
        grid.setItems(list);
    }

    private void getToolbar() {
        filterText.setPlaceholder("Filter by...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setValueChangeTimeout(300);
        select.setPlaceholder("Filter");
        select.setItems(filterByItemsFromDTO);
        HorizontalLayout toolbar = new HorizontalLayout(filterText, select);
        toolbar.addClassName("toolbar");
        add(toolbar, grid);
    }
//
//    private void addClickableItemsToGridStelle(String headerName) {
//        grid.addColumn(LitRenderer.<UnternehmenDTO>of(TEMPLATE.LIT_TEMPLATE_HTML)
//                        .withProperty("id", UnternehmenDTO::getName)
//                        .withFunction("clickHandler", dto ->
//                                UI.getCurrent().navigate(
//                                        SJobProjectWorkshopDisplayView.class,
//                                        dto.getUnternehmenId().toString())))
//                .setHeader(headerName)
//                .setSortable(true);
//    }

    private void configureGrid() {
        grid.addItemClickListener(event -> {
            grid.select(event.getItem());
        });
        grid.addColumn(item -> ((UnternehmenDTO)item).getUnternehmenId()).setHeader("Beschreibung2");
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
        this.parameter = parameter;
    }
}
