package de.hbrs.se2.womm.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import de.hbrs.se2.womm.entities.Bewerbung;
import de.hbrs.se2.womm.views.layouts.LoggedOutLayout;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import jakarta.annotation.security.RolesAllowed;

/*@Route(value = ROUTING.UNTERNEHMEN.UApplicationView, layout = UnternehmenLayout.class)
@Route(value = ROUTING.UNTERNEHMEN.UApplicationView, layout = LoggedOutLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@PageTitle("ApplicationView")
*/
@Route(value = ROUTING.UNTERNEHMEN.UApplicationView, layout = LoggedOutLayout.class)
@RolesAllowed({"UNTERNEHMEN", "ADMIN"})
@AnonymousAllowed
@PageTitle("ApplicationView")
public class UApplicationView extends VerticalLayout {

    public UApplicationView() {
        super();
        //Bewerbung bewerbung = UI.getCurrent().getQuery("bewerbung_id");
        Bewerbung bewerbung = null;
        setUpTop(bewerbung);
        setUpAnschreiben(bewerbung);
        setUpLebenslauf(bewerbung);

    }

    private void setUpTop(Bewerbung bewerbung) {
        HorizontalLayout top = new HorizontalLayout();
        top.setAlignItems(FlexComponent.Alignment.CENTER);
        top.setJustifyContentMode(JustifyContentMode.AROUND);
        Image image = new Image("themes/theme_1/user.png", "User");
        //image.setSrc(bewerbung.getStudent().getStudentPicture());
        image.setWidth(200, Unit.PIXELS);
        image.setHeight(200, Unit.PIXELS);
        image.getStyle().set("border", "3px solid black");
        top.add(image);
        var name = new H3("Muster, Mann");
        //name = new H4(bewerbung.getStudent().getStudentName() + bewerbung.getStudent().getStudentVorname());
        top.add(name);
        Button chat = new Button("Chat", event -> {
            //TODO
            UI.getCurrent().getPage().reload();
        });
        top.add(chat);
        add(top);
    }

