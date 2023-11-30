package de.hbrs.se2.womm.views.components.done;

import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.generate.GENERATOR;

import java.util.List;

public class ComponentUnternehmenDTO extends AbstractComponentFilterWithController<UnternehmenDTO> {
    public ComponentUnternehmenDTO(AbstractControllerWomm controller) {
        super(controller);
    }

    @Override
    protected List<?> getItemsFromControllerOrGenerate() {
        List<?> ListOfDtos = getItemsFromController();
        if (ListOfDtos != null) return ListOfDtos;
        return GENERATOR.generateUnternehmenDTO(10);
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(UnternehmenDTO::getUnternehmenId).setHeader("Id");
        grid.addColumn(UnternehmenDTO::getBeschreibung).setHeader("Beschreibung");
        grid.addColumn(UnternehmenDTO::getName).setHeader("Name");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "Id",
                "Beschreibung",
                "Name"
        };
    }
    @Override
    protected String checkItem(UnternehmenDTO dto, String searchBy) {
        return switch (searchBy) {
            case "Id" -> String.valueOf(dto.getUnternehmenId());
            case "Beschreibung" -> dto.getBeschreibung();
            case "Name" -> dto.getName();
            default -> "";
        };
    }


}
