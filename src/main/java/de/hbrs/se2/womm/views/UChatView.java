package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.BothLayout;
import de.hbrs.se2.womm.views.newdom.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "ChatView", layout = UnternehmenLayout.class)
@PageTitle("ChatView")
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
public class UChatView extends VerticalLayout {
}
