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
    void testLogin() {
        // Exercise
        String title = driver.getTitle();
        logger.info(title);
        loginPage.login("student2", "student");
        // Verify
        //DoDo
//        logoutPages.logout();
    }
    @Test
    void testTitle() {
        // Exercise
        String title = driver.getTitle();
        logger.info(title);
        // Verify
        assert(title.equals("LoginView"));
    }


}
