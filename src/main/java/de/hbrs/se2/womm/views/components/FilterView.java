package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.controller.StudentController;
import de.hbrs.se2.womm.services.ImageService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@PageTitle("MainView")
@AnonymousAllowed
@Route(value = "filter", layout = LoggedOutLayout.class)
public class FilterView extends VerticalLayout {

//    public FilterView(StudentService studentService){
    public FilterView(StudentController studentController){
//        add(new ComponentMusterFilterGridControllerStudent(studentController));
    add(new ComponentMusterFilterGridController(studentController));

//        add(new ComponentMusterFilterGridController(studentController));
//        add(new ComponentMusterFilterGridControllerStudent(studentController));

//        add(new ComponentUnternehmenFilterGridAPI());

//        add(new ComponentStudentsFilterGrid(studentService));
        ImageService imageService = new ImageService();
        Image newImge = imageService.test();
        add(newImge);
    }
}
