package de.hbrs.se2.womm.views;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.dtos.LoginResponse;
import de.hbrs.se2.womm.model.Roles;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Route(value = "login", layout = LoggedOutLayout.class)
@PermitAll
@PageTitle("LoginView")
public class LoginView extends VerticalLayout {
    LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        LoginForm login = new LoginForm();
        add(
                new H1("w.o.o.m."),
                login
        );

        login.addLoginListener(loginEvent -> {
            // Use HttpClient to create and send a POST request
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/auth/login"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"username\":\"" + loginEvent.getUsername() + "\", \"password\":\"" + loginEvent.getPassword() + "\"}"))
                    .build();

            HttpResponse<String> response = null;
            try {
                response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            int statusCode = response.statusCode();
            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();

            if (statusCode == HttpStatus.OK.value()) {
                LoginResponse loginResponse = null;
                try {
                    loginResponse = objectMapper.readValue(responseBody, LoginResponse.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                String role = loginResponse.getAuthorities().get(0).getAuthority();

                if (role.equals(Roles.ROLE_STUDENT.toString())) UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
                if (role.equals(Roles.ROLE_UNTERNEHMEN  .toString())) UI.getCurrent().navigate(ROUTING.UNTERNEHMEN.UHomepageUnternehmenView);
            }
        });
    }
}