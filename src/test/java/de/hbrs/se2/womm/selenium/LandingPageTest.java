package de.hbrs.se2.womm.selenium;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LandingPageTest extends AbstractPrepareTestSelenium {

    @Test
    void testHBRS() {
        // Exercise
        driver.get("http://localhost:8080/vaadin/refactor");
        String title = "blabal";
//        String title = driver.getTitle();
        System.out.println(title);
//        String title = driver.getTitle().toLowerCase();
        // Verify
        assertThat(title).contains("LandingPageView");
    }

}
