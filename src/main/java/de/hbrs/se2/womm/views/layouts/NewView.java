package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
@Route(value = "blabla", layout = StudentLayout.class)
public class NewView extends AViewbyNutzerId {
    StudentDTO studentDTO;
    StudentService studentService;
    protected NewView(SecurityService securityService,  StudentService studentService) {
        super(securityService);
        this.studentService = studentService;
        this.studentDTO = getDTOFromServiceByNutzerId();
        add(studentDTO.toString());
    }
    @Override
    protected StudentDTO getDTOFromServiceByNutzerId() {
        return studentService.getStudentByNutzerId(nutzerIDfromLoggedInForDB);
    }
}
