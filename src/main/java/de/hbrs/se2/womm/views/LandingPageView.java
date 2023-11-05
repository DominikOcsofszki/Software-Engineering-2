package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.newdom.layouts.LoggedOutLayout;

@Route(value = "LandingPageView", layout = LoggedOutLayout.class)
@AnonymousAllowed
@PageTitle("LandingPageView")
public class LandingPageView extends VerticalLayout {

}
