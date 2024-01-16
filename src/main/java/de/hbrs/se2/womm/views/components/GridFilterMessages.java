package de.hbrs.se2.womm.views.components;

import de.hbrs.se2.womm.dtos.BenachrichtigungDTO;

public class GridFilterMessages extends AGridFilter<BenachrichtigungDTO> {
    @Override
    protected void configureGrid() {
        grid.addColumn(BenachrichtigungDTO::getNachricht).setHeader("Nachricht");
        grid.addColumn(BenachrichtigungDTO::isGelesen).setHeader("Gelesen");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{"nachricht", "gelesen"};
    }

    @Override
    protected String checkItem(BenachrichtigungDTO dto, String searchBy) {
        return switch (searchBy) {
            case "nachricht" -> dto.getNachricht();
            case "gelesen" -> String.valueOf(dto.isGelesen());
            default -> "";
        };
    }
}
