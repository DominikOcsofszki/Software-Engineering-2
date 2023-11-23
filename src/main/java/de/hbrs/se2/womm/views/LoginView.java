package de.hbrs.se2.womm.views;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
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
    private final TextField usernameField = new TextField("Username");
    private final PasswordField passwordField = new PasswordField("Password");

    LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        Button loginButton = new Button("Login");
        add(usernameField, passwordField, loginButton);

        loginButton.addClickListener(e -> {
            try {
                handleLogin();
            } catch (IOException | InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void handleLogin() throws IOException, InterruptedException {
        String username = usernameField.getValue();
        String password = passwordField.getValue();

        // Use HttpClient to create and send a POST request
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/api/auth/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}"))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body();

        if (statusCode == HttpStatus.OK.value()) {
            ObjectMapper objectMapper = new ObjectMapper();
            LoginResponse loginResponse = objectMapper.readValue(responseBody, LoginResponse.class);
            String role = loginResponse.getAuthorities().get(0).getAuthority();

            if (role.equals(Roles.STUDENT.toString())) UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
            if (role.equals(Roles.UNTERNEHMEN.toString())) UI.getCurrent().navigate(ROUTING.UNTERNEHMEN.UHomepageUnternehmenView);
        }

    }
}