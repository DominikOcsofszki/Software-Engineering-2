/***
 * Testklasse Selenium
 */
package de.hbrs.se2.womm;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class SeleniumTestLocalTest {
    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    // ToDo: Variable for localhost or tomcat(after it works)
    /*@Test
    void testLocal() {  //Run localy, if deployed on server, this test will fail
        // Exercise
        driver.get("http://localhost:8080");
        String title = driver.getTitle().toLowerCase();
        // Verify
        assertThat(title).contains("w.o.m.m");
    }*/
    @Test
    void testHBRS() {
        // Exercise
        driver.get("https://www.h-brs.de/en");
        String title = driver.getTitle().toLowerCase();
        // Verify
        assertThat(title).contains("h-brs");
    }
}