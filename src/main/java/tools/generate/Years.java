package tools.generate;

import java.util.Random;

public class Years {
    public static String randomGruendung() {
        int rand = (new Random().nextInt(1850, 2023));
        return String.valueOf(rand);
    }
}
