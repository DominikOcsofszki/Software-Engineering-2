package de.hbrs.se2.womm.views.components.refactoring;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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
import de.hbrs.se2.womm.controller.StudentController;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.views.LandingPageView;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.time.LocalDate;
import java.util.Date;


@Route(value = "demo", layout = StudentLayout.class)
@RolesAllowed({"STUDENT", "ADMIN"})
@PageTitle("CreateChangeStudentProfileView")
public class SCreateChangeStudentProfileViewRefactor extends AbstractViewDTOgetPrimaryFromService<StudentController, StudentDTO> {

//    String ort = "Bonn";
//    String fullName = "Paul Stein";
//    String date ="2002-02-20";
//    String shortName = "pstein2s";
//    String email = "p_steinn@email.de";
//    String bioText = "2018 nach dem Abitur, Ausbildung als Einzelhandeskaufmann, 2021 nach der Ausbildung angestellt als Einzelhandelskaufmann, Seit 2022 Vollzeit-Informatikstudent.";
//    String skillText = "Windows-User, Social-Media-Plattformen, Officeprogramme, diverse IDEs: viel Java-Coding Erfahrung, mäßige C-Coding  Erfahrung";
    String semester = "3";

    String ort = getDto().getNutzer().getOrt() == null ? "Ort missing?" : getDto().getNutzer().getOrt();
    String firstName = getDto().getStudentVorname();
    String lastName = getDto().getStudentName();
    String fullName = firstName + " " + lastName;
    String date = getDto().getStudentGeburtstag().toString();
    String shortName = "Does not exists in DTO!!! remove ";
    String email = getDto().getNutzer().getEmail() == null ? "Email missing?" : getDto().getNutzer().getEmail();
    String bioText = getDto().getStudentBio() == null ? "Bio missing?" : getDto().getStudentBio();
    String skillText = getDto().getStudentSpezialisierung() == null ?  "Skills missing?": getDto().getStudentSpezialisierung();
//    long semester = 3l;
    Span s1 = new Span(fullName);
    //    LocalDate datum = LocalDate.parse("2002-02-20");
    LocalDate datum = LocalDate.parse(date);
    boolean getMessages = true;
    Checkbox checkbox1 = new Checkbox(getMessages);

    //    TextField textField = new TextField("","","pstein2s");
    TextField textField = new TextField("", "", shortName);
    TextField textField1 = new TextField();
    EmailField validEmailField1 = new EmailField("", email);
    EmailField validEmailField2 = new EmailField();
    PasswordField passwordField1 = new PasswordField();
    PasswordField passwordField2 = new PasswordField();
    PasswordField passwordField3 = new PasswordField();
    TextArea textArea = new TextArea();
    TextArea textArea2 = new TextArea();
    DatePicker datePicker = new DatePicker("");
    //        Checkbox checkbox1 = new Checkbox();//ToDo Outside
    NumberField numberField = new NumberField();
//    TextField numberField = new TextField();
    //        LocalDate datum = LocalDate.parse("2002-02-20"); //ToDo outside
    Span s2;
    Span s3;
    Span s4;

//        textField.setValue("pstein2s");


    public SCreateChangeStudentProfileViewRefactor(StudentController controller, SecurityService securityService) {
        super(controller, securityService);
        System.out.println(getDto());
//        getDtoFromControllerWithSetPrimaryKey();
        //this.getStyle().set("font-family","Open Sans");
        //this.getStyle().set("font-style","normal");
//        System.out.println("getDto:"+getDto());
//        add(getDto().getStudentName());
        Header();
        Profil();
    }

    private void Header() {
        HorizontalLayout header = new HorizontalLayout();
//        Button b = new Button("Home");
//        getVaadinBuilderWomm().H1.create
        Button b = getVaadinBuilderWomm().Button.create("Home");
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        b.getElement().getStyle().set("margin-right", "0%");
        b.addClickListener(e -> UI.getCurrent().navigate(LandingPageView.class));
        header.add(b);
        b = new Button("Save Changes");
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        b.getElement().getStyle().set("margin-right", "auto");
        //b.getElement().getStyle().set("font-family","Open Sans");
        //b.getElement().getStyle().set("font-style","normal");
        header.add(b);
        header.setWidth("100%");
        add(header);
    }

