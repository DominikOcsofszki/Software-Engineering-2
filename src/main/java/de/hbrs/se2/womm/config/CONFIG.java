package de.hbrs.se2.womm.config;

import org.springframework.beans.factory.annotation.Value;

public class CONFIG {
    static public class DB {
        public static final String TEST =  "test";
        public static final String SE =  "se";
//        public static final String USING =  SE;
        @Value("${dbpick}")
        public static String dbpick;
        public static final String USING =  TEST;

    }
}
