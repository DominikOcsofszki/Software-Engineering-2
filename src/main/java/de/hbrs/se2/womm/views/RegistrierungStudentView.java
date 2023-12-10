package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.controller.AuthenticationController;
import de.hbrs.se2.womm.dtos.StudentRegistrationRequest;
import de.hbrs.se2.womm.views.layouts.AbstractViewWithoutController;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Route(value = ROUTING.ALL.RegistrierungStudentView, layout = LoggedOutLayout.class)
@AnonymousAllowed
@PageTitle("RegistrierungStudentView")
public class RegistrierungStudentView extends AbstractViewWithoutController {

    SecurityService securityService;
    AuthenticationController authenticationController;

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    TextField nameComponent;
    TextField surnameComponent;
    TextField usernameComponent;
    EmailField emailComponent;
    PasswordField passwordComponent;
    PasswordField passwordConfirmComponent;
    DatePicker dateOfBirthComponent;
    TextField locationComponent;
    Button registerComponent;

    public RegistrierungStudentView(AuthenticationController authenticationController, SecurityService securityService) {
        super();

        this.securityService = securityService;
        this.authenticationController = authenticationController;

        setSizeFull();

        setAlignItems(Alignment.CENTER);

        setJustifyContentMode(JustifyContentMode.CENTER);

//        add(new H4("Student/in Registration"));
        H4 h4 = getWommBuilder().H4.create("Student/in Registration");
        add(h4);

        nameComponent = new TextField("Name");
        nameComponent.setTooltipText("Your REAL Name");
        nameComponent.setRequired(true);
        nameComponent.setRequiredIndicatorVisible(true);
        nameComponent.setErrorMessage("Name is required");

        surnameComponent = new TextField("Surname");
        surnameComponent.setTooltipText("Your REAL surname");
        surnameComponent.setClearButtonVisible(true);
        surnameComponent.setRequired(true);
        surnameComponent.setRequiredIndicatorVisible(true);
        surnameComponent.setErrorMessage("Surname is required");

        usernameComponent = new TextField("Username");
        usernameComponent.setTooltipText("Your desired username");
        usernameComponent.setRequired(true);
        usernameComponent.setRequiredIndicatorVisible(true);
        usernameComponent.setErrorMessage("Username is required");

        emailComponent = new EmailField("Email \uD83D\uDE33");
        emailComponent.setTooltipText("Email connected to your future account");
        emailComponent.setRequired(true);
        emailComponent.setRequiredIndicatorVisible(true);
        emailComponent.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        emailComponent.setErrorMessage("Email is required");

        passwordComponent = new PasswordField("Password");
        passwordComponent.setTooltipText("The password used for login");
        passwordComponent.setRequired(true);
        passwordComponent.setRequiredIndicatorVisible(true);
        passwordComponent.setErrorMessage("Password is required");

        passwordConfirmComponent = new PasswordField("Confirm Password");
        passwordConfirmComponent.setTooltipText("Repeat your password");
        passwordConfirmComponent.setRequired(true);
        passwordConfirmComponent.setRequiredIndicatorVisible(true);
        passwordConfirmComponent.setErrorMessage("Password Confirmation is required");

        DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
        singleFormatI18n.setDateFormat("dd.MM.yyyy");
        dateOfBirthComponent = new DatePicker("Date of Birth");
        dateOfBirthComponent.setI18n(singleFormatI18n);
        dateOfBirthComponent.setTooltipText("Select your date of birth");
        dateOfBirthComponent.setRequired(true);
        dateOfBirthComponent.setRequiredIndicatorVisible(true);
        dateOfBirthComponent.setErrorMessage("Invalid date given. Dates must follow the 'DD.MM.YYYY' format.");

        LocalDate today = LocalDate.now();

        dateOfBirthComponent.setValue(today);

        locationComponent = new TextField("Location");
        locationComponent.setTooltipText("Your current living location");
        locationComponent.setRequired(true);
        locationComponent.setRequiredIndicatorVisible(true);
        locationComponent.setPrefixComponent(VaadinIcon.PIN.create());
        locationComponent.setErrorMessage("Location is required");


        registerComponent = new Button("Register", event -> {
            if (!nameComponent.isEmpty() && !surnameComponent.isEmpty() &&
            !usernameComponent.isEmpty() && !emailComponent.isEmpty() &&
            !passwordComponent.isEmpty() && !passwordConfirmComponent.isEmpty() &&
            !locationComponent.isEmpty()) {
                if (passwordComponent.getValue().equals(passwordConfirmComponent.getValue())) {
                    Pattern pattern = Pattern.compile(EMAIL_REGEX);
                    Matcher matcher = pattern.matcher(emailComponent.getValue());
                    if (matcher.matches()) {
                        register();
                    } else {
                        createErrorNotification("Bitte eine gültige Email eingeben!");
                    }
                }
                else {
                    createErrorNotification("Passwörter stimmen nicht überein!");
                }
            } else {
                createErrorNotification("Fülle alle Felder aus!");
            }
        });

        FormLayout formLayout = new FormLayout();

        formLayout.add(
                nameComponent,
                surnameComponent,
                usernameComponent,
                emailComponent,
                passwordComponent,
                passwordConfirmComponent,
                dateOfBirthComponent,
                locationComponent
        );

        add(
                formLayout,
                registerComponent
        );
    }

    private void register() {
        try {
            StudentRegistrationRequest request = getStudentRegistrationRequest();

            ResponseEntity<Void> response = authenticationController.registerStudent(request);

            if(response.getStatusCode().is2xxSuccessful()) {
                Notification notification = new Notification();
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

                Div text = new Div(new Text("Registrierung erfolgreich!"));

                Button closeButton = new Button(new Icon("lumo", "cross"));
                closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
                closeButton.setAriaLabel("Close");
                closeButton.addClickListener(e -> {
                    notification.close();
                    UI.getCurrent().navigate(ROUTING.ALL.LandingPageView);
                });

                HorizontalLayout layout = new HorizontalLayout(text, closeButton);
                layout.setAlignItems(Alignment.CENTER);

                notification.add(layout);
                notification.open();
            }
        } catch (Exception e) {
            createErrorNotification(e.getMessage());
        }
    }

    private StudentRegistrationRequest getStudentRegistrationRequest() {
        StudentRegistrationRequest request = new StudentRegistrationRequest();
        request.setFirstname(nameComponent.getValue());
        request.setLastname(surnameComponent.getValue());
        request.setEmail(emailComponent.getValue());
        request.setUsername(usernameComponent.getValue());
        request.setPassword(passwordComponent.getValue());

        //Outputs this date as a String, such as 2007-12-03.
        //The output will be in the ISO-8601 format yyyy-MM-dd.
        request.setDob(dateOfBirthComponent.getValue().toString());

        request.setLocation(locationComponent.getValue());
        return request;
    }

    private void createErrorNotification(String errorText) {
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        Div text = new Div(new Text(errorText));

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.setAriaLabel("Close");
        closeButton.addClickListener(e -> notification.close());

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);

        notification.add(layout);
        notification.open();
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