    private void setUpAnschreiben(Bewerbung bewerbung) {
        //var anschreiben = new Paragraph(bewerbung.getBewerbungText());
        var anschreiben = new Paragraph("ASD ist ein deutsches Hip-Hop-Duo, das aus den Rappern Afrob und Samy Deluxe besteht. Der Name ASD setzt sich aus den Anfangsbuchstaben der Namen der Künstler (Afrob, Samy Deluxe) zusammen.\n" + "Inhaltsverzeichnis\n" + "\n" + "    1 Werdegang\n" + "    2 Diskografie\n" + "        2.1 Studioalben\n" + "        2.2 Singles\n" + "        2.3 Sonstige\n" + "    3 Einzelnachweise\n" + "    4 Weblinks\n" + "\n" + "Werdegang\n" + "\n" + "Die befreundeten Rapper kannten sich bereits vorher durch Projekte wie Brothers Keepers und weitere Kollaborationen. Am 28. März 2003 veröffentlichten sie ihr erstes gemeinsames Album Wer hätte das gedacht?. Dem Album ging die Single Sneak Preview voraus.\n" + "\n" + "Nachdem sie nach 2003 zunächst getrennte Wege gingen, sich aber regelmäßig auf ihren Soloalben und Mixtapes featureten, veröffentlichten sie 2015 die Single Legendär / Populär und kündigten ihr zweites Album Blockbasta an, das am 3. Juli 2015 erschien.\n" + "Diskografie\n" + "Studioalben\n" + "Jahr \tTitel \t\n" + "Chartplatzierungen[1] \tAnmerkungen\n" + " DE \t AT \t CH\n" + "2003 \tWer hätte das gedacht? \t5\n" + "(13 Wo.) \t34\n" + "(7 Wo.) \t24\n" + "(8 Wo.) \t\n" + "Erstveröffentlichung: 28. März 2003\n" + "2015 \tBlockbasta \t4\n" + "(5 Wo.) \t16\n" + "(1 Wo.) \t6\n" + "(4 Wo.) \t\n" + "Erstveröffentlichung: 3. Juli 2015\n" + "Singles\n" + "Jahr \tTitel\n" + "Album \t\n" + "Chartplatzierungen \tAnmerkungen\n" + " DE \t AT \t CH\n" + "2003 \tSneak Preview\n" + "Wer hätte das gedacht? \t12\n" + "(11 Wo.) \t48\n" + "(7 Wo.) \t46\n" + "(10 Wo.) \t\n" + "Erstveröffentlichung: 24. Februar 2003\n" + "Sag mir wo die Party ist!\n" + "Wer hätte das gedacht? \t92\n" + "(2 Wo.) \t— \t— \t\n" + "Erstveröffentlichung: 26. Mai 2003\n" + "Hey Du (Nimm Dir Zeit)\n" + "Wer hätte das gedacht? \t67\n" + "(4 Wo.) \t— \t— \t\n" + "Erstveröffentlichung: 11. August 2003\n" + "2015 \tLegendär / Populär\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 15. Juni 2015\n" + "Blockbasta\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 22. Juni 2015\n" + "Antihaltung\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 29. Juni 2015\n" + "Sonstige\n" + "\n" + "    2003: Wickeda MC Is Da auf Hamburgs Finest Mixtape von Samy Deluxe\n" + "    2004: Champions auf Verdammtnochma! von Samy Deluxe\n" + "    2005: Ohne uns geht es nicht auf Hammer von Afrob\n" + "    2006: Brandneu auf Big Baus of the Nauf von Samy Deluxe\n" + "    2009: ASD Comeback auf Der Letzte seiner Art von Afrob\n" + "    2012: Rap Ist (Extended) (feat. MoTrip, ASD & Megaloh) auf Fühlt sich wie fliegen an von Max Herre\n" + "    2013: Hiphop Remix auf Endlich unendlich von Megaloh\n" + "    2013: Testosteron auf Perlen vor die Säue von Samy Deluxe\n" + "    2013: Tommy Is Back (als Herr Sorge + Afrob) von Thomas D\n" + "    2014: Dr. Cooper (Allstar Remix feat. MoTrip, Aphroe, ASD, Umse, Telly Tellz, Nate57, Ali As, Abdi, Celo) auf Endlich Unendlich Anniversary (Dr. Cooper Remix EP) von Megaloh\n" + "    2014: Pappblick Enemy auf Männlich von Samy Deluxe\n" + "    2014: Schwerer Anschlag auf Push von Afrob\n" + "    2014: So Schön (feat. Megaloh und Afrob) auf Gute alte Zeit von Samy Deluxe\n" + "    2015: Oldschool (ASD Remix) auf Oldschool von Nena\n" + "    2015: Kein Bock (Allstar Remix feat. Jan Delay, ASD, Megaloh & Bartek) auf Derbe von Denyo\n" + "    2016: Puff Daddy (King Remix feat. Eko Fresh & Farid Bang) auf Freezy von Eko Fresh\n" + "    2016: Countdown und Mimimi (Remix) auf Berühmte letzte Worte von Samy Deluxe\n" + "    2016: Herz und Seele auf Mutterschiff von Afrob\n" + "    2016: Exodus auf Regenmacher von Megaloh (feat. ASD, Max Herre & Gentleman)\n" + "    2016: Nicht alles in Ordnung auf dem Breakwater Riddim von Various Artists");
        var details = new Details("Anschreiben", anschreiben);
        details.setOpened(true);
        details.getStyle().set("border", "3px dotted black");
        add(details);
    }

