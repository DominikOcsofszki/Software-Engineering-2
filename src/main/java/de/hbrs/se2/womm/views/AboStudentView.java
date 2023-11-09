package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.newdom.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "AboStudentView", layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("AboStudentView")
public class AboStudentView extends VerticalLayout {

    AboStudentView() {
//        TextField firstName = new TextField("First name");
//        TextField lastName = new TextField("Last name");
//        TextField username = new TextField("Username");
//        PasswordField password = new PasswordField("Password");
//        PasswordField confirmPassword = new PasswordField("Confirm password");
//
//        FormLayout formLayout = new FormLayout();
//        formLayout.add(firstName, lastName, username, password,
//                confirmPassword);
//        formLayout.setResponsiveSteps(
//                // Use one column by default
//                new FormLayout.ResponsiveStep("0", 1),
//                // Use two columns, if layout's width exceeds 500px
//                new FormLayout.ResponsiveStep("500px", 2));
//// Stretch the username field over 2 columns
//        formLayout.setColspan(username, 2);
//        add(formLayout);
    }
}
