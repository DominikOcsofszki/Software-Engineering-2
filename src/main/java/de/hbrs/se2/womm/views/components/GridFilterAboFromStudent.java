package de.hbrs.se2.womm.views.components;

import de.hbrs.se2.womm.dtos.AboStudentUnternehmenDTO;

public class GridFilterAboFromStudent extends AGridFilter<AboStudentUnternehmenDTO>{

    @Override
    protected void configureGrid() {
        grid.addColumn(aboStudentUnternehmenDTO -> aboStudentUnternehmenDTO.getUnternehmen().getName()).setHeader("Name Unternehmen");
        grid.addColumn(aboStudentUnternehmenDTO -> aboStudentUnternehmenDTO.getUnternehmen().getBeschreibung()).setHeader("Beschreibung Unternehmen");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
            "Name Unternehmen",
            "Beschreibung Unternehmen"
        };
    }

    @Override
    protected String checkItem(AboStudentUnternehmenDTO dto, String searchBy) {
        return switch (searchBy) {
            case "Name Unternehmen" -> dto.getUnternehmen().getName();
            case "Beschreibung Unternehmen" -> dto.getUnternehmen().getBeschreibung();
            default -> null;
        };
    }
}
