package de.hbrs.se2.womm.views.student;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.STUDENT.SChatView, layout = StudentLayout.class)
@RolesAllowed({ "ADMIN", "STUDENT"})
@PageTitle("ChatView")
public class SChatView extends AViewWomm {
}
