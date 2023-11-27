package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.views.layouts.ASSETS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.STUDENT.SJobProjectWorkshopDisplayView, layout = StudentLayout.class)
@RolesAllowed({"STUDENT","ADMIN"})
@PageTitle("JobProjectWorkshopDisplayView")
public class SJobProjectWorkshopDisplayView extends VerticalLayout {


    public SJobProjectWorkshopDisplayView() {
        setUpBanner();
        setUpHeader();
        setUpStellenanzeige();
        setUpButtons();
    }

    //ToDo Banner anpassen

    private void setUpBanner() {
        VerticalLayout banner = new VerticalLayout();
        Image i = new Image("themes/theme_1/banner.jpg","https://unsplash.com/de/fotos/%EC%B2%AD%EB%A1%9D%EC%83%89-led-%ED%8C%A8%EB%84%90-EUsVwEOsblE");
        i.setWidth("100%");
        banner.add(i);
        add(banner);
    }

    //ToDo bestimmten FirmenNamen + FirmenLogo anzeigen

    private void setUpHeader(){
        HorizontalLayout header = new HorizontalLayout();

        //Logo
        Image i = new Image(ASSETS.RANDOM.USER, "Alternative image text");
        i.setWidth("25%");
        header.add(i);

        //Ueberschrift
        header.add(new H1("Unternehmenname"));
        add(header);
    }



    private void setUpStellenanzeige() {
        VerticalLayout stellenanzeige = new VerticalLayout();


        //ToDo bestimmete StellenanzeigeBezeichnung anzeigen
        //Textfeld
        Paragraph bezeichnung = new Paragraph();
        bezeichnung.setEnabled(false);
        bezeichnung.setText("Werksstudenten-Stelle");

        stellenanzeige.add(bezeichnung);

        //ToDo bestimmte StellenanzeigeBeschreibung anzeigen
        //Textfeld
        Paragraph beschreibung = new Paragraph();
        beschreibung.setWidthFull();
        beschreibung.setEnabled(false);
        beschreibung.setText("Hier könnte ihre Werbung für einen ausbeutenden Job stehen.");

        stellenanzeige.add(beschreibung);

        add(stellenanzeige);

    }

    private void setUpButtons() {
        HorizontalLayout buttons = new HorizontalLayout();

        //ToDo Bewerbung für bestimmten Studenten öffnen
        //Erstellen-Button
        Button bewerbungButton = new Button("Bewerbung", new Icon(VaadinIcon.PENCIL));
        bewerbungButton.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(ROUTING.STUDENT.SApplicationView));
        });
        buttons.add(bewerbungButton);

        //ToDo Chat für bestimmete Studenten-Unternehmen Kombination öffnen
        //Chat-Button
        Button chatButton = new Button("Chat",  new Icon(VaadinIcon.COMMENTS_O));
        chatButton.addClickListener(e -> {
            getUI().ifPresent(ui -> ui.navigate(ROUTING.STUDENT.SChatView));
        });
        buttons.add(chatButton);

        add(buttons);
    }

}