    private void setUpLebenslauf(Bewerbung bewerbung) {
        //var lebenslauf = new Paragraph(bewerbung.getBewerbungPdf().parseToString());
        var lebenslauf = new Paragraph("\tVielen Dank, dass du dir unsere Lebenslauf-Vorlage heruntergeladen hast! Bei den einzelnen Stationen im Lebenslauf handelt es sich um Mustertexte, weshalb du die Vorlage mit deinen eigenen Informationen füllen und den Lebenslauf für deine Bewerbung individualisieren solltest.\n" + "\n" + "\n" + "\n" + "\tLösche dazu diese Seite aus diesem Dokument und ergänze den Lebenslauf mit deinen persönlichen Daten. Die Seite kannst du ganz einfach löschen, indem du alle Inhalte auf dieser Seite markierst und die Entfernen-Taste („Entf“) drückst.\n" + "\n" + "\n" + "\n" + "\tWenn du dich beim Erstellen deines Lebenslaufs nicht 100% sicher fühlst, empfehlen wir dir den kostenlosen Bewerbungsgenerator von bewerbung2go. Dieser bietet dir neben verschiedenen Designvorlagen inhaltliche Vorschläge passend zur ausgewählten Jobbeschreibung. Damit kannst du Schritt für Schritt deinen individuellen Lebenslauf erstellen:\n" + "\n" + "\n" + "\n" + "\tHier entlang zum kostenlosen Bewerbungsgenerator von bewerbung2go\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Carmen Bär\n" + "\n" + "\tVerkäuferin\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "PERSÖNLICHE DATEN\n" + "\n" + "\n" + "\t*30.12.1991 in Musterstadt, deutsch,\n" + "\n" + "verheiratet, zwei Kinder\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "KONTAKT\n" + "\n" + "\n" + "\tMusterstraße 78\n" + "\n" + "\t23456 Musterstadt\n" + "\n" + "\temail@email.de\n" + "\n" + "\t0171 23456789\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "SKILLSET\n" + "\n" + "\n" + "\tMarketingkenntnisse\n" + "\n" + "\tProduktpräsentation\n" + "\n" + "\tKundenberatung\n" + "\n" + "\tTeamfähigkeit\n" + "\n" + "\tGeduld\n" + "\n" + "\tStressresistenz\n" + "\n" + "\tKommunikation\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "SPRACHEN\n" + "\n" + "\n" + "\tDeutsch\n" + "\n" + "\tEnglisch\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\tFundierte Kenntnisse in der strategischen und\n" + "\n" + "operativen Steuerung\n" + "\n" + "\tQualitätsmanagement und vertriebliche Aufgaben\n" + "\n" + "\tUmfassendes betriebswirtschaftliches Know-how\n" + "\n" + "\tAusgeprägte Kunden- und Serviceorientierung mit innovativen Ideen zur Kundenbindung\n" + "\n" + "\tKunden- und marktorientierte Denk- und Handlungsweise\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Lebenslauf\n" + "\n" + "\n" + "\tBerufserfahrungen\n" + "\n" + "\n" + "\tSeit 08.2010 123-Verkauft GmbH, Standort\n" + "\n" + "\tVerkäuferin\n" + "\n" + "\t \t● Kundenberatung\n" + "\n" + "\t● Produktpräsentation\n" + "\n" + "\t● Qualitätsmanagement\n" + "\n" + "\t● Mitarbeit bei der Analyse und Planung verschiedener Werbestrategien\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Ausbildung\n" + "\n" + "\n" + "\t08.2008 - 07.2010 Ausbildungsstätte, Standort\n" + "\n" + "\tAusbildung zur Verkäuferin\n" + "\n" + "\tAbschluss: IHK geprüfte Verkäuferin\n" + "\n" + "\t08.2002 - 06.2008 Realschule Muster, Standort\n" + "\n" + "\tAbschluss: Mittlere Reife\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Weiterbildungen\n" + "\n" + "\n" + "\t2016 Marketing\n" + "\n" + "\t2014 Verkaufsstrategien\n" + "\n" + "\t2012 Qualitätsmanagement\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Weitere Fähigkeiten und Kenntnisse\n" + "\n" + "\n" + "\tPERSÖNLICHE DATEN\n" + "\n" + "\n" + "\t*30.12.1991 in Musterstadt, deutsch,\n" + "\n" + "verheiratet, zwei Kinder\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "KONTAKT\n" + "\n" + "\n" + "\tMusterstraße 78\n" + "\n" + "\t23456 Musterstadt\n" + "\n" + "\temail@email.de\n" + "\n" + "\t0171 23456789\n" + "\n" + "\tCarmen Bär\n" + "\n" + "\tSprachkenntnisse Deutsch, Muttersprache\n" + "\n" + "\tEnglisch, fließend in Wort und Schrift\n" + "\n" + "\n" + "\n" + "\tEDV Microsoft Word, Excel, PowerPoint, Outlook\n" + "\n" + "\n" + "\n" + "\tFührerschein Klasse B\n" + "\n" + "\n" + "\n" + "\tEhrenamt Engagement im Sportverein\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "Musterstadt, 01.01.2023\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\tCarmen Bär\n" + "\n" + "\n" + "\n" + "\n" + "\n");
        var details = new Details("Lebenslauf", lebenslauf);
        details.setOpened(false);
        details.getStyle().set("border", "3px dotted black");
        add(details);
    }


}
