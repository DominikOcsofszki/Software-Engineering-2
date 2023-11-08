package de.hbrs.se2.womm.selenium.pages;

import de.hbrs.se2.womm.selenium.AbstractPrepareTestSelenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInPage extends AbstractPrepareTestSelenium {
    public WebElement loginField;
    public WebElement pwField;
    public WebElement menuButton;
    public WebElement loginButton;

    public String url = "http://localhost:8080/login";
    public LogInPage() {
        super();
        this.loginField = this.getDriver().findElement(By.id("input-vaadin-text-field-6"));
        this.pwField = this.getDriver().findElement(By.id("input-vaadin-password-field-7"));
        this.menuButton = this.getDriver().findElement(By.className("vaadin-drawer-toggle"));
        this.loginButton = this.getDriver().findElement(By.className("vaadin-button-container"));
    }

    public void open() {
        this.getDriver().get(url);
    }





}