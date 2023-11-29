package de.hbrs.se2.womm.views.components.refactoring;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.controller.BewerbungController;
import de.hbrs.se2.womm.views.components.done.ComponentFilterStudent;
import de.hbrs.se2.womm.views.components.refactoring.ComponentFilterExtends;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@PageTitle("MainView")
@AnonymousAllowed
@Route(value = "filter", layout = LoggedOutLayout.class)
public class FilterView extends VerticalLayout {

//    public FilterView(StelleController controller){
//        add(new ComponentFilterGridControllerStellen(controller));
//    }
    public FilterView(BewerbungController controller){
        add(new ComponentFilterStudent());



//        add(new ComponentFilterGridControllerAbo());
//        add(new ComponentFilterGridControllerBewerbung(controller));
    }

//    public FilterView(StudentController studentController){
////        add(new ComponentMusterFilterGridControllerStudent(studentController));
//    add(new ComponentMusterFilterGridController(studentController));
//
////        add(new ComponentMusterFilterGridController(studentController));
////        add(new ComponentMusterFilterGridControllerStudent(studentController));
//
////        add(new ComponentUnternehmenFilterGridAPI());
//
////        add(new ComponentStudentsFilterGrid(studentService));
//        ImageService imageService = new ImageService();
//        Image newImge = imageService.test();
//        add(newImge);
//    }
}
