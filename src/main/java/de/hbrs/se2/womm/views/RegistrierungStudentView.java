package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;

@Route(value = ROUTING.ALL.RegistrierungStudentView, layout = LoggedOutLayout.class)
@AnonymousAllowed
@PageTitle("RegistrierungStudentView")
public class RegistrierungStudentView extends VerticalLayout {

    public RegistrierungStudentView() {
        super();

        add(new HorizontalLayout());

        setSizeFull();

        setAlignItems(Alignment.CENTER);

        setJustifyContentMode(JustifyContentMode.CENTER);

        H4 title = new H4("Student Registration");


        var name = new com.vaadin.flow.component.textfield.TextField("Name");
        name.setTooltipText("Your REAL Name");
        name.setRequired(true);
        name.setRequiredIndicatorVisible(true);
        name.setErrorMessage("Name is required");

        var surname = new com.vaadin.flow.component.textfield.TextField("Surname");
        surname.setTooltipText("Your REAL surname");
        surname.setClearButtonVisible(true);
        surname.setRequired(true);
        surname.setRequiredIndicatorVisible(true);
        surname.setErrorMessage("Surname is required");

        PasswordField password = new PasswordField("Password");
        password.setTooltipText("The password used for login");
        password.setRequired(true);
        password.setRequiredIndicatorVisible(true);
        password.setErrorMessage("Password is required");

        PasswordField passwordConfirm = new PasswordField("Confirm Password");
        passwordConfirm.setTooltipText("Repeat your password");
        passwordConfirm.setRequired(true);
        passwordConfirm.setRequiredIndicatorVisible(true);
        passwordConfirm.setErrorMessage("Password Confirmation is required");

        EmailField email = new EmailField("Email \uD83D\uDE33");
        email.setTooltipText("Email connected to your future account");
        email.setRequired(true);
        email.setRequiredIndicatorVisible(true);
        email.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        email.setErrorMessage("Email is required");

        Button reg = new Button("Register", event -> {
            UI.getCurrent().getPage().reload();
        });

        add(title, name, surname, password, passwordConfirm, email, reg);
    }
}
