package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.checkbox.CheckboxGroupVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import com.vaadin.flow.component.checkbox.Checkbox;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AnonymousAllowed
@Route(value = ROUTING.STUDENT.SCreateChangeStudentProfileView, layout = LoggedOutLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("CreateChangeStudentProfileView")
public class SCreateChangeStudentProfileView extends VerticalLayout {
    public SCreateChangeStudentProfileView() {
        Header();
        Profil();
    }
    private void Header(){
        HorizontalLayout header = new HorizontalLayout();
        Button b = new Button("Home");
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        b.getElement().getStyle().set("margin-right", "0%");
        b.addClickListener( e -> UI.getCurrent().navigate(LandingPageView.class));
        header.add(b);
        b = new Button("Save Changes");
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        b.getElement().getStyle().set("margin-right", "auto");
        header.add(b);
        b = new Button("Start Chatting");
        b.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        b.addClickListener( e -> UI.getCurrent().navigate(SChatView.class));

        b.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
        header.add(b);
        add(header);
    }
    private void Profil() {
        HorizontalLayout header = new HorizontalLayout();
        Select select = new Select();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        TextArea textArea = new TextArea();
        TextArea textArea2 = new TextArea();
        DatePicker datePicker = new DatePicker("");
        Checkbox checkbox1 = new Checkbox();
        NumberField numberField = new NumberField();
        LocalDate datum = LocalDate.parse("1999-01-01");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd z");
        //ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-05-05 Europe/Paris", formatter);
        //LocalDate datum = LocalDate.from(java.time.ZonedDateTime.now().toInstant());
        ////////////////////Profile Picture//////////////////////////////////////////////////////////////////////////////
        Image i = new Image("themes/theme_1/user.png","Image not found");
        i.setWidth("100%");
        i.setHeight("100%");
        //i.setHeight(300, Unit.PIXELS); //for fixed values
        //header.add(i);
        Button profile = new Button("Upload");
        profile.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
       // profile.getElement().getStyle().set("margin-left", "7%");
        profile.setWidth("100%");
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
        Span s = new Span("Name");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");       //color grey
        Span s1 = new Span("Tobias Bromberg");
        s1.getElement().getStyle().set("font-size", "45px");
        s1.getElement().getStyle().set("color", "#192434");       //color black
        Span s2 = new Span("Der Name kann nur mit Absprache eines Admins geändert werden");
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
        //select.setLabel("Select");
        //select.setWidth("100%");
        //setSelectSampleData(select);

        s1 = new Span("Informatik (B.Sc.)");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");          //color black
        headervert2.add(s);
        //headervert2.add(s1);
        //headervert2.add(select);


        datePicker.setValue(datum);
        headervert2.add(datePicker);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        ////////////////////Benachrichtigungen///////////////////////////////////////////////////////////////////////////
        s = new Span("Kontakt");
        checkbox1.setLabel("Ich möchte Benachrichtigungen erhalten");
        //checkbox.setLabel("I accept the terms and conditions");
        //textField.setLabel("Private email");
        //textField.setWidth("100%");
        //textField.setValue("max_mustermann@h-brs.de");
        //headervert2.add(s);
        //headervert2.add(textField);
        //textField2.setLabel("Rufnummer");
        //textField2.setWidth("100%");
        //textField2.setValue("01234 56789");
        //headervert2.add(textField2);
       /* s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "#C4CBD3");          //color grey
        s1 = new Span("MyExampleMail@yahoo.com");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");          //color black
        headervert2.add(s1);*/
        headervert2.add(checkbox1);
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
        textArea.setValue("Noch keine!");
        s1 = new Span("Noch keine");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");         //color black
        headervert2.add(s);
        //headervert2.add(s1);
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
        textArea2.setValue("Datenbanken, Testen, Websites");
        s1 = new Span("Datenbanken, Testen, Websites");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "#192434");         //color black
        headervert2.add(s);
        //headervert2.add(s1);
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
        numberField.setValue(4d);
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
    record SampleItem(String value, String label, Boolean disabled) {
    }
    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("Analytische Chemie und Qualitätssicherung (M.Sc.)", "Analytische Chemie und Qualitätssicherung (M.Sc.)", null));
        sampleItems.add(new SampleItem("Applied Biology (B.Sc.) ", "Applied Biology (B.Sc.) ", null));
        sampleItems.add(new SampleItem("Biomedical Sciences (M.Sc.)", "Biomedical Sciences (M.Sc.)", null));
        sampleItems.add(new SampleItem("Chemie mit Materialwissenschaften (B.Sc.)", "Chemie mit Materialwissenschaften (B.Sc.)", null));
        sampleItems.add(new SampleItem("Elektrotechnik (B.Eng.)", "Elektrotechnik (B.Eng.)", null));
        sampleItems.add(new SampleItem("Nachhaltige Chemie und Materialien (B.Sc.)", "Nachhaltige Chemie und Materialien (B.Sc.)", null));
        sampleItems.add(new SampleItem("Materials Science and Sustainability Methods (M.Sc.)", "Materials Science and Sustainability Methods (M.Sc.)", null));
        sampleItems.add(new SampleItem("Naturwissenschaftliche Forensik (B.Sc.)", "Naturwissenschaftliche Forensik (B.Sc.)", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }
}
/*
package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.newdom.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.newdom.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

@AnonymousAllowed
@Route(value = "StudentProfileDisplayView", layout = LoggedOutLayout.class)
//@RolesAllowed({"UNTERNEHMEN","ADMIN"})
@PageTitle("StudentProfileDisplayView")
public class StudentProfileDisplayView extends VerticalLayout {
    public StudentProfileDisplayView() {

        Header();
        Profil();
    }
    private void Header(){
        HorizontalLayout header = new HorizontalLayout();
        Button b = new Button("Home");
        header.add(b);
        b.addClickListener( e -> UI.getCurrent().navigate(LandingPageView.class));
        b = new Button("Start Chatting");
        b.addClickListener( e -> UI.getCurrent().navigate(ChatView.class));
        header.add(b);
        b.getElement().getStyle().set("margin-left", "auto");
        header.setWidth("100%");
        add(header);
    }
    private void Profil() {
        HorizontalLayout header = new HorizontalLayout();
        Image i = new Image("themes/theme_1/user.png","Image not found");
        i.setWidth("30%");
        i.setHeight("30%");
        //i.setHeight(300, Unit.PIXELS); //for fixed values
        header.add(i);
        VerticalLayout headervert = new VerticalLayout();
        VerticalLayout headervert2 = new VerticalLayout();
        Span s = new Span("Name");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "grey");
        Span s1 = new Span("Tobias Bromberg");
        s1.getElement().getStyle().set("font-size", "45px");
        s1.getElement().getStyle().set("color", "black");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        s = new Span("Studiengang");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "grey");
        s1 = new Span("Informatik (B.Sc.)");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "black");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        s = new Span("Kontakt");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "grey");
        s1 = new Span("MyExampleMail@yahoo.com");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "black");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        s = new Span("Abschlüsse");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "grey");
        s1 = new Span("Noch keine");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "black");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        s = new Span("Sprachen");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "grey");
        s1 = new Span("Deutsch,Englisch");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "black");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        headervert.add(new Hr());
        headervert2 = new VerticalLayout();
        s = new Span("Interessen");
        s.getElement().getStyle().set("font-size", "20px");
        s.getElement().getStyle().set("color", "grey");
        s1 = new Span("Datenbanken, Testen, Websites");
        s1.getElement().getStyle().set("font-size", "25px");
        s1.getElement().getStyle().set("color", "black");
        headervert2.add(s);
        headervert2.add(s1);
        headervert2.setSpacing(false);
        headervert2.setPadding(false);
        headervert.add(headervert2);
        header.add(headervert);
        add(header);
    }
}

 */