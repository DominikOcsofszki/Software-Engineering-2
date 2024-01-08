package de.hbrs.se2.womm.views.student;


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
import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.LandingPageView;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;
import java.time.LocalDate;
import java.util.Objects;


@Route(value = ROUTING.STUDENT.SCreateChangeStudentProfileView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("CreateChangeStudentProfileView")
public class SCreateChangeStudentProfileView extends AViewWomm {
    StudentService studentService;
    StudentDTO studentDTO;
    NutzerDTO nutzerDTO;
    String studentName;
    String studentVorname;
    String studentAlias = "do we need this???"; //ToDo in DTO?
    String studentGeburtstag;
    String studentEmail;
    String studentOrt;
    String studentBiographie;
    String studentSpezialisierungen;
    String studentSemester;
    Image studentProfilbild;
    String studentPasswort = "test";
    boolean studentBenachrichtigungen;
    private void setUpDataFromDTO() {
        studentName = studentDTO.getStudentName();
        studentVorname = studentDTO.getStudentVorname();
//        studentAlias = studentDTO.getStudentAlias(); //ToDo in DTO?
        studentGeburtstag = studentDTO.getStudentGeburtstag();
        studentBiographie = studentDTO.getStudentBio();
        studentSpezialisierungen = studentDTO.getStudentSpezialisierung();
        studentSemester = String.valueOf(studentDTO.getStudentSemester());
        studentProfilbild = studentDTO.PlaceholderOrImage();
        studentBenachrichtigungen = studentDTO.isStudentBenachrichtigung();
        nutzerDTO = studentDTO.getNutzer();
        studentEmail = nutzerDTO.getNutzerMail();
        studentOrt = nutzerDTO.getNutzerOrt();

    }
    public SCreateChangeStudentProfileView(StudentService studentService,SecurityService securityService) {
        this.studentService = studentService;
        this.studentDTO = studentService.getByNutzerId(securityService.getLoggedInNutzerID());
        setUpDataFromDTO();
        //System.out.println(studentDTO);
        //System.out.println(nutzerDTO + " NUTZER");
        Header();
        Profil();
    }
    private void saveDTO(){
        //studentDTO.setStudentAlias();     nicht nötig ?
        studentDTO.setStudentGeburtstag(studentGeburtstag);
        studentDTO.setNutzer(nutzerDTO);
        studentDTO.getNutzer().setNutzerMail(studentEmail);
        studentDTO.getNutzer().setNutzerOrt(studentOrt);
        //Passwort muss noch gemacht werden
        studentDTO.setStudentBio(studentBiographie);
        studentDTO.setStudentSpezialisierung(studentSpezialisierungen);
        studentDTO.setStudentSemester(Objects.equals(studentSemester, "null") ? null : Integer.parseInt(studentSemester));
        studentDTO.setStudentBenachrichtigung(studentBenachrichtigungen);
        studentService.saveStudent(studentDTO);
    }
    private void saveChanges(){
        if( !(datePicker.isInvalid()) && datePicker.getValue()!=null && (!((datePicker.getValue().toString()).equals(studentGeburtstag)))){
            studentGeburtstag = datePicker.getValue().toString();
        }
        if(!((checkbox1.getValue() == studentBenachrichtigungen))){     //Benachrichtigungen
            studentBenachrichtigungen = checkbox1.getValue();
        }
        if(!((textField.getValue().equals(studentAlias)))){             //Alias
            studentAlias = textField.getValue();
        }
        if(!validEmailField2.isInvalid() && (!((validEmailField1.getValue().equals(studentAlias))))&&(!((validEmailField2.getValue().equals(studentAlias))))&&(((validEmailField1.getValue().equals(validEmailField2.getValue())))) && validEmailField2!=null){             //E-Mail
            studentEmail = validEmailField1.getValue();
        }
        if(!passwordField2.isInvalid() && (passwordField1.getValue().equals(studentPasswort)) && (passwordField2.getValue().equals(passwordField3.getValue())) && passwordField2!=null){             //Passwort
            studentPasswort = passwordField2.getValue();
        }
        //System.out.println("1 " + passwordField1.getValue()+" 2 "+passwordField2.getValue()+" 3 "+ passwordField3.getValue()+" 4 " + studentPasswort +" "+ passwordField2.isInvalid());
        if(!((textField1.getValue().equals(studentOrt)))){                          //Ort
            studentOrt = textField1.getValue();
        }
        if(!((textArea.getValue().equals(studentBiographie)))){                    //Biographie
            studentBiographie = textArea.getValue();
        }
        if(!((textArea2.getValue().equals(studentSpezialisierungen)))){                    //Spezialisierungen
            studentSpezialisierungen = textArea2.getValue();
        }
        if(!numberField.isInvalid() && (!((numberField.getValue() == (Objects.equals(studentSemester, "null") ? 0 : Double.parseDouble(studentSemester)))))){                    //Semester
            int i = numberField.getValue().intValue();
            studentSemester = Integer.toString(i);
        }
        //System.out.println("1 " + (Objects.equals(studentSemester, "null") ? 0 : Double.parseDouble(studentSemester))+" 2 "+studentSemester+" 3 "+ numberField.getValue()+" 4 " + !numberField.isInvalid() +" "+ !numberField.isInvalid());
        //System.out.println("1 " +  validEmailField1.getValue()+" 2 "+studentEmail+" 3 "+ passwordField3.getValue()+" 4 " + studentPasswort +" "+ passwordField2.isInvalid());
        saveDTO();
    }
    HorizontalLayout header = new HorizontalLayout();
    TextField textField = new TextField();                              //Alias
    TextField textField1 = new TextField();                             //Ort
    EmailField  validEmailField1  = new EmailField();                   //E-Mail
    EmailField  validEmailField2  = new EmailField();                   //E-Mail
    PasswordField passwordField1 = new PasswordField();                 //Passwort
    PasswordField passwordField2 = new PasswordField();                 //Passwort
    PasswordField passwordField3 = new PasswordField();                 //Passwort
    TextArea textArea = new TextArea();                                 //Biographie
    TextArea textArea2 = new TextArea();                                //Spezialisierungen
    DatePicker datePicker = new DatePicker("");                     //Datum
    Checkbox checkbox1 = new Checkbox();                                //Benachrichtugnen
    NumberField numberField = new NumberField();                        //akutelles Semester
    private void Header(){
        HorizontalLayout header = new HorizontalLayout();
        Button b = getWommBuilder().Button.create("Home");
        b.getElement().getStyle().set("margin-right", "0%");
        b.addClickListener( e -> UI.getCurrent().navigate(LandingPageView.class));
        header.add(b);
        b = getWommBuilder().Button.create("Save Changes");
        b.getElement().getStyle().set("margin-right", "auto");
        b.addClickListener( e -> saveChanges());
        header.add(b);
        header.setWidth("100%");
        add(header);
    }
    private void Profil() {
        LocalDate datum = LocalDate.parse("2000-01-01");
        Span s;
        Span s1;
        Span s2;
        Span s3;
        Span s4;
        VerticalLayout ProfileVert = new VerticalLayout();
        VerticalLayout headervert = new VerticalLayout();
        VerticalLayout headervert2 = new VerticalLayout();
        ////////////////////Profile Picture//////////////////////////////////////////////////////////////////////////////
        Image i = studentProfilbild;
        i.setWidth("100%");
        i.setHeight("100%");
        Button profile = getWommBuilder().Button.create("Upload");
        profile.setWidth("100%");
        ProfileVert.add(i);
        ProfileVert.add(profile);
        ProfileVert.setSpacing(false);
        ProfileVert.setPadding(false);
        ProfileVert.setWidth("30%");
        ProfileVert.setHeight("30%");
        header.add(ProfileVert);
        headervert.setWidth("100%");
        headervert.setHeight("100%");
        headervert2.setWidth("100%");
        headervert2.setHeight("100%");
        ////////////////////Name//////////////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Name");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = new Span(studentVorname +" "+ studentName);
        s1.getElement().getStyle().set("font-size", "45px");
        s1.getElement().getStyle().set("color", "#192434");       //color black
        s2 = getWommBuilder().Span.create("The name can only be changed with the agreement of an admin");
        s2.getElement().getStyle().set("font-size", "15px");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.add(s2);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Geburtstag///////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Date of Birth");
        s.getElement().getStyle().set("font-size", "20px");
        headervert2.add(s);
        DatePicker.DatePickerI18n singleFormatI18n = new DatePicker.DatePickerI18n();
        singleFormatI18n.setDateFormat("dd.MM.yyyy");
        datePicker.setI18n(singleFormatI18n);
        datePicker.setTooltipText(getWommBuilder().translateText("Select your date of birth"));
        datePicker.setErrorMessage(getWommBuilder().translateText("Invalid date given. Dates must follow the 'DD.MM.YYYY' format."));
        datePicker.setValue(datum);
        datePicker.setValue(studentGeburtstag==null ? datum : LocalDate.parse(studentGeburtstag));
        datePicker.setWidth("50%");
        headervert2.add(datePicker);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Benachrichtigungen///////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Push Notifications");
        s1 = getWommBuilder().Span.create("I would like to receive notifications");
        s.getElement().getStyle().set("font-size", "20px");
        s1.getElement().getStyle().set("font-size", "20px");
        checkbox1.setLabelComponent(s1);
        checkbox1.setValue(studentBenachrichtigungen);                                   //DTO Benachrichtigungen
        //headervert2.add(s);
        headervert2.add(checkbox1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Alias///////////////////////////////////////////////////////////////////////////////////
        /*s = getWommBuilder().Span.create("alias");    //aktuell nicht im Backend
        s.getElement().getStyle().set("font-size", "20px");
        textField.setWidth("50%");
        textField.getStyle().set("flex-grow","1");
        textField.setValue(studentAlias);
        headervert2.add(s);
        headervert2.add(textField);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();*/
        ////////////////////EMail////////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("e-mail");
        s.getElement().getStyle().set("font-size", "20px");
        s2 = getWommBuilder().Span.create("Confirm e-mail");
        s3 = getWommBuilder().Span.create("Please enter a valid e-mail address");
        s2.getElement().getStyle().set("font-size", "15px");
        s3.getElement().getStyle().set("font-size", "15px");
        s3.getElement().getStyle().set("color", "#CBA7A2");          //color error-red
        validEmailField1.setWidth("50%");
        validEmailField1.getStyle().set("flex-grow","1");
        validEmailField1.setValue(studentEmail==null ? "" : studentEmail);
        validEmailField1.setClearButtonVisible(true);
        validEmailField1.setErrorMessage(getWommBuilder().translateText("Please enter a valid e-mail address"));
        validEmailField1.setTooltipText(getWommBuilder().translateText("Please enter a valid e-mail address"));
        validEmailField2.setWidth("50%");
        validEmailField2.getStyle().set("flex-grow","1");
        validEmailField2.setValue("");
        validEmailField2.setClearButtonVisible(true);
        validEmailField2.setTooltipText(getWommBuilder().translateText("Please re-enter your valid e-mail address"));
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
        s = getWommBuilder().Span.create("Password");
        s.getElement().getStyle().set("font-size", "20px");
        s1 = getWommBuilder().Span.create("Enter your old password");
        s2 = getWommBuilder().Span.create("Enter your new password");
        s3 = getWommBuilder().Span.create("Repeat your new password");
        s4 = getWommBuilder().Span.create("Your password must have 6 to 12 characters. Only letters A-Z and numbers supported.");
        s1.getElement().getStyle().set("font-size", "25px");
        s2.getElement().getStyle().set("font-size", "15px");
        s3.getElement().getStyle().set("font-size", "15px");
        s4.getElement().getStyle().set("font-size", "15px");
        passwordField1.setHelperComponent(s4);
        passwordField1.setClearButtonVisible(true);
        passwordField1.setTooltipText(getWommBuilder().translateText("Please enter your current valid Password"));
        passwordField2.setRequiredIndicatorVisible(true);
        passwordField2.setAllowedCharPattern("[A-Za-z0-9]");
        passwordField2.setMinLength(6);
        passwordField2.setMaxLength(12);
        passwordField2.setClearButtonVisible(true);
        passwordField2.setTooltipText(getWommBuilder().translateText("Please enter your new valid Password"));
        passwordField3.setRequiredIndicatorVisible(true);
        passwordField3.setAllowedCharPattern("[A-Za-z0-9]");
        passwordField3.setMinLength(6);
        passwordField3.setMaxLength(12);
        passwordField3.setClearButtonVisible(true);
        passwordField3.setTooltipText(getWommBuilder().translateText("Please re-enter your new valid Password"));
        passwordField1.setWidth("50%");
        passwordField1.getStyle().set("flex-grow","1");
        passwordField1.setValue("");
        passwordField2.setWidth("50%");
        passwordField2.getStyle().set("flex-grow","1");
        passwordField2.setValue("");
        passwordField3.setWidth("50%");
        passwordField3.getStyle().set("flex-grow","1");
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
        s = getWommBuilder().Span.create("Location");
        s.getElement().getStyle().set("font-size", "20px");
        textField1.setWidth("50%");
        textField1.getStyle().set("flex-grow","1");
        textField1.setValue(studentOrt==null ? "" : studentOrt);
        headervert2.add(s);
        headervert2.add(textField1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Biographie///////////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Biography");
        s.getElement().getStyle().set("font-size", "20px");
        textArea.setWidth("100%");
        textArea.setValue(studentBiographie==null ? "" : studentBiographie);
        headervert2.add(s);
        headervert2.add(textArea);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Spezialisierungen////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Specializations");
        s.getElement().getStyle().set("font-size", "20px");
        textArea2.setWidth("100%");
        textArea2.setValue(studentSpezialisierungen==null ? "" : studentSpezialisierungen);
        headervert2.add(s);
        headervert2.add(textArea2);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Semester////////////////////////////////////////////////////////////////////////////
        s = getWommBuilder().Span.create("Current semester");
        s.getElement().getStyle().set("font-size", "20px");
        numberField.setLabel(getWommBuilder().translateText("I am in semester:"));
        numberField.setValue((Objects.equals(studentSemester, "null") ? 0 : Double.parseDouble(studentSemester)));
        numberField.setWidth("50%");
        numberField.setTooltipText(getWommBuilder().translateText("Please enter your current semester"));
        headervert2.add(s);
        headervert2.add(numberField);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        //////////////////Save Changes/////////////////////////////////////////////////////////////////////////////////////
        Button b = getWommBuilder().Button.create("Save Changes");
        b.addClickListener( e -> saveChanges());
        headervert.add(b);
        header.add(headervert);
        add(header);
    }
}

