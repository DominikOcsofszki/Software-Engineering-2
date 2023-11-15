package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "SChatView", layout = StudentLayout.class)
@PageTitle("ChatView")
@RolesAllowed({ "ADMIN", "STUDENT"})
public class SChatView extends VerticalLayout {
}
