package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.using.AbstractPrepareTestSelenium;
import org.junit.jupiter.api.Test;

public class LandingPageTest extends AbstractPrepareTestSelenium {
    LandingPage landingPage;
    @Override
    protected void setupPage() {
        this.landingPage = new LandingPage(driver, wait);
    }

    @Test
    void testLanding() {
        // Exercise
        driver.get("http://localhost:8080/vaadin/LandingPageView");

        String title = driver.getTitle();
        logger.info(title);
        // Verify
        landingPage.clickLogin();
        wait.until(
                webDriver -> webDriver.getTitle().equals("Login")
        );
    }
}
