package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.views.components.done.AbstractComponentFilter;
import tools.generate.GenerateUnternehmenDTO;

import java.util.List;

public class ComponentFilterUnternehmen extends AbstractComponentFilter<UnternehmenDTO> {

    public ComponentFilterUnternehmen() {
        super();
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "Unternehmen",
                "Nachricht"
        };
    }

    @Override
    protected List<?> getItemsFromControllerOrGenerate() {
        return GenerateUnternehmenDTO.generateUnternehmenDTO(10);
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(UnternehmenDTO::getName).setHeader("").
                setSortable(true).setComparator(UnternehmenDTO::getName);
    }

    @Override
    protected String checkItem(UnternehmenDTO dto, String searchBy) {
                String checkItem = switch (searchBy) {
            case "Unternehmen" -> dto.getName().toString().toLowerCase();
            case "Nachricht" -> dto.getBeschreibung().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkItem;
    }
}
