package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import de.hbrs.se2.womm.model.Roles;
import de.hbrs.se2.womm.views.layouts.ROUTING;

@Route(value = ROUTING.ALL.AccessDeniedView)
public class AccessDeniedView extends VerticalLayout implements BeforeEnterObserver {

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // You can add logic to handle permissions or conditions here
        // For example, check if the user has access rights to the view
        // If not, redirect or display an access denied message

        // Here's a simple example showing an access denied message
        Text accessDeniedText = new Text("Access Denied!");
        add(accessDeniedText);
        Roles currentRole = Roles.STUDENT; //ToDo from SecurityService
        if(currentRole != null) {
            getPossibleLinks(currentRole);
        } else {
            add(new RouterLink("Log in ", LoginView.class));
        }
    }
    private void getPossibleLinks(Roles role) {
        if (role == Roles.STUDENT) {
            add(new VerticalLayout(
                    new RouterLink("SAboStudentView ", SAboStudentView.class),
                    new RouterLink("SApplicationView ", SApplicationView.class),
                    new RouterLink("SChatView ", SChatView.class),
                    new RouterLink("SCreateChangeStudentProfileView ", SCreateChangeStudentProfileView.class),
                    new RouterLink("SFirmProfileDisplayView ", SFirmProfileDisplayView.class),
                    new RouterLink("SHomepageStudentView ", SHomepageStudentView.class),
                    new RouterLink("SJobProjectWorkshopDisplayView ", SJobProjectWorkshopDisplayView.class),
                    new RouterLink("SNotificationView ", SNotificationView.class),
                    new RouterLink("SStudentProfileDisplayView ", SStudentProfileDisplayView.class)
            ));
        } else {
            add(new VerticalLayout(

                    new RouterLink("UApplicationView ", UApplicationView.class),
                    new RouterLink("UApplicationsView ", UApplicationsView.class),
                    new RouterLink("UChatView ", UChatView.class),
                    new RouterLink("UEditFirmProfileDisplayView ", UEditFirmProfileDisplayView.class),
                    new RouterLink("UFirmProfileDisplayView ", UFirmProfileDisplayView.class),
                    new RouterLink("UHomepageUnternehmenView ", UHomepageUnternehmenView.class),
                    new RouterLink("UStelleAnzeigeErstellenView ", UStelleAnzeigeErstellenView.class),
                    new RouterLink("UNotificationView", UNotificationView.class)

            ));

        }

    }
}
