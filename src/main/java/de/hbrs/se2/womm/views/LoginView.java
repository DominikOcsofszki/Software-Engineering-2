package de.hbrs.se2.womm.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.security.AuthenticationContext;
import de.hbrs.se2.womm.dtos.LoginRequest;
import de.hbrs.se2.womm.dtos.LoginResponse;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.exceptions.AuthenticationException;
import de.hbrs.se2.womm.model.Roles;
import de.hbrs.se2.womm.services.AuthenticationService;
import de.hbrs.se2.womm.services.SecurityService;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Route(value = "login", layout = LoggedOutLayout.class)
@PermitAll
@PageTitle("LoginView")
public class LoginView extends VerticalLayout {
    private AuthenticationService authenticationService;
    private AuthenticationContext authenticationContext;
    LoginView(AuthenticationService authenticationService, AuthenticationContext authenticationContext) {
        this.authenticationService = authenticationService;
        this.authenticationContext = authenticationContext;
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        LoginForm login = new LoginForm();
        login.setForgotPasswordButtonVisible(false);
        add(
                new H1("w.o.o.m."),
                login
        );

        login.addLoginListener(loginEvent -> {
            LoginRequest loginRequest = LoginRequest.builder()
                    .username(loginEvent.getUsername())
                    .password(loginEvent.getPassword()).build();
            try {
                Authentication authentication = authenticationService.loginUser(loginRequest);
                Nutzer principal = (Nutzer) authentication.getPrincipal();
                String role = principal.getRolle();
                System.out.println(role);
                System.out.println(authenticationContext.isAuthenticated());
                if (authenticationContext.isAuthenticated()) {
                    if (role.equals(Roles.STUDENT.name())) UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
                }
            } catch (AuthenticationException e) {
                throw new RuntimeException(e);
            }
        });
    }
}