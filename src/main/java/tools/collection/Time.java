package tools.collection;

import java.util.Date;
import java.util.Random;

public class Time {
    public static String randomGruendung() {
        int rand = (new Random().nextInt(1850, 2023));
        return String.valueOf(rand);
    }
    public static String randomGeburtstag() {
        int year = (new Random().nextInt(1950, 2000));
        int month = (new Random().nextInt(1, 12));
        int day = (new Random().nextInt(1, 28));
        return new Date(year, month, day).toString();
    }
    public static String randomSemester() {
        int rand = (new Random().nextInt(1, 20));
        return String.valueOf(rand);
    }
}
