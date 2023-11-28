package tools.collection;

import java.util.Random;

public class BenachrichtigungText {


    public static String getRandomText() {
        return getRandomNrStellenauschreibungen();
    }
    private static String getRandomNrStellenauschreibungen() {
        int randomInt = new Random().nextInt(0, 10);
        return randomInt + " Neue Stellenausschreibung verfügbar!";
    }


}
