package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "SApplicationView", layout = StudentLayout.class)
@PageTitle("ApplicationView")
@RolesAllowed({ "ADMIN", "STUDENT"})
public class SApplicationView extends VerticalLayout {

}
