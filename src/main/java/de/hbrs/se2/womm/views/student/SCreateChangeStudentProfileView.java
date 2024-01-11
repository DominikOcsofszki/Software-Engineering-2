package de.hbrs.se2.womm.views.student;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.LandingPageView;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.time.LocalDate;


@Route(value = ROUTING.STUDENT.SCreateChangeStudentProfileView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("CreateChangeStudentProfileView")
public class SCreateChangeStudentProfileView extends AViewWomm {
    StudentService studentService;
    StudentDTO studentDTO;

    public SCreateChangeStudentProfileView(StudentService studentService, SecurityService securityService) {
        this.studentService = studentService;
        this.studentDTO = studentService.getByNutzerId(securityService.getLoggedInNutzerID());
        add(
                getHeader(),
                getProfil()
        );

    }

    private void saveChanges(
            DatePicker geburtstag,
            Checkbox benachrichtigungen,
            EmailField email,
            EmailField confirmEmail,
            PasswordField oldPassword,
            PasswordField newPassword,
            PasswordField newPasswordConfirm,
            TextField ort,
            TextArea biographie,
            TextArea spezialisierungen,
            NumberField semester
    ) {
        if (validateDatepicker(geburtstag)) {
            studentDTO.setStudentGeburtstag(geburtstag.getValue().toString());
        }

        studentDTO.setStudentBenachrichtigung(benachrichtigungen.getValue());

        if (validateEmail(email, confirmEmail)) {
            studentDTO.getNutzer().setNutzerMail(email.getValue());
        }

        if (validatePassword(oldPassword, newPassword, newPasswordConfirm)) {
            System.out.println("TODO: Password validation"); // ToDo!
        }

        if (!ort.getValue().isBlank()) {
            studentDTO.getNutzer().setNutzerOrt(ort.getValue());
        }

        studentDTO.setStudentBio(biographie.getValue());

        studentDTO.setStudentSpezialisierung(spezialisierungen.getValue());

        studentDTO.setStudentSemester(semester.getValue().intValue());

        studentService.saveStudent(studentDTO);
    }

    private Component getHeader() {
        HorizontalLayout header = new HorizontalLayout();
        Button home = getWommBuilder().Button.create("Home");

        home.getElement().getStyle().set("margin-right", "0");
        home.addClickListener(e -> UI.getCurrent().navigate(LandingPageView.class));

        header.setWidth("100%");
        header.add(home);

        return header;
    }

    private Component getProfil() {
        HorizontalLayout layoutProfile = new HorizontalLayout();
        VerticalLayout layoutPicture = new VerticalLayout();
        VerticalLayout layoutDetails = new VerticalLayout();

        Image imageProfilePicture = studentDTO.PlaceholderOrImage();
        imageProfilePicture.getStyle()
                .set("width", "250px")
                .set("height", "250px")
                .set("margin-left", "auto"); // Sodass das Bild rechtsbündig ist

        layoutPicture.add(
                imageProfilePicture
        );

        // ----------------- Header (Name) -----------------

        VerticalLayout layoutName = new VerticalLayout();
        Span spanName = getWommBuilder().Span.create("Name");
        Span spanNameValue = new Span(studentDTO.getStudentVorname() + " " + studentDTO.getStudentName());
        Span spanNameInformation = getWommBuilder().Span.create("The name can only be changed with the agreement of an admin");

        spanNameValue.getElement().getStyle()
                .set("font-size", "35px");
        spanNameInformation.getElement().getStyle()
                .set("color", "#5e5e5e");

        layoutName.add(
                spanName,
                spanNameValue,
                spanNameInformation
        );

        // ----------------- Date of Birth -----------------

        VerticalLayout layoutDob = new VerticalLayout(); // Dob = Date of Birth
        Span spanDob = getWommBuilder().Span.create("Date of Birth");
        DatePicker datePickerDob = new DatePicker();
        DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
        singleFormatI18n.setDateFormat("dd.MM.yyyy");
        datePickerDob.setI18n(singleFormatI18n);
        datePickerDob.setTooltipText(getWommBuilder().translateText("Select your date of birth"));
        datePickerDob.setErrorMessage(getWommBuilder().translateText("Invalid date given. Dates must follow the 'DD.MM.YYYY' format."));
        try {
            datePickerDob.setValue(LocalDate.parse(studentDTO.getStudentGeburtstag()));
        } catch (Exception e) {
            e.printStackTrace();
            datePickerDob.setValue(LocalDate.now());
        }
        datePickerDob.setWidth("100%");

        layoutDob.add(
                spanDob,
                datePickerDob
        );

        // ----------------- E-Mail Checkbox -----------------

        Checkbox checkEmailNotifs = new Checkbox();

        Span spanEmailNotifsDescription = getWommBuilder().Span.create("I would like to receive notifications");
        spanEmailNotifsDescription.getElement().getStyle().set("font-size", "20px");

        checkEmailNotifs.setLabelComponent(spanEmailNotifsDescription);
        checkEmailNotifs.setValue(studentDTO.isStudentBenachrichtigung());

        // ----------------- E-Mail -----------------

        VerticalLayout layoutEmail = new VerticalLayout();
        Span emailFieldHeader = getWommBuilder().Span.create("e-mail");
        EmailField emailField = new EmailField();
        Span emailFieldConfirmHeader = getWommBuilder().Span.create("Confirm e-mail");
        EmailField emailFieldConfirm = new EmailField();

        emailFieldHeader.getElement().getStyle()
                .set("font-size", "20px");

        emailField.getStyle()
                .set("flex-grow", "1")
                .set("width", "100%");

        emailFieldConfirm.getStyle()
                .set("flex-grow", "1")
                .set("width", "100%");

        emailField.setValue(studentDTO.getNutzer().getNutzerMail() == null ? "" : studentDTO.getNutzer().getNutzerMail());
        emailField.setClearButtonVisible(true);
        emailField.setErrorMessage(getWommBuilder().translateText("Please enter a valid e-mail address"));
        emailField.setTooltipText(getWommBuilder().translateText("Please enter a valid e-mail address"));
        emailFieldConfirm.setValue("");
        emailFieldConfirm.setClearButtonVisible(true);
        emailFieldConfirm.setTooltipText(getWommBuilder().translateText("Please re-enter your valid e-mail address"));

        layoutEmail.add(
                emailFieldHeader,
                emailField,
                emailFieldConfirmHeader,
                emailFieldConfirm
        );

        // ----------------- Password -----------------

        VerticalLayout layoutPassword = new VerticalLayout();
        Span spanPasswordFieldHeader = getWommBuilder().Span.create("Password");
        Span spanOldPassword = getWommBuilder().Span.create("Enter your old password");
        Span spanPasswordTooltip = getWommBuilder().Span.create("Your password must have 6 to 12 characters. Only letters A-Z and numbers supported.");
        PasswordField passwordOld = new PasswordField();
        Span spanNewPassword = getWommBuilder().Span.create("Enter your new password");
        PasswordField passwordNew = new PasswordField();
        Span spanNewPasswordConfirm = getWommBuilder().Span.create("Repeat your new password");
        PasswordField passwordNewConfirm = new PasswordField();

        spanPasswordFieldHeader.getElement().getStyle().set("font-size", "20px");
        spanOldPassword.getElement().getStyle().set("font-size", "15px");
        spanNewPassword.getElement().getStyle().set("font-size", "15px");
        spanNewPasswordConfirm.getElement().getStyle().set("font-size", "15px");

        passwordOld.setHelperComponent(spanPasswordTooltip);
        passwordOld.setClearButtonVisible(true);
        passwordOld.setTooltipText(getWommBuilder().translateText("Please enter your current valid Password"));
        passwordNew.setRequiredIndicatorVisible(true);
        passwordNew.setAllowedCharPattern("[A-Za-z0-9]");
        passwordNew.setMinLength(6);
        passwordNew.setMaxLength(12);
        passwordNew.setClearButtonVisible(true);
        passwordNew.setTooltipText(getWommBuilder().translateText("Please enter your new valid Password"));
        passwordNewConfirm.setRequiredIndicatorVisible(true);
        passwordNewConfirm.setAllowedCharPattern("[A-Za-z0-9]");
        passwordNewConfirm.setMinLength(6);
        passwordNewConfirm.setMaxLength(12);
        passwordNewConfirm.setClearButtonVisible(true);
        passwordNewConfirm.setTooltipText(getWommBuilder().translateText("Please re-enter your new valid Password"));

        passwordOld
                .getStyle()
                .set("flex-grow", "1")
                .set("width", "100%");
        passwordNew
                .getStyle()
                .set("flex-grow", "1")
                .set("width", "100%");
        passwordNewConfirm
                .getStyle()
                .set("flex-grow", "1")
                .set("width", "100%");

        layoutPassword.add(
                spanPasswordFieldHeader,
                spanOldPassword,
                passwordOld,
                spanNewPassword,
                passwordNew,
                spanNewPasswordConfirm,
                passwordNewConfirm
        );

        // ----------------- Location -----------------

        TextField fieldLocation = new TextField();
        fieldLocation.setValue(studentDTO.getNutzer().getNutzerOrt() == null ? "" : studentDTO.getNutzer().getNutzerOrt());
        VerticalLayout layoutLocation = generateSinglePropertyField("Location", fieldLocation);

        // ----------------- Bio -----------------

        TextArea textAreaBio = new TextArea();
        textAreaBio.setValue(studentDTO.getStudentBio() == null ? "" : studentDTO.getStudentBio());
        VerticalLayout layoutBio = generateSinglePropertyField("Biography", textAreaBio);

        // ----------------- Specializations -----------------

        TextArea textAreaSpecializations = new TextArea();
        textAreaSpecializations.setValue(studentDTO.getStudentSpezialisierung() == null ? "" : studentDTO.getStudentSpezialisierung());
        VerticalLayout layoutSpec = generateSinglePropertyField("Specializations", textAreaSpecializations);

        // ----------------- Semester -----------------

        NumberField numberFieldSemester = new NumberField();
        numberFieldSemester.setValue(Double.valueOf(studentDTO.getStudentSemester()));
        VerticalLayout layoutSemester = generateSinglePropertyField("Semester", numberFieldSemester);

        // ----------------- Save Changes -----------------

        Button buttonSaveChanges = getWommBuilder().Button.create("Save Changes");
        buttonSaveChanges.addClickListener(e -> saveChanges(
                datePickerDob,
                checkEmailNotifs,
                emailField,
                emailFieldConfirm,
                passwordOld,
                passwordNew,
                passwordNewConfirm,
                fieldLocation,
                textAreaBio,
                textAreaSpecializations,
                numberFieldSemester
        ));

        layoutDetails.add(
                layoutName,
                new Hr(), layoutDob,
                new Hr(), checkEmailNotifs,
                new Hr(), layoutEmail,
                new Hr(), layoutPassword,
                new Hr(), layoutLocation,
                new Hr(), layoutBio,
                new Hr(), layoutSpec,
                new Hr(), layoutSemester,
                new Hr(), buttonSaveChanges
        );

        layoutProfile.add(
                layoutDetails,
                layoutPicture
        );

        return layoutProfile;
    }

    private VerticalLayout generateSinglePropertyField(String spanHeader, Component propertyField) {
        VerticalLayout layoutProperty = new VerticalLayout();
        Span spanPropertyHeader = getWommBuilder().Span.create(spanHeader);

        spanPropertyHeader.getElement()
                .getStyle()
                .set("font-size", "20px")
                .set("width", "100%");

        propertyField
                .getStyle()
                .set("width", "100%");

        layoutProperty.add(
                spanPropertyHeader,
                propertyField
        );

        return layoutProperty;
    }

    private boolean validateDatepicker(DatePicker geburtstag) {
        return (geburtstag != null && !geburtstag.toString().isBlank());
    }

    private boolean validateEmail(EmailField email, EmailField confirmEmail) {
        return (email != null && confirmEmail != null && email.getValue().equals(confirmEmail.getValue()));
    }

    private boolean validatePassword(PasswordField oldPassword, PasswordField newPassword, PasswordField newPasswordConfirm) {
        // ToDo: Password validation
        return true;
    }

    private boolean validateSemester(NumberField semester) {
        return (semester != null && semester.getValue() != null && semester.getValue() >= 1);
    }
}

