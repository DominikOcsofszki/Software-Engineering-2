package de.hbrs.se2.womm.views.components;

import de.hbrs.se2.womm.dtos.StelleDTO;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;

public class GridFilterStelle extends AGridFilter<StelleDTO>{
    public GridFilterStelle() {
        super();
    }

    @Override
    protected void configureGrid() {
        String header1 = VaadinBuilderWomm.translateTextStatic("Advertisement title");
        grid.addColumn(StelleDTO::getStelleTitel).setHeader(header1);
        String header2 = VaadinBuilderWomm.translateTextStatic("Firm name");
        grid.addColumn(stelleDTO -> stelleDTO.getUnternehmen().getName()).setHeader(header2);
    }

    @Override
    protected String[] getFilterByItemsFromDTO() {
        String str1 = VaadinBuilderWomm.translateTextStatic("Advertisement title");
        String str2 = VaadinBuilderWomm.translateTextStatic("Firm name");
        return new String[]{
                str1,
                str2
        };
    }

    @Override
    protected String checkItem(StelleDTO dto, String searchBy) {

        return switch (searchBy) {
            case "Name Stellenanzeige" -> dto.getStelleTitel();
            case "Name Unternehmen" -> dto.getUnternehmen().toString();
            case "Advertisement title" -> dto.getStelleTitel();
            case "Firm name" -> dto.getUnternehmen().toString();
            default -> null;
        };
    }
}
