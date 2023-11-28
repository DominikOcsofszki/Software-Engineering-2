package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import jakarta.annotation.security.RolesAllowed;

@Route(value = ROUTING.ALL.LandingPageView, layout = LoggedOutLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN", "STUDENT"})
@AnonymousAllowed
@PageTitle("LandingPageView")
public class LandingPageView extends VerticalLayout {

    public LandingPageView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        // Header-Bereich
        HorizontalLayout header = createHeader();
        add(header);


        // Hero-Bereich
        VerticalLayout heroSection = createHeroSection();
        add(heroSection);

        // Logo-Bereich
        HorizontalLayout logoSection = createLogoSection();
        add(logoSection);

        // Beschreibung
        VerticalLayout descriptionSection = createDescriptionSection();
        add(descriptionSection);

        // Registrierungs- oder Anmeldebereich
        HorizontalLayout registrationSection = createRegistrationSection();
        add(registrationSection);

        // Kontaktinformationen
        Div contactInfo = createContactInfo();
        add(contactInfo);

        // Footer-Bereich
        HorizontalLayout footer = createFooter();
        add(footer);
    }

    private HorizontalLayout createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        Image logoImage = new Image("themes/theme_1/Womm_big_logo.png", "");
        logoImage.setWidth("280px");
        logoImage.setHeight("60px");
        header.add(logoImage);
        return header;
    }


    private HorizontalLayout createLogoSection() {
        HorizontalLayout logoSection = new HorizontalLayout();
       /* Image logoImage = new Image("themes/theme_1/Womm_big_logo.png", "");
        logoImage.setWidth("260px");
        logoImage.setHeight("60px");
        logoSection.add(logoImage);
*/        return logoSection;
    }
    private VerticalLayout createHeroSection() {
        VerticalLayout heroSection = new VerticalLayout();
        heroSection.setAlignItems(FlexComponent.Alignment.CENTER);
        Image heroImage = new Image("themes/theme_1/Hiring_pic.jpg", "");
        heroImage.setWidth("500px");
        heroImage.setHeight("400px");
        heroSection.add(heroImage);
        return heroSection;
    }

   /* private Div createHeroSection() {
        // Div-Element, das den Hintergrund bildet
        Div heroSection = new Div();
        heroSection.getStyle().set("background-image", "url('themes/theme_1/Background_hero_womm.jpg')");
        heroSection.getStyle().set("background-size", "cover"); // Das Bild auf die gesamte Seite ausdehnen
        heroSection.getStyle().set("background-attachment", "fixed"); // Das Bild fixieren, damit es beim Scrollen sichtbar bleibt
        heroSection.setWidth("100%");
        heroSection.setHeight("70vh"); // volle Bildschirmhöhe

        VerticalLayout content = new VerticalLayout();
        content.setAlignItems(FlexComponent.Alignment.CENTER);

        heroSection.add(content);

        return heroSection;
    }*/

    private VerticalLayout createDescriptionSection() {
        VerticalLayout descriptionSection = new VerticalLayout();
        descriptionSection.setAlignItems(FlexComponent.Alignment.CENTER);
        H1 title = new H1("Find your dream job on w.o.m.m.");
        title.getStyle().set("color", "#044FA3"); // HEX-Farbcode
        descriptionSection.add(title);

        Paragraph description = new Paragraph("Your job search portal. Discover thousands of job opportunities and more.");
        description.getStyle().set("color", "#044FA3"); // HEX-Farbcode
        descriptionSection.add(description);

        return descriptionSection;
    }

    private HorizontalLayout createRegistrationSection() {
        HorizontalLayout registrationSection = new HorizontalLayout();

            Button buttonReg = new Button("SignUp");
            buttonReg.addClickListener( e -> UI.getCurrent().navigate(RegistrierungStudentView.class));
            buttonReg.getStyle().set("background-color", "#044FA3"); // HEX-Farbcode
            buttonReg.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            registrationSection.add(buttonReg);

            Button buttonLog = new Button("LogIn");
            buttonLog.addClickListener( e -> UI.getCurrent().navigate(LoginView.class));
            buttonLog.getStyle().set("background-color", "#044FA3"); // HEX-Farbcode
            buttonLog.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            registrationSection.add(buttonLog);

        registrationSection.add(buttonReg);
        registrationSection.add(buttonLog);

        return registrationSection;
    }

    private Div createContactInfo() {
        Div contactInfo = new Div();
        contactInfo.add(new Text("Want to create company profile? Contact us at kontakt@womm.de."));
        return contactInfo;
    }

    private HorizontalLayout createFooter() {
        HorizontalLayout footer = new HorizontalLayout();
        footer.add(new Anchor("Datenschutzbestimmungen", "# Data protection"));
        footer.add(new Anchor("Nutzungsbedingungen", "# Terms of use"));
        footer.add(new Anchor("Nutzungsbedingungen", "# Imprint"));
        Div createFooter = new Div();
        createFooter.getStyle().set("background", "#044FA3"); // HEX-Farbcode für den Hintergrund
        return footer;
    }
}
