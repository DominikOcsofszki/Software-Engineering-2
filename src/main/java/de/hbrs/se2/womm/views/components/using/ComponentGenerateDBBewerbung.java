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
import de.hbrs.se2.womm.controller.AbstractControllerForFilter;
import de.hbrs.se2.womm.controller.BewerbungController;
import de.hbrs.se2.womm.dtos.AbstractDTO;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.BewerbungService;
import de.hbrs.se2.womm.views.SJobProjectWorkshopDisplayView;
import tools.generate.GenerateBewerbungDTO;

import java.util.List;

public class ComponentGenerateDBBewerbung extends VerticalLayout {
    TextField filterText = new TextField();
    Select<String> select = new Select<>();
    Grid<BewerbungDTO> grid = new Grid<>();
    String[] filterByItemsFromDTO = BewerbungDTO.getAllFilter();
    int demoNr = 100;
    long idLoggedInUser;
    BewerbungController controller;
    BewerbungService bewerbungService;
    public ComponentGenerateDBBewerbung(BewerbungController controller,int demoNr,BewerbungService bewerbungService) {
        this.bewerbungService = bewerbungService;
        this.controller = controller;
        this.demoNr = demoNr;
        List<? extends AbstractDTO> itemsForGrid = getItemsForGrid(controller);
        setUpGrid(itemsForGrid);
        add(getToolbar(), grid);
        setFilterBy(filterByItemsFromDTO[0]);
        select.addValueChangeListener(event -> setFilterBy(event.getValue()));
    }
    private List<? extends AbstractDTO> getItemsForGrid(AbstractControllerForFilter controller){
        return GenerateBewerbungDTO.generateBewerbungDTO(demoNr);
    }

    private void setUpGrid(List<? extends AbstractDTO> itemsForGrid){
        addClassName("list-view");
        setSizeFull();
        configureGrid();
        grid.setItems((List<BewerbungDTO>)itemsForGrid); //TODO: change Cast here

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
    private void addClickableItemsToGridStelle(String headerName) {
        grid.addColumn(LitRenderer.<BewerbungDTO>of(TEMPLATE.LIT_TEMPLATE_HTML_BUTTON)
                        .withProperty("stelle", BewerbungDTO::bewerbungStelleBezeichnung)
                        .withFunction("clickHandler",
                                bewerbungDTO -> {
                                    this.bewerbungService.save(bewerbungDTO.selfThis());
                                }
//                                UI.getCurrent().navigate(
////                                        SJobProjectWorkshopDisplayView.class
////                                        stelleDTO.getStelleId().toString())))
//                              )
                        ))
                .setHeader(headerName)
                .setSortable(true);
    }

    private void configureGrid() {
        addClickableItemsToGridStelle("clickForDBEnter");
        grid.addColumn(BewerbungDTO::bewerbungStelleBezeichnung).setHeader("BewerbungStelle");
        grid.addColumn(BewerbungDTO::getBewerbungText).setHeader("BewerbungText").setSortable(true).setComparator(BewerbungDTO::getBewerbungText);
        grid.addColumn(BewerbungDTO::bewerbungStudentName).setHeader("BewerbungStudent");
        grid.addColumn(BewerbungDTO::getBewerbungId).setHeader("BewerbungId").setSortable(true).setComparator(BewerbungDTO::getBewerbungId);
        grid.addColumn(BewerbungDTO::getBewerbungPdf).setHeader("BewerbungPdf");
    }


    private void setFilterBy(String searchBy) {
        filterText.addValueChangeListener(
                (AbstractField.ComponentValueChangeEvent<TextField, String> event)
                        -> {
                    String inputSearchNameFilter = event.getValue();
                    ((ListDataProvider<BewerbungDTO>) grid.getDataProvider()).
                            setFilter((BewerbungDTO dto)
                                    -> filterFunction(dto, inputSearchNameFilter, searchBy));
                }
        );
    }
    private boolean filterFunction(BewerbungDTO dto, String inputSearchNameFilter, String searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkUnternehmen = switch (searchBy) {
            case  "bewerbungId" -> dto.getBewerbungId().toString().toLowerCase();
//            case  "bewerbungPdf" -> dto.getBewerbungPdf().toString().toLowerCase();
            case  "bewerbungText" -> dto.getBewerbungText().toString().toLowerCase();
            case  "bewerbungStelle" -> dto.getBewerbungStelle().getStelleTitel().toString().toLowerCase();
            case  "bewerbungStudent" -> dto.getBewerbungStudent().getStudentName().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkUnternehmen.contains(inputSearchNameFilter);
    }
}
