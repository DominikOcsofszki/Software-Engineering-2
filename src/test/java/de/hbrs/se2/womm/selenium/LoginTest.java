package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.using.AbstractPrepareTestSelenium;
import org.junit.jupiter.api.Test;

public class LoginTest extends AbstractPrepareTestSelenium {
    LoginPage loginPage;
    @Override
    protected void setupPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    void testLogin() {
        // Exercise
        driver.get("http://localhost:8080/vaadin/login");
        String title = driver.getTitle();
        logger.info(title);
        // Verify
//        loginPage.login("admin", "admin");
    }



}
