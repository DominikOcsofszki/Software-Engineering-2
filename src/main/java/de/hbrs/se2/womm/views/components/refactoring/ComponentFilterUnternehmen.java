package de.hbrs.se2.womm.views.components.refactoring;

import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.generate.GenerateBenachrichtigungenDTOStillUnternehmen;

import java.util.List;

public class ComponentFilterUnternehmen extends AbstractComponentFilter<UnternehmenDTO>{
    public ComponentFilterUnternehmen(String[] filterByItemsFromDTO) {
        super(filterByItemsFromDTO);
    }

    @Override
    List<?> getItemsFromControllerOrGenerate() {
        return GenerateBenachrichtigungenDTOStillUnternehmen.generateUnternehmenDTO(gridNumberOfItems);
    }

    @Override
    void configureGrid() {

    }

    @Override
    boolean filterFunction(UnternehmenDTO dto, String inputSearchNameFilter, String searchBy) {
        return false;
    }
}
