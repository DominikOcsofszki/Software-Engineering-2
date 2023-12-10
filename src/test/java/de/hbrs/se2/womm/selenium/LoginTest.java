package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.using.AbstractPrepareTestSelenium;
import de.hbrs.se2.womm.selenium.using.LogoutPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends AbstractPrepareTestSelenium {
    LoginPage loginPage;
    LogoutPage logoutPages;

    @Override
    protected void setupPageBeforeEach() {
        loginPage = new LoginPage(driver, wait);
//        this.logoutPages = new LogoutPages(driver);
        loginPage.goToWebsiteAndWaitUntilTitlePresent();
    }

    @Test
    void testTitle() {
        // Exercise
        String title = driver.getTitle();
        logger.info(title);
        // Verify
        assert(title.equals("LoginView"));
    }

    @Test
    void testLogin() {
        // Exercise
        String title = driver.getTitle();
        logger.info(title);
//        wait.until(d -> d.getTitle().equals("xxx"));
        assert(title.equals(loginPage.getWebsiteTitle()));

//        loginPage.login("student2", "student");
        assert (!driver.getTitle().equals(loginPage.getWebsiteTitle()));
        // Verify
        //DoDo
//        logoutPages.logout();
    }



}
