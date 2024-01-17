package de.hbrs.se2.womm;

import com.vaadin.flow.component.page.*;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@PWA(name = "Womm Application", shortName = "womm-app")
@Viewport("width=device-width, initial-scale=1")
@BodySize(height = "100vh", width = "100vw")
@Theme(value="womm-theme")
@SpringBootApplication
public class WommApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(WommApplication.class, args);
    }

}
