package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "EditFirmProfileDisplayView", layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("EditFirmProfileDisplayView")
public class EditFirmProfileDisplayView extends VerticalLayout {

}
