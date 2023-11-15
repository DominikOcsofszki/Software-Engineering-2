package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@Route(value = "RegistrierungStudentView", layout = LoggedOutLayout.class)
@AnonymousAllowed
@PageTitle("RegistrierungStudentView")
public class RegistrierungStudentView extends VerticalLayout {

}
