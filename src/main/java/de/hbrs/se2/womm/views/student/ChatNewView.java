package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.ChatNewDTO;
import de.hbrs.se2.womm.services.ChatNewService;
import de.hbrs.se2.womm.views.components.GridFilterAboFromStudent;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.util.List;

@Route(value = "ChatNew", layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("AboStudentView")
public class ChatNewView extends  AViewWomm{

    List<ChatNewDTO> chatNewDTOS;
    long nutzerID;
    GridFilterAboFromStudent gridFilterAboFromStudent = new GridFilterAboFromStudent();
    public ChatNewView(ChatNewService chatNewService, SecurityService securityService) {
        nutzerID = securityService.getLoggedInNutzerID();
        long otherNutzerID = 2;
        chatNewDTOS = chatNewService.getByNutzerId(nutzerID,otherNutzerID);
        chatNewDTOS.forEach(AboDTO -> {
            System.out.println(AboDTO.getMsg());
            add(AboDTO.getMsg());
        });
        H1 top = getWommBuilder().H1.create("New chat");
        add(top);

//        gridFilterAboFromStudent.setUpFromOutside(chatNewDTOS);
//        add(gridFilterAboFromStudent);
    }

}
