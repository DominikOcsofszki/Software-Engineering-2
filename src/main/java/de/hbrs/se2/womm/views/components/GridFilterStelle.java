package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.GridVariant;
import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;

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
