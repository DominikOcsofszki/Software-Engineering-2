package de.hbrs.se2.womm.views.layouts;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class STYLE_ASSETS {

    public static final String Primary = StyleGuide.PrimaryFormats.blue;
    public static final String Success = StyleGuide.PrimaryFormats.green;
    public static final String Error = StyleGuide.PrimaryFormats.red;
    public static final String Font = StyleGuide.OpenSanse.Avenir;
//    public static final StyleGuide.Vaadin_Icon_Collection Vaadin_Icon_Collection = new StyleGuide.Vaadin_Icon_Collection();
//    public static final StyleGuide.Font Font = new StyleGuide.Font();

    class StyleGuide {

        public static class DefaultVaadinIconCollection {
            public static final String xBlue = "vaadin:xxx"; //ToDo
            public static final String checkGreen = "vaadin:xxx"; //ToDo
            public static final String xRed = "vaadin:xxx"; //ToDo
            public static final String Glocke = "vaadin:xxx"; //ToDo
            public static final String Person = "vaadin:xxx"; //ToDo
            public static final String GitBranch = "vaadin:xxx"; //ToDo
            public static final String Pending = "vaadin:xxx"; //ToDo
            public static final String Confirmed = "vaadin:xxx"; //ToDo
            public static final String Denied = "vaadin:xxx"; //ToDo
            public static final String On_Hold = "vaadin:xxx"; //ToDo
        }

        public static class DefaultIconWommCollection {
            public static final String LogoText = ""; //ToDo
            public static final String LogoPerson = ""; //ToDo
            public static final String LogoWork = ""; //ToDo
        }

        public static class PrimaryFormats {
            public static final String black = "#192434";
            public static final String grey = "#C4CBD3";
            public static final String blue = "1676F3";
            public static final String green = "15C15D";
            public static final String red = "FF4338";
        }

        public static class OpenSanse {
            public static final String Avenir = "Avenir Next LT Pro";
        }

        public static class Shade {
            public static final int Shade_5 = 5;
            public static final int Shade_10 = 10;
            public static final int Shade_20 = 20;
            public static final int Shade_30 = 30;
            public static final int Shade_40 = 40;
            public static final int Shade_50 = 50;
            public static final int Shade_60 = 60;
            public static final int Shade_70 = 70;
            public static final int Shade_80 = 80;
            public static final int Shade_90 = 90;
            public static final int Shade_100 = 100;
        }


        public static class Vaadin_Icon_Collection {
            public static final String Vaadin_Icon_Collection_1 = "";
            public static final String Vaadin_Icon_Collection_2 = "";
            public static final String Vaadin_Icon_Collection_3 = "";
            public static final String Vaadin_Icon_Collection_4 = "";
            public static final String Vaadin_Icon_Collection_5 = "";
        }

        public static class Font {
            public static final String Font_1 = "";
            public static final String Font_2 = "";
            public static final String Font_3 = "";
            public static final String Font_4 = "";
            public static final String Font_5 = "";
        }
    }
}

//    public static Icon Vaadin_Icon_Collection_1() {
//        Icon icon = new Icon(VaadinIcon.CHECK);
//        icon.setColor(StyleGuide.PrimaryFormats.green);
//        return icon;
//    }