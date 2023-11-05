package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;

@Route(value = "login", layout = LoggedOutLayout.class)
@AnonymousAllowed
public class LoginViewDo extends VerticalLayout {
    LoginViewDo() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        var login = new LoginForm();
        login.setAction("login");

        add(new H1("w.o.o.m."),
                login
        );

    }
}