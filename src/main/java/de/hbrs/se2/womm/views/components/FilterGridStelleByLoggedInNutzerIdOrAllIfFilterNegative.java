package de.hbrs.se2.womm.views.components;

import de.hbrs.se2.womm.controller.StelleController;
import de.hbrs.se2.womm.dtos.StelleDTO;

public class FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative extends AbstractFilterGrid<StelleDTO> {
    private final StelleController stelleController;

    public FilterGridStelleByLoggedInNutzerIdOrAllIfFilterNegative(StelleController stelleController, long filterBy) {
        super(filterBy);
        this.stelleController = stelleController;
    }

    @Override
    protected StelleDTO getItemsWithFilter(long filterBy) {
        System.out.println("filterBy:" + filterBy);
        StelleDTO list = stelleController.getById(filterBy).getBody();
        System.out.println("list:" + list);
        return list;
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(StelleDTO::getStelleId).setHeader("Stellen ID");
        grid.addColumn(StelleDTO::getStelleTitel).setHeader("Stellen Titel");
        grid.addColumn(StelleDTO::getStelleOrt).setHeader("Stellen Ort");
        grid.addColumn(StelleDTO::getStelleBeschreibung).setHeader("Stellen Beschreibung");
        grid.addColumn(StelleDTO::getStelleWebsite).setHeader("Stellen Website");
        grid.addColumn(StelleDTO::getStelleUnternehmen).setHeader("Stellen Unternehmen");
        grid.addColumn(stelleDTO -> stelleDTO.getStelleUnternehmen().getName()).setHeader("Stellen Unternehmen");
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
