package de.hbrs.se2.womm.selenium.pages;

import de.hbrs.se2.womm.selenium.extra.AbstractPage;
import de.hbrs.se2.womm.selenium.extra.LOCATORS;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends AbstractPage {
    private WebDriver driver;
    private WebDriverWait wait;

    WebElement name;
    WebElement surname;
    WebElement username;
    WebElement email;
    WebElement password;
    WebElement confirmPassword;
    WebElement bday;
    WebElement location;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super("RegistrierungStudentView", ROUTING.ALL.RegistrierungStudentView);
        this.driver = driver;
        this.wait = wait;
    }

    public void goToWebsiteAndWaitUntilTitlePresent() {
        driver.get(getWebsiteUrl());
        wait.until(webDriver -> webDriver.getTitle().equals(getWebsiteTitle()));
    }
//    private void setUp() {
//        usernameField = driver.findElement(By.id("input-vaadin-text-field-6"));
//        passwordField = driver.findElement(By.id("input-vaadin-password-field-7"));
//        loginButton = driver.findElement(By.id("login-button")); //ToDo: ID ändern
//    }
//    private void setUp() {
//        name = driver.findElement(By.id("text-field-builder-1"));
//
//        name = driver.findElement(By.id(LOCATORS.));
//        surname = driver.findElement(By.id(LOCATORS.));
//        username = driver.findElement(By.id(LOCATORS.));
//        email = driver.findElement(By.id(LOCATORS.));
//        password = driver.findElement(By.id(LOCATORS.));
//        confirmPassword = driver.findElement(By.id(LOCATORS.));
//        bday = driver.findElement(By.id(LOCATORS.));
//        location = driver.findElement(By.id(LOCATORS.));
//    }

//
//    public void login(String username, String password) {
//        setUp();
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginButton.click();
//        wait.until(webDriver -> !(webDriver.getTitle().equals(getWebsiteTitle())));
//    }
}
