package de.hbrs.se2.womm.selenium;

import de.hbrs.se2.womm.selenium.using.AbstractPage;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

class RegisterPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;
    WebElement usernameField;
    WebElement passwordField;
    WebElement loginButton;
    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super("LoginView", ROUTING.ALL.LoginView);
        this.driver = driver;
        this.wait = wait;
    }

    public void goToWebsiteAndWaitUntilTitlePresent() {
        driver.get(getWebsiteUrl());
        wait.until(webDriver -> webDriver.getTitle().equals(getWebsiteTitle()));
    }
    private void setUp() {
        usernameField = driver.findElement(By.id("input-vaadin-text-field-6"));
        passwordField = driver.findElement(By.id("input-vaadin-password-field-7"));
        loginButton = driver.findElement(By.id("login-button")); //ToDo: ID ändern
    }


    public void login(String username, String password) {
        setUp();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        wait.until(webDriver -> !(webDriver.getTitle().equals(getWebsiteTitle())));
    }
}
