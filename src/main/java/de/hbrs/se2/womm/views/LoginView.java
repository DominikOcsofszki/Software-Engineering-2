package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AuthenticationController;
import de.hbrs.se2.womm.dtos.LoginRequest;
import de.hbrs.se2.womm.exceptions.AuthenticationException;
import de.hbrs.se2.womm.views.layouts.AbstractViewWithoutController;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;


@Route(value = "login", layout = LoggedOutLayout.class)
@PermitAll
@PageTitle("LoginView")
public class LoginView extends AbstractViewWithoutController {

    SecurityService securityService;
    LoginForm login = new LoginForm();

    LoginView(@Autowired AuthenticationController authenticationController, SecurityService securityService) {
        this.securityService = securityService;
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setId("login-button");
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
                ResponseEntity<Authentication> response = authenticationController.loginUser(loginRequest);
                if (response.getStatusCode().is2xxSuccessful()) {
                    UI.getCurrent().getPage().setLocation("/");
                }
            } catch (AuthenticationException e) {
                Notification notification = new Notification();
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                Div text = new Div(new Text(e.getMessage()));

                Button closeButton = new Button(new Icon("lumo", "cross"));
                closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
                closeButton.setAriaLabel("Close");
                closeButton.addClickListener(event -> {
                    notification.close();
                    login.setEnabled(true);
                });

                HorizontalLayout layout = new HorizontalLayout(text, closeButton);
                layout.setAlignItems(Alignment.CENTER);

                notification.add(layout);
                notification.open();
            }
        });
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (securityService.getAuthenticatedUser() != null) {
            if (securityService.isUserStudent()) UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
            if (securityService.isUserUnternehmen())
                UI.getCurrent().navigate(ROUTING.UNTERNEHMEN.UHomepageUnternehmenView);
        }
    }
}