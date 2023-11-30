package de.hbrs.se2.womm.views.components.done;

import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.dtos.StelleDTO;
import tools.generate.GENERATOR;

import java.util.List;

public class ComponentFilterStelle extends AbstractComponentFilter<StelleDTO>{
    @Override
    protected List<?> getItemsFromControllerOrGenerate() {
        return GENERATOR.generateStelleDTO(10);
    }

    @Override
    protected void configureGrid() {

    }

    @Override
    protected String checkItem(StelleDTO dto, String searchBy) {
        return null;
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[0];
    }
}
