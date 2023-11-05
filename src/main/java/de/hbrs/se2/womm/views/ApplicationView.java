package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.BothLayout;

@Route(value = "ApplicationView", layout = BothLayout.class)
@PageTitle("ApplicationView")
public class ApplicationView extends VerticalLayout {

}
