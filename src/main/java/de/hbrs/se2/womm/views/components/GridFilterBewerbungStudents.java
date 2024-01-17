package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.views.extra.VaadinBuilderWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;

public class GridFilterBewerbungStudents extends AGridFilter<BewerbungDTO> {
    @Override
    protected void configureGrid() {
        String unternehmen = VaadinBuilderWomm.translateTextStatic("Firm");
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStelle().getUnternehmen().getName()).setHeader(unternehmen);
        String stelle = VaadinBuilderWomm.translateTextStatic("Advertisement");
        grid.addColumn(bewerbungDTO -> bewerbungDTO.getBewerbungStelle().getStelleTitel()).setHeader(stelle);
        String b = VaadinBuilderWomm.translateTextStatic("Ad description");
        grid.addColumn(BewerbungDTO::getBewerbungText).setHeader(b);
        setUpColorBewerbungen(grid);
        grid.addClassName("styling");
        String status = VaadinBuilderWomm.translateTextStatic("State");
//        grid.addColumn(BewerbungDTO::getBewerbungStatus).setHeader(status).setSortable(true);
        grid.addColumn(bewerbungDTO -> {
                    if (bewerbungDTO.getBewerbungStatus().equalsIgnoreCase("accepted"))
                        return VaadinBuilderWomm.translateTextStatic("Accepted");
                    if (bewerbungDTO.getBewerbungStatus().equalsIgnoreCase("declined"))
                        return VaadinBuilderWomm.translateTextStatic("Declined");
            return VaadinBuilderWomm.translateTextStatic("Pending");
        }).setHeader(status).setSortable(true);
//                bewerbungDTO.getBewerbungStudent()).setHeader(status).setSortable(true);
    }

    void setUpColorBewerbungen(Grid<BewerbungDTO> grid){
        grid.setPartNameGenerator(bewerbung -> {
            if (bewerbung.getBewerbungStatus().equalsIgnoreCase("accepted"))
                return "accepted";
            if (bewerbung.getBewerbungStatus().equalsIgnoreCase("declined"))
                return "declined";
            return null;
        });
    }
    @Override
    protected String[] getFilterByItemsFromDTO() {
        String unternehmen = VaadinBuilderWomm.translateTextStatic("Firm");
        String stelle = VaadinBuilderWomm.translateTextStatic("Advertisement");
        String status = VaadinBuilderWomm.translateTextStatic("State");
        return new String[]{
                unternehmen,
                stelle,
                status
        };
    }

    @Override
    protected String checkItem(BewerbungDTO dto, String searchBy) {
        return switch (searchBy) {
            case "Firm" -> dto.getBewerbungStelle().getUnternehmen().getName();
            case "Advertisement" -> dto.getBewerbungStelle().getStelleTitel();
            case "State" -> dto.getBewerbungStatus();
            case "Unternehmen" -> dto.getBewerbungStelle().getUnternehmen().getName();
            case "Stellenanzeige" -> dto.getBewerbungStelle().getStelleTitel();
            case "Status" -> dto.getBewerbungStatus();
            default -> null;
        };
    }

    public void setColumnClickListener() {
        this.grid.addItemClickListener(item -> UI.getCurrent()
                .navigate(ROUTING.STUDENT.SApplicationView + "/" + item.getItem().getBewerbungId()));
    }
}
