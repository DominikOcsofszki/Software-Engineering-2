package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.UI;
import de.hbrs.se2.womm.dtos.AboDTO;
import de.hbrs.se2.womm.views.layouts.ROUTING;

public class GridFilterAboFromStudent extends AGridFilter<AboDTO>{

    @Override
    protected void configureGrid() {
        grid.addColumn(AboDTO -> AboDTO.getUnternehmen().getName()).setHeader("Name Unternehmen");
        grid.addColumn(AboDTO -> AboDTO.getUnternehmen().getBeschreibung()).setHeader("Beschreibung Unternehmen");
        setColumnClickListener();
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
            "Name Unternehmen",
            "Beschreibung Unternehmen"
        };
    }

    @Override
    protected String checkItem(AboDTO dto, String searchBy) {
        return switch (searchBy) {
            case "Name Unternehmen" -> dto.getUnternehmen().getName();
            case "Beschreibung Unternehmen" -> dto.getUnternehmen().getBeschreibung();
            default -> null;
        };
    }
    public void setColumnClickListener() {
        this.grid.addItemClickListener(item -> UI.getCurrent()
                .navigate(ROUTING.STUDENT.SFirmProfileDisplayView + "/" + item.getItem().getUnternehmen().getUnternehmenId()));
    }
}
