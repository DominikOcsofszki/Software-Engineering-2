package de.hbrs.se2.womm.views.components.done;

import de.hbrs.se2.womm.controller.AbstractControllerWomm;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import tools.generate.GENERATOR;

import java.util.List;

public class ComponentDemoDto extends AbstractComponentFilterWithController<UnternehmenDTO>{
    public ComponentDemoDto(AbstractControllerWomm controller) {
        super(controller);
    }

    @Override
    protected List<?> getItemsFromControllerOrGenerate() {
        List<UnternehmenDTO> list = (List<UnternehmenDTO>) getItemsFromController();
        if (list != null) return list;
        return GENERATOR.generateUnternehmenDTO(100);
    }

    @Override
    protected void configureGrid() {
        grid.addColumn(UnternehmenDTO::getBeschreibung).setHeader("getBeschreibung");
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        return new String[]{
                "getBeschreibung"
        };
    }

    @Override
    protected String checkItem(UnternehmenDTO dto, String searchBy) {
        return switch (searchBy) {
            case "getBeschreibung" -> dto.getBeschreibung();
            default -> "";
        };
    }
}
