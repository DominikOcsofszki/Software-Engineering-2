package de.hbrs.se2.womm.views.components.finaluse;

import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.StelleDTO;

import java.util.List;

public class FilterGridStelleByLoggedInNutzerId extends AbstractComponentControllerExtended<StelleDTO, StelleController>{
    long filterBy;
    public FilterGridStelleByLoggedInNutzerId(StelleController stelleController, long filterBy) {
        super(stelleController);
        this.filterBy = filterBy;
    }

    @Override
    protected List<StelleDTO> getItemsWithFilter() {
        if (filterBy < 0)
            return null;
        return controller.getStelleByUnternehmenId(Long.valueOf(filterBy)).getBody();
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(StelleDTO::getStelleId).setHeader("Stellen ID");
        grid.addColumn(StelleDTO::getStelleTitel).setHeader("Stellen Titel");
        grid.addColumn(StelleDTO::getStelleOrt).setHeader("Stellen Ort");
        grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader("Stellen Beschreibung");
        grid.addColumn(StelleDTO::getStelleWebsite).setHeader("Stellen Website");
        grid.addColumn(StelleDTO::getStelleUnternehmen).setHeader("Stellen Unternehmen");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "stelleId",
                "stelleTitel",
                "stelleOrt",
                "stelleBeschreibung",
                "stelleWebsite",
                "stelleUnternehmen"
        };
    }

    @Override
    protected String checkItem(StelleDTO dto, String searchBy) {
        return switch (searchBy) {
            case "stelleId" -> dto.getStelleId().toString();
            case "stelleTitel" -> dto.getStelleTitel();
            case "stelleOrt" -> dto.getStelleOrt();
            case "stelleBeschreibung" -> dto.getStelleBeschreibung();
            case "stelleWebsite" -> dto.getStelleWebsite();
            case "stelleUnternehmen" -> dto.getStelleUnternehmen().toString();
            default -> null;
        };
    }
}
