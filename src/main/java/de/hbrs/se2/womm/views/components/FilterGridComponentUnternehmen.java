package de.hbrs.se2.womm.views.extra;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.component.AbstractField;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.components.SEARCHFILTER;

import static de.hbrs.se2.womm.views.components.SEARCHFILTER.*;
public class FilterGridComponentUnternehmen extends VerticalLayout {
    Grid<UnternehmenDTO> grid = new Grid<>();
    TextField filterText = new TextField();
    Select<SEARCHFILTER> select = new Select<>();

    public FilterGridComponentUnternehmen(UnternehmenService unternehmenService) {
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        grid.setItems(unternehmenService.getAll());
        add(getToolbar(), grid);
        setFilterBy(select.getValue());
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }
    private Select<SEARCHFILTER> selectFilterMenu() {
        select.setPlaceholder("Filter");
        select.setItems(SEARCHFILTER.allSEARCHFILTER());
        select.setValue(NAME);
        return select;
    }
    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.setValueChangeTimeout(300);
        Select<SEARCHFILTER> selecterMenu = selectFilterMenu();
        var toolbar = new HorizontalLayout(filterText,selecterMenu);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private void configureGrid() {
        grid.addComponentColumn(UnternehmenDTO::getImage).setHeader("Logo");
        grid.addColumn(UnternehmenDTO::getName).setHeader("Name")
                .setSortable(true)
                .setComparator(UnternehmenDTO::getName);
        grid.addColumn(UnternehmenDTO::getBeschreibung).setHeader("Beschreibung")
                .setSortable(true)
                .setComparator(UnternehmenDTO::getBeschreibung);
        grid.addColumn(UnternehmenDTO::getGruendung).setHeader("Gruendung")
                .setSortable(true)
                .setComparator(UnternehmenDTO::getGruendung);
        grid.addColumn(UnternehmenDTO::getUnternehmenId).setHeader("UnternehmenId")
                .setSortable(true)
                .setComparator(UnternehmenDTO::getUnternehmenId);
    }

    private void setFilterBy(SEARCHFILTER searchBy) {
        filterText.addValueChangeListener(
                (AbstractField.ComponentValueChangeEvent<TextField, String> event) -> {
                    String inputSearchNameFilter = event.getValue();
                    ((ListDataProvider<UnternehmenDTO>) grid.getDataProvider()).
                            setFilter((UnternehmenDTO unternehmenDTO)
                                    -> filterFunction(unternehmenDTO, inputSearchNameFilter, searchBy));
                }
        );
    }

    private boolean filterFunction(UnternehmenDTO unternehmenDTO, String inputSearchNameFilter, SEARCHFILTER searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkUnternehmen = switch (searchBy) {
            case UNTERNEHMENID -> unternehmenDTO.getUnternehmenId().toString().toLowerCase();
            case NAME -> unternehmenDTO.getName().toLowerCase();
            case BESCHREIBUNG -> unternehmenDTO.getBeschreibung().toLowerCase();
            case GRUENDUNG -> unternehmenDTO.getGruendung().toLowerCase();
            case NUTZER -> unternehmenDTO.getNutzer().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };

        return checkUnternehmen.contains(inputSearchNameFilter);
    }
}
