package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.GridVariant;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;

import java.time.format.DateTimeFormatter;

public class GridFilterStelle extends AGridFilter<StelleDTO>{
    public GridFilterStelle() {
        super();
    }

    @Override
    protected void configureGrid() {
        String header1 = VaadinBuilderWomm.translateTextStatic("Advertisement title");
        grid.addColumn(StelleDTO::getStelleTitel).setHeader(new Html("<b>" +header1+"</b>"));
        String header2 = VaadinBuilderWomm.translateTextStatic("Firm name");
        grid.addColumn(stelleDTO -> stelleDTO.getUnternehmen().getName()).setHeader(new Html("<b>" +header2+"</b>"));
        String header3 = VaadinBuilderWomm.translateTextStatic("Advertisement description");
        grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader(new Html("<b>" +header3+"</b>"));
//        grid.addColumn(StelleDTO::getErstellungsdatum).setHeader("Erstellungsdatum").setSortable(true);
        grid.addColumn(StelleDTO::getErstellungsdatum).setHeader("Erstellungsdatum").setSortable(true);
//        grid.addThemeVariants(GridVariant.LUMO_WRAP_CELL_CONTENT); //TODO Adding to show all Text
//                .setFooter(String.format("%s total Advertisement", 1000));; //TODO any reason for html???/
        //We can also add footer to grid, e.g. with the number of advertisments


    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        String str1 = VaadinBuilderWomm.translateTextStatic("Advertisement title");
        String str2 = VaadinBuilderWomm.translateTextStatic("Firm name");
        return new String[]{
                str1,
                str2
        };
    }

    @Override
    protected String checkItem(StelleDTO dto, String searchBy) {

        return switch (searchBy) {
            case "Name Stellenanzeige" -> dto.getStelleTitel();
            case "Name Unternehmen" -> dto.getUnternehmen().toString();
            case "Advertisement title" -> dto.getStelleTitel();
            case "Firm name" -> dto.getUnternehmen().toString();
            default -> null;
        };
    }

    public void setColumnClickListener(String location) {
        this.grid.addItemClickListener(item -> UI.getCurrent()
                .navigate(location + "/" + item.getItem().getStelleId()));
    }
}
