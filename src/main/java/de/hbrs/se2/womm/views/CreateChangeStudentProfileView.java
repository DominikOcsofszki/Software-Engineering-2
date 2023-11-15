package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "CreateChangeStudentProfileView", layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("CreateChangeStudentProfileView")
public class CreateChangeStudentProfileView extends VerticalLayout {

}
