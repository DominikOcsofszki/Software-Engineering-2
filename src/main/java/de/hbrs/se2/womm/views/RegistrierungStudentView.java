package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.controller.AuthenticationController;
import de.hbrs.se2.womm.dtos.StudentRegistrationRequest;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.util.Locale;

@Route(value = ROUTING.ALL.RegistrierungStudentView, layout = LoggedOutLayout.class)
@AnonymousAllowed
@PageTitle("RegistrierungStudentView")
public class RegistrierungStudentView extends VerticalLayout {

    public RegistrierungStudentView() {
        super();
        setSizeFull();

        setAlignItems(Alignment.CENTER);

        setJustifyContentMode(JustifyContentMode.CENTER);

        add(new H4("Student/in Registration"));

        var nameComponent = new com.vaadin.flow.component.textfield.TextField("Name");
        nameComponent.setTooltipText("Your REAL Name");
        nameComponent.setRequired(true);
        nameComponent.setRequiredIndicatorVisible(true);
        nameComponent.setErrorMessage("Name is required");

        var surnameComponent = new com.vaadin.flow.component.textfield.TextField("Surname");
        surnameComponent.setTooltipText("Your REAL surname");
        surnameComponent.setClearButtonVisible(true);
        surnameComponent.setRequired(true);
        surnameComponent.setRequiredIndicatorVisible(true);
        surnameComponent.setErrorMessage("Surname is required");

        var usernameComponent = new com.vaadin.flow.component.textfield.TextField("Username");
        usernameComponent.setTooltipText("Your desired username");
        usernameComponent.setRequired(true);
        usernameComponent.setRequiredIndicatorVisible(true);
        usernameComponent.setErrorMessage("Username is required");

        EmailField emailComponent = new EmailField("Email \uD83D\uDE33");
        emailComponent.setTooltipText("Email connected to your future account");
        emailComponent.setRequired(true);
        emailComponent.setRequiredIndicatorVisible(true);
        emailComponent.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        emailComponent.setErrorMessage("Email is required");

        PasswordField passwordComponent = new PasswordField("Password");
        passwordComponent.setTooltipText("The password used for login");
        passwordComponent.setRequired(true);
        passwordComponent.setRequiredIndicatorVisible(true);
        passwordComponent.setErrorMessage("Password is required");

        PasswordField passwordConfirmComponent = new PasswordField("Confirm Password");
        passwordConfirmComponent.setTooltipText("Repeat your password");
        passwordConfirmComponent.setRequired(true);
        passwordConfirmComponent.setRequiredIndicatorVisible(true);
        passwordConfirmComponent.setErrorMessage("Password Confirmation is required");

        DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
        singleFormatI18n.setDateFormat("dd.MM.yyyy");
        DatePicker dateOfBirthComponent = new DatePicker("Date of Birth");
        dateOfBirthComponent.setI18n(singleFormatI18n);
        dateOfBirthComponent.setTooltipText("Select your date of birth");
        dateOfBirthComponent.setRequired(true);
        dateOfBirthComponent.setRequiredIndicatorVisible(true);
        dateOfBirthComponent.setErrorMessage("Invalid date given. Dates must follow the 'DD.MM.YYYY' format.");

        var locationComponent = new com.vaadin.flow.component.textfield.TextField("Location");
        locationComponent.setTooltipText("Your current living location");
        locationComponent.setRequired(true);
        locationComponent.setRequiredIndicatorVisible(true);
        locationComponent.setPrefixComponent(VaadinIcon.PIN.create());
        locationComponent.setErrorMessage("Location is required");


        Button registerComponent = new Button("Register", event -> {
            /*
            TODO
            try {
                StudentRegistrationRequest request = new StudentRegistrationRequest();
                request.setFirstname(nameComponent.getValue());
                request.setLastname(surnameComponent.getValue());
                request.setEmail(emailComponent.getValue());
                request.setUsername(usernameComponent.getValue());
                request.setPassword(passwordComponent.getValue());

                //Outputs this date as a String, such as 2007-12-03.
                //The output will be in the ISO-8601 format yyyy-MM-dd.
                request.setDob(dateOfBirthComponent.getValue().toString());

                //es gibt kein setLocation????
                request.setLocation(locationComponent.getValue());

                HttpStatusCode answer = (new AuthenticationController()).registerUser(request).getStatusCode();

                if(answer.is2xxSuccessful()){
                    UI.getCurrent().navigate(ROUTING.STUDENT.SHomepageStudentView);
                    add(new H2("Registrirung Erfolgreich"));
                } else {

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            */
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
}
