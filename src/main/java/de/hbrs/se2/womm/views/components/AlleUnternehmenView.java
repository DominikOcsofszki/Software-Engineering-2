package de.hbrs.se2.womm.views.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@PageTitle("MainView")
@AnonymousAllowed
@Route(value = "filter", layout = LoggedOutLayout.class)
public class AlleUnternehmenView extends VerticalLayout {

    public AlleUnternehmenView(UnternehmenService unternehmenService){
        de.hbrs.se2.womm.views.extra.FilterGridComponentUnternehmen filterGridComponent = new de.hbrs.se2.womm.views.extra.FilterGridComponentUnternehmen(unternehmenService);
        add(filterGridComponent);
    }
}
