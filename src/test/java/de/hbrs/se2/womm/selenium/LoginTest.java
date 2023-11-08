package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.pages.LogInPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends AbstractPrepareTestSelenium {
   LogInPage loginPage;

    public LoginTest() {
        super();
        this.loginPage = new LogInPage();
    }

    public void login() {
        loginPage.open();
        loginPage.loginField.sendKeys("admin");
        loginPage.pwField.sendKeys("admin");
        loginPage.loginButton.click();
    }


    @Test
    public void testLogin() {

        login();
    }


}