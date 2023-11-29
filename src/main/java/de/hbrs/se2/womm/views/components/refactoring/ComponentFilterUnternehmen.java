package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.generate.GenerateBenachrichtigungenDTOStillUnternehmen;
import tools.generate.GenerateUnternehmen;

import java.util.List;

public class ComponentFilterUnternehmen extends AbstractComponentFilter<UnternehmenDTO>{

    public ComponentFilterUnternehmen(String[] filterByItemsFromDTO) {
        super(filterByItemsFromDTO);
    }

    @Override
    List<?> getItemsFromControllerOrGenerate() {
        return GenerateUnternehmen.generateUnternehmenDTO(10);
    }

    @Override
    void configureGrid() {
        grid.addColumn(UnternehmenDTO::getName).setHeader("").
                setSortable(true).setComparator(UnternehmenDTO::getName);
    }

    @Override
    String checkItem(UnternehmenDTO dto, String searchBy) {
                String checkItem = switch (searchBy) {
            case "Unternehmen" -> dto.getName().toString().toLowerCase();
            case "Nachricht" -> dto.getBeschreibung().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkItem;
    }
}
