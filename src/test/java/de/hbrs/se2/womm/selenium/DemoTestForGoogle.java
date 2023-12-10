package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.using.AbstractPrepareTestSelenium;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DemoTestForGoogle extends AbstractPrepareTestSelenium {

    @Test
    void testHBRS() {
        // Exercise
//        driver.get("http://localhost:8080/vaadin/refactor");
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        logger.info("title: " + title);
        // Verify
        assertThat(title.toLowerCase()).contains("google");
    }


    @Override
    protected void setupPage() {
        // nothing to do
    }
}
