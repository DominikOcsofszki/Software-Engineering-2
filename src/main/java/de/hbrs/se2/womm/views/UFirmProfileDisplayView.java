package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.BothLayout;
import de.hbrs.se2.womm.views.newdom.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "FirmProfileDisplayView", layout = UnternehmenLayout.class)
@PageTitle("FirmProfileDisplayView")
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
public class UFirmProfileDisplayView extends VerticalLayout {

}
