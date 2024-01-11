package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.UI;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.views.layouts.ROUTING;

public class GridFilterBewerbung extends AGridFilter<BewerbungDTO> {

    @Override
    protected void configureGrid() {
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStudent().getStudentName()).setHeader("Lastname");
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStudent().getStudentVorname()).setHeader("Firstname");
        grid.addColumn(BewerbungDTO::getBewerbungText).setHeader("Application");
        grid.addColumn(BewerbungDTO::getBewerbungStatus).setHeader("Status");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "Lastname",
                "Firstname",
        };
    }

    @Override
    protected String checkItem(BewerbungDTO dto, String searchBy) {
        return switch (searchBy) {
            case "Lastname" -> dto.getBewerbungStudent().getStudentName();
            case "Firstname" -> dto.getBewerbungStudent().getStudentVorname();
            default -> null;
        };
    }

    public void setColumnClickListener() {
        this.grid.addItemClickListener(item -> UI.getCurrent()
                .navigate(ROUTING.UNTERNEHMEN.UApplicationView + "/" + (item.getItem()).getBewerbungId()));
    }
}