    private void Profil() {
        HorizontalLayout header = new HorizontalLayout();
//        TextField textField = new TextField();
//        TextField textField1 = new TextField();
//        EmailField  validEmailField1  = new EmailField();
//        EmailField  validEmailField2  = new EmailField();
//        PasswordField passwordField1 = new PasswordField();
//        PasswordField passwordField2 = new PasswordField();
//        PasswordField passwordField3 = new PasswordField();
//        TextArea textArea = new TextArea();
//        TextArea textArea2 = new TextArea();
//        DatePicker datePicker = new DatePicker("");
////        Checkbox checkbox1 = new Checkbox();//ToDo Outside
//        NumberField numberField = new NumberField();
////        LocalDate datum = LocalDate.parse("2002-02-20"); //ToDo outside
//        Span s2;
//        Span s3;
//        Span s4;
        ////////////////////Profile Picture//////////////////////////////////////////////////////////////////////////////
        Image i = new Image("themes/theme_1/user.png", "Image not found");
        i.setWidth("100%");
//        i.setHeight("100%");
        //i.setHeight(300, Unit.PIXELS); //for fixed values
        //header.add(i);
        Button profile = new Button("Upload");
        profile.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        // profile.getElement().getStyle().set("margin-left", "7%");
        profile.setWidth("100%");
        //i.getStyle().set("border", "3px solid #C4CBD3");              //grey
        VerticalLayout ProfileVert = new VerticalLayout();
        ProfileVert.add(i);
        ProfileVert.add(profile);
        ProfileVert.setSpacing(false);
        ProfileVert.setPadding(false);
        ProfileVert.setWidth("30%");
        ProfileVert.setHeight("30%");
        header.add(ProfileVert);
        VerticalLayout headervert = new VerticalLayout();
        VerticalLayout headervert2 = new VerticalLayout();
        ////////////////////Name//////////////////////////////////////////////////////////////////////////////////////////
//        Span s = new Span("Name");
        Span s = getVaadinBuilderWomm().Span.create("Name");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");       //color grey
//        Span s1 = new Span("Paul Stein"); //ToDo outside
        s1.getElement().getStyle().set("font-size", "45px");
        s1.getElement().getStyle().set("color", "#192434");       //color black
        s2 = new Span("Der Name kann nur mit Absprache eines Admins geändert werden");
        s2.getElement().getStyle().set("font-size", "15px");
        s2.getElement().getStyle().set("color", "#C4CBD3");      //color grey
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.add(s2);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Geburtstag///////////////////////////////////////////////////////////////////////////////////
        s = new Span("Geburtstag");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        headervert2.add(s);
        DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
        singleFormatI18n.setDateFormat("dd.MM.yyyy");
        datePicker.setI18n(singleFormatI18n);
        datePicker.setTooltipText("Select your date of birth");
        datePicker.setErrorMessage("Invalid date given. Dates must follow the 'DD.MM.YYYY' format.");
        datePicker.setValue(datum);
        headervert2.add(datePicker);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Benachrichtigungen///////////////////////////////////////////////////////////////////////////
        s = new Span("Benachrichtigungen");
        s1 = new Span("Ich möchte Benachrichtigungen erhalten");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s1.getElement().getStyle().set("font-size", "20px");
        s1.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        checkbox1.setLabelComponent(s1);
        //headervert2.add(s);
        headervert2.add(checkbox1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Alias///////////////////////////////////////////////////////////////////////////////////
        s = new Span("Alias");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        textField.setWidth("50%");
        textField.getStyle().set("flex-grow", "1");
//        textField.setValue("pstein2s"); //ToDo outside
        headervert2.add(s);
        headervert2.add(textField);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////EMail////////////////////////////////////////////////////////////////////////////////////
        s = new Span("E-Mail");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s2 = new Span("E-Mail bestätigen");
        s3 = new Span("Enter a valid email address");
        s2.getElement().getStyle().set("font-size", "15px");
        s2.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s3.getElement().getStyle().set("font-size", "15px");
        s3.getElement().getStyle().set("color", "#CBA7A2");          //color error-red
        validEmailField1.setWidth("50%");
        validEmailField1.getStyle().set("flex-grow", "1");
        validEmailField1.setValue(this.email);
//        validEmailField1.setValue("p_steinn@email.de");//ToDo Changed
        validEmailField1.setClearButtonVisible(true);
        validEmailField1.setErrorMessage("Enter a valid email address");
        validEmailField2.setWidth("50%");
        validEmailField2.getStyle().set("flex-grow", "1");
        validEmailField2.setValue("");
        validEmailField2.setClearButtonVisible(true);
        headervert2.add(s);
        headervert2.add(validEmailField1);
        headervert2.add(s2);
        headervert2.add(validEmailField2);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Passwort/////////////////////////////////////////////////////////////////////////////////
        s = new Span("Passwort");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s1 = new Span("Altes Passwort");
        s2 = new Span("Neues Passwort");
        s3 = new Span("Neues Passwort wiederholen");
        s4 = new Span("6 to 12 characters. Only letters A-Z and numbers supported.");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");          //color black
        s2.getElement().getStyle().set("font-size", "15px");
        s2.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s3.getElement().getStyle().set("font-size", "15px");
        s3.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s4.getElement().getStyle().set("font-size", "15px");
        s4.getElement().getStyle().set("color", "#CBA7A2");          //color error-red
        passwordField1.setRequiredIndicatorVisible(true);
        passwordField1.setAllowedCharPattern("[A-Za-z0-9]");
        passwordField1.setMinLength(6);
        passwordField1.setMaxLength(12);
        passwordField1.setHelperComponent(s4);
        passwordField1.setClearButtonVisible(true);
        passwordField2.setRequiredIndicatorVisible(true);
        passwordField2.setAllowedCharPattern("[A-Za-z0-9]");
        passwordField2.setMinLength(6);
        passwordField2.setMaxLength(12);
        passwordField2.setClearButtonVisible(true);
        passwordField3.setRequiredIndicatorVisible(true);
        passwordField3.setAllowedCharPattern("[A-Za-z0-9]");
        passwordField3.setMinLength(6);
        passwordField3.setMaxLength(12);
        passwordField3.setClearButtonVisible(true);
        passwordField1.setWidth("50%");
        passwordField1.getStyle().set("flex-grow", "1");
        passwordField1.setValue("");
        passwordField2.setWidth("50%");
        passwordField2.getStyle().set("flex-grow", "1");
        passwordField2.setValue("");
        passwordField3.setWidth("50%");
        passwordField3.getStyle().set("flex-grow", "1");
        passwordField3.setValue("");
        headervert2.add(s);
        headervert2.add(passwordField1);
        headervert2.add(s2);
        headervert2.add(passwordField2);
        headervert2.add(s3);
        headervert2.add(passwordField3);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Ort//////////////////////////////////////////////////////////////////////////////////////
        s = new Span("Ort");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        textField1.setWidth("min-content");
        textField1.getStyle().set("flex-grow", "1");
        textField1.setValue(this.ort);
        headervert2.add(s);
        headervert2.add(textField1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Biographie///////////////////////////////////////////////////////////////////////////////////
        s = new Span("Biographie");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        //textArea.setLabel("Text area");
        textArea.setWidth("100%");
        textArea.setValue(bioText);
        //        textArea.setValue("2018 nach dem Abitur, Ausbildung als Einzelhandeskaufmann, 2021 nach der Ausbildung angestellt als Einzelhandelskaufmann, Seit 2022 Vollzeit-Informatikstudent.");//ToDo Changed
        headervert2.add(s);
        headervert2.add(textArea);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Spezialisierungen////////////////////////////////////////////////////////////////////////////
        s = new Span("Spezialisierungen");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        textArea2.setWidth("100%");
//        textArea2.setValue("Windows-User, Social-Media-Plattformen, Officeprogramme, diverse IDEs: viel Java-Coding Erfahrung, mäßige C-Coding  Erfahrung");//ToDo changed
        textArea2.setValue(skillText);
        headervert2.add(s);
        headervert2.add(textArea2);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        Button b = new Button("Save Changes");
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Semester////////////////////////////////////////////////////////////////////////////
        s = new Span("Aktuelles Semester");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        numberField.setLabel("Ich bin in Semester:");
//        numberField.setValue(Double.valueOf(String.valueOf(semester)));
        numberField.setValue(Double.valueOf(semester));
//        numberField.setValue(3d);//ToDo Changed
        numberField.setWidth("min-content");
        headervert2.add(s);
        headervert2.add(numberField);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());

        headervert.add(b);
        Image im = new Image();
        header.add(headervert);
        add(header);

    }
}

