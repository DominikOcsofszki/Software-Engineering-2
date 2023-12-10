package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.using.AbstractPage;
import de.hbrs.se2.womm.selenium.using.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class LandingPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LandingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickLogin() {
        WebElement loginButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(Locators.BUTTON_BUILDER_2)
        );
//        driver.findElement(Locators.BUTTON_BUILDER_2).click();
        loginButton.click();
    }
}
