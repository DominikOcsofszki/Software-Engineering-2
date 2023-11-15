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
