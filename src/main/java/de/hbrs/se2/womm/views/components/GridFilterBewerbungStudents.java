package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.UI;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.views.layouts.ROUTING;

public class GridFilterBewerbungStudents extends AGridFilter<BewerbungDTO> {

    //TODO: Translation is missing
    @Override
    protected void configureGrid() {
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStelle().getUnternehmen().getName()).setHeader("Unternehmen");
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStelle().getStelleTitel()).setHeader("Stelle");
        grid.addColumn(BewerbungDTO::getBewerbungStatus).setHeader("Status");
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungText()).setHeader("Bewerbungstext");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "bewerbungUnternehmen",
                "bewerbungStelle",
                "bewerbungStatus"
        };
    }

    @Override
    protected String checkItem(BewerbungDTO dto, String searchBy) {
        return switch (searchBy) {
            case "bewerbungUnternehmen" -> dto.getBewerbungStelle().getUnternehmen().getName();
            case "bewerbungStelle" -> dto.getBewerbungStelle().getStelleTitel();
            case "bewerbungStatus" -> dto.getBewerbungStatus();
            default -> null;
        };
    }

    public void setColumnClickListener() {
        this.grid.addItemClickListener(item -> UI.getCurrent()
                .navigate(ROUTING.STUDENT.SApplicationView + "/" + item.getItem().getBewerbungId()));
    }
}
