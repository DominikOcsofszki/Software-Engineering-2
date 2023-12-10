package de.hbrs.se2.womm.selenium.using;
/***
 * Testklasse Selenium
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public abstract class AbstractPrepareTestSelenium {
    protected WebDriver driver;
    protected Logger logger = Logger.getLogger("");
    protected WebDriverWait wait;


    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    protected abstract void setupPage();

    @BeforeEach
    void setupTest() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        setupPage();
//        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(LandingPage.Locators.LOGIN_BUTTON));

    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


}