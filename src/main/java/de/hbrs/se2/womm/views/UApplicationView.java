package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "UApplicationView", layout = UnternehmenLayout.class)
@PageTitle("ApplicationView")
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
public class UApplicationView extends VerticalLayout {

}
