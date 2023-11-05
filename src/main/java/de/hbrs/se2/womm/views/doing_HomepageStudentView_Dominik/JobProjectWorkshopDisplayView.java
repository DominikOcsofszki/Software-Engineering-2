package de.hbrs.se2.womm.views.doing_HomepageStudentView_Dominik;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "JobProjectWorkshopDisplayView", layout = MainLayout.class)
@PageTitle("JobProjectWorkshopDisplayView")
public class JobProjectWorkshopDisplayView extends VerticalLayout {
    public JobProjectWorkshopDisplayView() {
        H1 h1 = new H1("JobProjectWorkshopDisplayView");
        add(h1);
    }
}
