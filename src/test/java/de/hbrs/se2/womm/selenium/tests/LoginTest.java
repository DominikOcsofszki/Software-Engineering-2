package de.hbrs.se2.womm.selenium.tests;
import de.hbrs.se2.womm.selenium.extra.AbstractPrepareTestSelenium;
import de.hbrs.se2.womm.selenium.extra.LOCATORS;
import de.hbrs.se2.womm.selenium.extra.LogoutPage;
import de.hbrs.se2.womm.selenium.pages.LoginPage;
public class LoginTest extends AbstractPrepareTestSelenium {
    LoginPage loginPage;
    LogoutPage logoutPages;
    @Override
    protected void setupPageBeforeEach() {
        loginPage = new LoginPage(driver, wait);
        loginPage.goToWebsiteAndWaitUntilTitlePresent();
    }
    void testLogin() {
        loginPage.login("seleniumtest", "seleniumtest");
        assert(driver.findElement(LOCATORS.LOGOUT_BUTTON).isDisplayed());
        if(driver.findElement(LOCATORS.LOGOUT_BUTTON).isDisplayed()){
            driver.findElement(LOCATORS.LOGOUT_BUTTON).click();
        }
    }
}
