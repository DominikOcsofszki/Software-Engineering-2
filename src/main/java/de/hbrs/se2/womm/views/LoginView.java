package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import jakarta.annotation.security.PermitAll;

@Route(value = "login", layout = LoggedOutLayout.class)
@PermitAll
public class LoginView extends VerticalLayout {
    LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        var login = new LoginForm();
        login.setAction("login");
        login.setForgotPasswordButtonVisible(false);
        add(
                new H1("w.o.o.m."),
                login
        );

    }


}