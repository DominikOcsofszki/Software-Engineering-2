package de.hbrs.se2.womm.selenium.tests;

import de.hbrs.se2.womm.selenium.extra.AbstractPrepareTestSelenium;
import de.hbrs.se2.womm.selenium.pages.LoginPage;
import de.hbrs.se2.womm.selenium.pages.RegisterPage;
import org.junit.jupiter.api.Test;

public class RegisterTest extends AbstractPrepareTestSelenium {
    RegisterPage registerPage;

    @Override
    protected void setupPageBeforeEach() {
        registerPage = new RegisterPage(driver, wait);
    }

    @Test
    public void testRegister() {
        registerPage.register("aDom", "ocs", "c", "d@dom.de", "e", "e", "", "g");

    }
}
