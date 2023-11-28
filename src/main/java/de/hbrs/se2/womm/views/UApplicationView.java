package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.StreamResource;
import de.hbrs.se2.womm.controller.BewerbungController;
import de.hbrs.se2.womm.controller.StudentController;
import de.hbrs.se2.womm.dtos.BewerbungDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.io.ByteArrayInputStream;

@Route(value = ROUTING.UNTERNEHMEN.UApplicationView, layout = UnternehmenLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("ApplicationView")
public class UApplicationView extends VerticalLayout implements HasUrlParameter<String> {

    private BewerbungController bewerbungController;
    private StudentController studentController;

    private BewerbungDTO bewerbung;
    private Long bewerbungID;
    private String bewerbungText;

    private StudentDTO student;
    private Long studentID;
    private String studentName;
    private String studentVorname;
    private byte[] studentProfilePicture;

    public UApplicationView(BewerbungController bewerbungController, StudentController studentController) throws InterruptedException {
        super();
        this.bewerbungController = bewerbungController;
        this.studentController = studentController;
    }


    @Override
    public void setParameter(BeforeEvent beforeEvent, @OptionalParameter String bewerbungID) {
        if (bewerbungID == null || bewerbungID.equals("example")) {
            setUpExample();
        } else {
            try {
                this.bewerbungID = Long.parseLong(bewerbungID);
                bewerbung = bewerbungController.getById(this.bewerbungID).getBody();
                if (bewerbung == null) {
                    setUpNotFound(bewerbungID);
                } else {
                    setUpApplication();
                }
            } catch (Exception e) {
                add(new H1(String.format("%s ist keine gültige ID.", bewerbungID)));
            }
        }
    }

    void setUpExample() {
        HorizontalLayout top = new HorizontalLayout();
        top.setAlignItems(FlexComponent.Alignment.CENTER);
        top.setJustifyContentMode(JustifyContentMode.AROUND);
        Image image = new Image("themes/theme_1/user.png", "User");
        image.setWidth(200, Unit.PIXELS);
        image.setHeight(200, Unit.PIXELS);
        image.getStyle().set("border", "3px solid black");
        top.add(image);
        var name = new H3("Name, Vorname");
        top.add(name);
        Button chat = new Button("Chat", event -> {
            UI.getCurrent().navigate(ROUTING.UNTERNEHMEN.UChatView);
        });
        top.add(chat);
        add(top);
        var anschreiben = new Paragraph("ASD ist ein deutsches Hip-Hop-Duo, das aus den Rappern Afrob und Samy Deluxe besteht. Der Name ASD setzt sich aus den Anfangsbuchstaben der Namen der Künstler (Afrob, Samy Deluxe) zusammen.\n" + "Inhaltsverzeichnis\n" + "\n" + "    1 Werdegang\n" + "    2 Diskografie\n" + "        2.1 Studioalben\n" + "        2.2 Singles\n" + "        2.3 Sonstige\n" + "    3 Einzelnachweise\n" + "    4 Weblinks\n" + "\n" + "Werdegang\n" + "\n" + "Die befreundeten Rapper kannten sich bereits vorher durch Projekte wie Brothers Keepers und weitere Kollaborationen. Am 28. März 2003 veröffentlichten sie ihr erstes gemeinsames Album Wer hätte das gedacht?. Dem Album ging die Single Sneak Preview voraus.\n" + "\n" + "Nachdem sie nach 2003 zunächst getrennte Wege gingen, sich aber regelmäßig auf ihren Soloalben und Mixtapes featureten, veröffentlichten sie 2015 die Single Legendär / Populär und kündigten ihr zweites Album Blockbasta an, das am 3. Juli 2015 erschien.\n" + "Diskografie\n" + "Studioalben\n" + "Jahr \tTitel \t\n" + "Chartplatzierungen[1] \tAnmerkungen\n" + " DE \t AT \t CH\n" + "2003 \tWer hätte das gedacht? \t5\n" + "(13 Wo.) \t34\n" + "(7 Wo.) \t24\n" + "(8 Wo.) \t\n" + "Erstveröffentlichung: 28. März 2003\n" + "2015 \tBlockbasta \t4\n" + "(5 Wo.) \t16\n" + "(1 Wo.) \t6\n" + "(4 Wo.) \t\n" + "Erstveröffentlichung: 3. Juli 2015\n" + "Singles\n" + "Jahr \tTitel\n" + "Album \t\n" + "Chartplatzierungen \tAnmerkungen\n" + " DE \t AT \t CH\n" + "2003 \tSneak Preview\n" + "Wer hätte das gedacht? \t12\n" + "(11 Wo.) \t48\n" + "(7 Wo.) \t46\n" + "(10 Wo.) \t\n" + "Erstveröffentlichung: 24. Februar 2003\n" + "Sag mir wo die Party ist!\n" + "Wer hätte das gedacht? \t92\n" + "(2 Wo.) \t— \t— \t\n" + "Erstveröffentlichung: 26. Mai 2003\n" + "Hey Du (Nimm Dir Zeit)\n" + "Wer hätte das gedacht? \t67\n" + "(4 Wo.) \t— \t— \t\n" + "Erstveröffentlichung: 11. August 2003\n" + "2015 \tLegendär / Populär\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 15. Juni 2015\n" + "Blockbasta\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 22. Juni 2015\n" + "Antihaltung\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 29. Juni 2015\n" + "Sonstige\n" + "\n" + "    2003: Wickeda MC Is Da auf Hamburgs Finest Mixtape von Samy Deluxe\n" + "    2004: Champions auf Verdammtnochma! von Samy Deluxe\n" + "    2005: Ohne uns geht es nicht auf Hammer von Afrob\n" + "    2006: Brandneu auf Big Baus of the Nauf von Samy Deluxe\n" + "    2009: ASD Comeback auf Der Letzte seiner Art von Afrob\n" + "    2012: Rap Ist (Extended) (feat. MoTrip, ASD & Megaloh) auf Fühlt sich wie fliegen an von Max Herre\n" + "    2013: Hiphop Remix auf Endlich unendlich von Megaloh\n" + "    2013: Testosteron auf Perlen vor die Säue von Samy Deluxe\n" + "    2013: Tommy Is Back (als Herr Sorge + Afrob) von Thomas D\n" + "    2014: Dr. Cooper (Allstar Remix feat. MoTrip, Aphroe, ASD, Umse, Telly Tellz, Nate57, Ali As, Abdi, Celo) auf Endlich Unendlich Anniversary (Dr. Cooper Remix EP) von Megaloh\n" + "    2014: Pappblick Enemy auf Männlich von Samy Deluxe\n" + "    2014: Schwerer Anschlag auf Push von Afrob\n" + "    2014: So Schön (feat. Megaloh und Afrob) auf Gute alte Zeit von Samy Deluxe\n" + "    2015: Oldschool (ASD Remix) auf Oldschool von Nena\n" + "    2015: Kein Bock (Allstar Remix feat. Jan Delay, ASD, Megaloh & Bartek) auf Derbe von Denyo\n" + "    2016: Puff Daddy (King Remix feat. Eko Fresh & Farid Bang) auf Freezy von Eko Fresh\n" + "    2016: Countdown und Mimimi (Remix) auf Berühmte letzte Worte von Samy Deluxe\n" + "    2016: Herz und Seele auf Mutterschiff von Afrob\n" + "    2016: Exodus auf Regenmacher von Megaloh (feat. ASD, Max Herre & Gentleman)\n" + "    2016: Nicht alles in Ordnung auf dem Breakwater Riddim von Various Artists");
        var details = new Details("Anschreiben", anschreiben);
        details.setOpened(true);
        details.getStyle().set("border", "3px dotted black");
        add(details);
    }

    void setUpNotFound(String id) {
        add(new H1(String.format("Die Bewerbung mit der ID '%s' konnte nicht gefunden werden.", id)));
    }

    void setUpApplication() {
        bewerbungText = bewerbung.getBewerbungText();
        studentID = bewerbung.getBewerbungStudent().getStudentId();
        student = studentController.getStudentById(studentID).getBody();
        studentName = student.getStudentName();
        studentVorname = student.getStudentVorname();
        studentProfilePicture = student.getNutzer().getNutzerProfilbild();
        setUpTop();
        setUpAnschreiben();
    }

    private void setUpTop() {
        HorizontalLayout top = new HorizontalLayout();
        top.setAlignItems(FlexComponent.Alignment.CENTER);
        top.setJustifyContentMode(JustifyContentMode.AROUND);
        StreamResource resource = new StreamResource(studentName + ".jpg", () -> new ByteArrayInputStream(studentProfilePicture));
        Image image = new Image(resource, studentName);
        image.setWidth(200, Unit.PIXELS);
        image.setHeight(200, Unit.PIXELS);
        image.getStyle().set("border", "3px solid black");
        top.add(image);
        var name = new H3(String.format("%s, %s", studentName, studentVorname));
        top.add(name);
        Button chat = new Button("Chat", event -> {
            UI.getCurrent().navigate(ROUTING.UNTERNEHMEN.UChatView + "/" + studentID);
        });
        top.add(chat);
        add(top);
    }

    private void setUpAnschreiben() {
        var anschreiben = new Paragraph(bewerbungText);
        var details = new Details("Anschreiben", anschreiben);
        details.setOpened(true);
        details.getStyle().set("border", "3px dotted black");
        add(details);
    }
}
