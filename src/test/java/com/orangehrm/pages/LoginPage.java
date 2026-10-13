
package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By username = By.name("username");
    By password = By.name("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By dashboard = By.xpath("//h6[text()='Dashboard']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }

    public boolean isDashboardVisible() {
        return driver.findElement(dashboard).isDisplayed();
    }

    public void logout() {
        driver.findElement(
            By.className("oxd-userdropdown-tab")
        ).click();

        driver.findElement(
            By.xpath("//a[text()='Logout']")
        ).click();
    }
}