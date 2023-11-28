package tools.collection;

import com.vaadin.flow.component.html.Paragraph;

import java.util.Random;

public class BewerbungText {

    public static String getBewerbungTextRandom() {
        return LoremText.getRandomText() + LoremText.getRandomText() +  LoremText.getRandomText() +
                LoremText.getRandomText() + LoremText.getRandomText() +  LoremText.getRandomText()+
                LoremText.getRandomText() + LoremText.getRandomText() +  LoremText.getRandomText();  
    }

    private static String[] listOfRandomItems = {
           "ASD ist ein deutsches Hip-Hop-Duo, das aus den Rappern Afrob und Samy Deluxe besteht. Der Name ASD setzt sich aus den Anfangsbuchstaben der Namen der Künstler (Afrob, Samy Deluxe) zusammen.\n" + "Inhaltsverzeichnis\n" + "\n" + "    1 Werdegang\n" + "    2 Diskografie\n" + "        2.1 Studioalben\n" + "        2.2 Singles\n" + "        2.3 Sonstige\n" + "    3 Einzelnachweise\n" + "    4 Weblinks\n" + "\n" + "Werdegang\n" + "\n" + "Die befreundeten Rapper kannten sich bereits vorher durch Projekte wie Brothers Keepers und weitere Kollaborationen. Am 28. März 2003 veröffentlichten sie ihr erstes gemeinsames Album Wer hätte das gedacht?. Dem Album ging die Single Sneak Preview voraus.\n" + "\n" + "Nachdem sie nach 2003 zunächst getrennte Wege gingen, sich aber regelmäßig auf ihren Soloalben und Mixtapes featureten, veröffentlichten sie 2015 die Single Legendär / Populär und kündigten ihr zweites Album Blockbasta an, das am 3. Juli 2015 erschien.\n" + "Diskografie\n" + "Studioalben\n" + "Jahr \tTitel \t\n" + "Chartplatzierungen[1] \tAnmerkungen\n" + " DE \t AT \t CH\n" + "2003 \tWer hätte das gedacht? \t5\n" + "(13 Wo.) \t34\n" + "(7 Wo.) \t24\n" + "(8 Wo.) \t\n" + "Erstveröffentlichung: 28. März 2003\n" + "2015 \tBlockbasta \t4\n" + "(5 Wo.) \t16\n" + "(1 Wo.) \t6\n" + "(4 Wo.) \t\n" + "Erstveröffentlichung: 3. Juli 2015\n" + "Singles\n" + "Jahr \tTitel\n" + "Album \t\n" + "Chartplatzierungen \tAnmerkungen\n" + " DE \t AT \t CH\n" + "2003 \tSneak Preview\n" + "Wer hätte das gedacht? \t12\n" + "(11 Wo.) \t48\n" + "(7 Wo.) \t46\n" + "(10 Wo.) \t\n" + "Erstveröffentlichung: 24. Februar 2003\n" + "Sag mir wo die Party ist!\n" + "Wer hätte das gedacht? \t92\n" + "(2 Wo.) \t— \t— \t\n" + "Erstveröffentlichung: 26. Mai 2003\n" + "Hey Du (Nimm Dir Zeit)\n" + "Wer hätte das gedacht? \t67\n" + "(4 Wo.) \t— \t— \t\n" + "Erstveröffentlichung: 11. August 2003\n" + "2015 \tLegendär / Populär\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 15. Juni 2015\n" + "Blockbasta\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 22. Juni 2015\n" + "Antihaltung\n" + "Blockbasta \t— \t— \t— \t\n" + "Erstveröffentlichung: 29. Juni 2015\n" + "Sonstige\n" + "\n" + "    2003: Wickeda MC Is Da auf Hamburgs Finest Mixtape von Samy Deluxe\n" + "    2004: Champions auf Verdammtnochma! von Samy Deluxe\n" + "    2005: Ohne uns geht es nicht auf Hammer von Afrob\n" + "    2006: Brandneu auf Big Baus of the Nauf von Samy Deluxe\n" + "    2009: ASD Comeback auf Der Letzte seiner Art von Afrob\n" + "    2012: Rap Ist (Extended) (feat. MoTrip, ASD & Megaloh) auf Fühlt sich wie fliegen an von Max Herre\n" + "    2013: Hiphop Remix auf Endlich unendlich von Megaloh\n" + "    2013: Testosteron auf Perlen vor die Säue von Samy Deluxe\n" + "    2013: Tommy Is Back (als Herr Sorge + Afrob) von Thomas D\n" + "    2014: Dr. Cooper (Allstar Remix feat. MoTrip, Aphroe, ASD, Umse, Telly Tellz, Nate57, Ali As, Abdi, Celo) auf Endlich Unendlich Anniversary (Dr. Cooper Remix EP) von Megaloh\n" + "    2014: Pappblick Enemy auf Männlich von Samy Deluxe\n" + "    2014: Schwerer Anschlag auf Push von Afrob\n" + "    2014: So Schön (feat. Megaloh und Afrob) auf Gute alte Zeit von Samy Deluxe\n" + "    2015: Oldschool (ASD Remix) auf Oldschool von Nena\n" + "    2015: Kein Bock (Allstar Remix feat. Jan Delay, ASD, Megaloh & Bartek) auf Derbe von Denyo\n" + "    2016: Puff Daddy (King Remix feat. Eko Fresh & Farid Bang) auf Freezy von Eko Fresh\n" + "    2016: Countdown und Mimimi (Remix) auf Berühmte letzte Worte von Samy Deluxe\n" + "    2016: Herz und Seele auf Mutterschiff von Afrob\n" + "    2016: Exodus auf Regenmacher von Megaloh (feat. ASD, Max Herre & Gentleman)\n" + "    2016: Nicht alles in Ordnung auf dem Breakwater Riddim von Various Artists",


            "Anschreiben.com\n" +
                    "Ein Service von \n" +
                    "Dein professionelles Bewerbungsschreiben als PDF\n" +
                    "Ratgeber\n" +
                    " Start  Textvorschläge anpassen\n" +
                    "Textvariante:123\n" +
                    " \n" +
                    "Warum bewirbst du dich bei dem Unternehmen?\n" +
                    "\n" +
                    "Wir empfehlen dir, deine Motivation möglichst genau zu beschreiben. Was sind deine persönlichen Ziele? Wohin möchtest Du dich entwickeln? Unternehmen möchten genau verstehen, ob du zu ihnen bzw. zu der Stelle passt.\n" +
                    " \n" +
                    "Warum bist du gerade an diesem Unternehmen interessiert?\n" ,
                    "\n" +
                    "Wir empfehlen dir, dein Interesse an dem Unternehmen als Arbeitgeber möglichst genau zu beschreiben. Warum möchtest du gerade dort arbeiten? Worin unterscheidet sich dieses Unternehmen von anderen Unternehmen? Füge einen weiteren Satz ein, wenn du noch weitere Argumente nennen möchtest.\n" +
                    " \n" +
                    "Warum glaubst du, dass du zum Unternehmen passt?\n" +
                    "\n" +
                    "Wir empfehlen dir, deinen Beweggrund möglichst genau zu beschreiben. Gab es besondere Ereignisse oder Kommentare, die deinen Eindruck geprägt haben? Wo genau verfolgst du das Unternehmen? Füge einen weiteren Satz ein, wenn du noch weitere Argumente nennen möchtest.\n" +
                    "BEWERBUNG\n" +
                    "Musterfirma GmbH\n" ,
                    "z.Hd. Frau Musterfrau\n" +
                    "Musterstraße 1\n" +
                    "12345 Musterstadt\n" +
                    "Max Muster\n" +
                    "Musterstraße 1\n" +
                    "12345 Musterstadt\n" +
                    "0123 / 456 789\n" +
                    "email@domain.de\n" +
                    "9. November 2016\n" +
                    "Bewerbung auf die Stelle als Mustermitarbeiter\n" +
                    "\n" +
                    "Sehr geehrte Damen und Herren,\n" +
                    "mit großem Interesse bin ich im XING Stellenmarkt auf die ausgeschriebene Position aufmerksam geworden. Aus diesem Grund bewerbe ich mich bei Ihnen als Musterstelle (m/w) in Festanstellung.\n" +
                    "Zurzeit arbeite ich als Musterberuf bei Musterfirma. Zu meinen wichtigsten Aufgaben gehören hierbei die Einarbeitung in neue Produkte, die Durchführung von Verkaufsgesprächen und die Erstellung und Weitergabe von Bestellungen.\n" +
                    "Ihr Stellenangebot hört sich toll an! Ich hoffe, mir hierdurch persönliche und fachliche Entwicklungsmöglichkeiten erschließen zu können. Ihre Ausrichtung und das Image in dieser Branche gefallen mir besonders gut, daher sehe ich Sie als einen sehr interessanten Arbeitgeber an. In den Medien habe ich Ihre Entwicklung schon lange verfolgt und glaube daher, auch gut ins Unternehmen zu passen.\n" +
                    "SEITE1/2\n" +
                    "In eine neue Aufgabe bei Ihnen kann ich verschiedene Stärken einbringen. So bin ich meine Aufgaben sehr zuverlässig, verantwortungsbewusst und präzise angegangen. Mit mir gewinnt Ihr Unternehmen einen Mitarbeiter, der flexibel, motiviert und teamorientiert ist. Außerdem habe ich in früheren Projekten insbesondere ausgeprägte Kommunikationsstärke, hohe Lernbereitschaft und viel Kreativität unter Beweis stellen können.\n" +
                    "Konnte ich Sie mit dieser Bewerbung überzeugen? Ich bin für einen Einstieg zum nächstmöglichen Zeitpunkt verfügbar. Einen vertiefenden Eindruck gebe ich Ihnen gerne in einem persönlichen Gespräch. Ich freue mich über Ihre Einladung!\n" +
                    "Mit freundlichen Grüßen\n" +
                    "Dummy unterschrift\n" +
                    "Max Muster, Musterstadt den 29.10.2016\n",
//            "Apllication Text 1",
//            "Apllication Text 2",
//            "Apllication Text 3",
//            "Apllication Text 4",
//            "Apllication Text 5",
//            "Apllication Text 6",
    };
}
