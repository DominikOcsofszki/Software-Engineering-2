package de.hbrs.se2.womm.selenium.tests;

import de.hbrs.se2.womm.selenium.extra.AbstractPrepareTestSelenium;
import de.hbrs.se2.womm.selenium.extra.LOCATORS;
import de.hbrs.se2.womm.selenium.pages.LoginPage;
import de.hbrs.se2.womm.selenium.pages.RegisterPage;

import java.security.SecureRandom;
import java.util.Random;

public class RegisterTest extends AbstractPrepareTestSelenium {
    RegisterPage registerPage;
    LoginPage loginPage;
    Random random = new SecureRandom();

    @Override
    protected void setupPageBeforeEach() {
        registerPage = new RegisterPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
    }

//    @Test
    public void testRegister() {
        long randomInt = random.nextLong(1_000_000_000);
        String name = "selenium"+randomInt;
        String surname = "test";
        String username = "seleniumtest"+randomInt;
        String email = "seleniumtest"+randomInt+"@web.de";
        String pw = "seleniumtest";
        String cP = "seleniumtest";
        String bday = "01.01.2000";
        String location = "world";
        registerPage.register(name, surname, username, email, pw, cP, bday, location);
    }
//    @Test
    public void testRegisterAndLogin() {
        long randomInt = random.nextLong(1_000_000_000);
        String name = "selenium"+randomInt;
        String surname = "test";
        String username = "seleniumtest"+randomInt;
        String email = "seleniumtest"+randomInt+"@web.de";
        String pw = "seleniumtest";
        String cP = "seleniumtest";
        String bday = "01.01.2000";
        String location = "world";
        registerPage.register(name, surname, username, email, pw, cP, bday, location);
        loginPage.login(username, pw);
        assert(driver.findElement(LOCATORS.LOGOUT_BUTTON).isDisplayed());

        if(driver.findElement(LOCATORS.LOGOUT_BUTTON).isDisplayed()){
            driver.findElement(LOCATORS.LOGOUT_BUTTON).click();
        }
    }
}
