package de.hbrs.se2.womm.views.components;

import de.hbrs.se2.womm.dtos.BewerbungDTO;

public class GridFilterBewerbung extends AGridFilter<BewerbungDTO> {

    @Override
    protected void configureGrid() {
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStelle().getStelleUnternehmen().getName()).setHeader("Unternehmen");
        grid.addColumn(BewerbungDTO::getBewerbungStelle).setHeader("Stelle");
        grid.addColumn(BewerbungDTO::getBewerbungStatus).setHeader("Status");
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
            case "bewerbungUnternehmen" -> dto.getBewerbungStelle().getStelleUnternehmen().getName();
            case "bewerbungStelle" -> dto.getBewerbungStelle().getStelleTitel();
            case "bewerbungStatus" -> dto.getBewerbungStatus();
            default -> null;
        };
    }
}
