package de.hbrs.se2.womm.views.components;

import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.services.StelleService;
import de.hbrs.se2.womm.views.layouts.AbstractFilterGrid;

import java.util.List;

public class GridFilterStelle extends AGridFilter<StelleDTO> {
    public GridFilterStelle() {
        super();
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(StelleDTO::getStelleTitel).setHeader("Stellen Titel");
        grid.addColumn(stelleDTO -> stelleDTO.getStelleUnternehmen().getName()).setHeader("Stellen Unternehmen");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "stelleTitel",
                "stelleUnternehmen"
        };
    }

    @Override
    protected String checkItem(StelleDTO dto, String searchBy) {
        return switch (searchBy) {
            case "stelleTitel" -> dto.getStelleTitel();
            case "stelleUnternehmen" -> dto.getStelleUnternehmen().toString();
            default -> null;
        };
    }
}
