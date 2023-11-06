package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "NotificationView", layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("NotificationView")
public class NotificationView extends VerticalLayout {

}
