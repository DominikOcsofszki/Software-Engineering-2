package de.hbrs.se2.womm.views.doing_HomepageStudentView;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "HomepageStudentView")
@PageTitle("HomepageStudentView")
public class HomepageStudentView extends VerticalLayout {
    public HomepageStudentView() {
        H1 h1 = new H1("XXX");
        add(new H1("XXX"));
        add(h1);
    }
}
