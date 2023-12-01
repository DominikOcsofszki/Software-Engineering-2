package de.hbrs.se2.womm.views.components.refactoring;

import java.util.HashMap;
import java.util.Map;

public class TranslateMap {
    public static Map<String, String> translateMap = new HashMap<>() {{
        put("buttonToShowMissingTranslated", "buttonToShowMissingTranslated");
        put("doSthTranslateMe", "doSthTranslateMe<-TranslationNeeded");
        put("doSth", "doSth<-TranslationNeeded");
        put("sthNew", "sthNew<-TranslationNeeded");
    }};


}
