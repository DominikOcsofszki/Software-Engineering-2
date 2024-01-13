package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.AboStudentUnternehmenDTO;
import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
import de.hbrs.se2.womm.views.components.GridFilterAboFromStudent;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Route(value = "SAboStudentView", layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("AboStudentView")
public class SAboStudentView extends  AViewWomm{

    List<AboStudentUnternehmenDTO> aboStudentUnternehmenDTOList;
    long nutzerID;
    GridFilterAboFromStudent gridFilterAboFromStudent = new GridFilterAboFromStudent();
    public SAboStudentView(AboStudentUnternehmenService aboStudentUnternehmenService, SecurityService securityService) {
        nutzerID = securityService.getLoggedInNutzerID();
        aboStudentUnternehmenDTOList = aboStudentUnternehmenService.getByNutzerId(nutzerID);
        System.out.println("-------------------");
        aboStudentUnternehmenDTOList.forEach(aboStudentUnternehmenDTO -> {
            System.out.println(aboStudentUnternehmenDTO.getUnternehmen().getName());
            System.out.println(aboStudentUnternehmenDTO.getUnternehmen().getBeschreibung());
        });
        System.out.println("-------------------");
        H1 abonnements = getWommBuilder().H1.create("Subscriptions");
        add(abonnements);
        gridFilterAboFromStudent.setUpFromOutside(aboStudentUnternehmenDTOList);
        add(gridFilterAboFromStudent);
//        System.out.println(aboStudentUnternehmenDTOList);
    }

}