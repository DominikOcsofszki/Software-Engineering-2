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
    WebElement buttonRegister;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super("RegistrierungStudentView", ROUTING.ALL.RegistrierungStudentView);
        this.driver = driver;
        this.wait = wait;
        goToWebsiteAndWaitUntilTitlePresent();
        setUp();

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
    private void setUp() {
//        name = driver.findElement(By.id("text-field-builder-1"));

        name = driver.findElement(LOCATORS.TEXT_FIELD_BUILDER_1);
        surname = driver.findElement(LOCATORS.TEXT_FIELD_BUILDER_2);
        username = driver.findElement(LOCATORS.TEXT_FIELD_BUILDER_3);
        email = driver.findElement(LOCATORS.EMAILFIELD_BUILDER_1);
        password = driver.findElement(LOCATORS.PASSWORDFIELD_BUILDER_1);
        confirmPassword = driver.findElement(LOCATORS.PASSWORDFIELD_BUILDER_2);
        bday = driver.findElement(LOCATORS.DATEPICKER_BUILDER_1);
        location = driver.findElement(LOCATORS.TEXT_FIELD_BUILDER_4);
        buttonRegister = driver.findElement(LOCATORS.BUTTON_BUILDER_1);


    }

    public void register(String name, String surname, String username, String email, String password, String confirmPassword, String bday, String location) {
        setUp();
        this.name.sendKeys(name);
        this.surname.sendKeys(surname);
        this.username.sendKeys(username);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(confirmPassword);
        this.bday.sendKeys(bday);
        this.location.sendKeys(location);
        this.buttonRegister.click();
        wait.until(webDriver -> !(webDriver.getTitle().equals(getWebsiteTitle())));
    }

//
//    public void login(String username, String password) {
//        setUp();
//        usernameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        loginButton.click();
//        wait.until(webDriver -> !(webDriver.getTitle().equals(getWebsiteTitle())));
//    }
}
