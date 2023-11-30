package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.views.components.refactoring.ComponentFilter;

public class ComponentFilterExtends extends ComponentFilter<UnternehmenDTO> {
    public ComponentFilterExtends() {
        super();
    }

    private boolean filterFunction(UnternehmenDTO dto, String inputSearchNameFilter, String searchBy) {
        inputSearchNameFilter = inputSearchNameFilter.toLowerCase();
        String checkUnternehmen = switch (searchBy) {
            case "Unternehmen" -> dto.getName().toString().toLowerCase();
            case "Nachricht" -> dto.getBeschreibung().toString().toLowerCase();
            default -> throw new IllegalStateException("Unexpected value: " + searchBy);
        };
        return checkUnternehmen.contains(inputSearchNameFilter);
    }
}
