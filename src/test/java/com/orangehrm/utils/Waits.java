package com.orangehrm.utils;

import com.orangehrm.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class Waits {
    private final WebDriverWait wait;
    public Waits(WebDriver driver) { wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(Config.timeout())); }
    public WebElement visible(By by) { return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); }
    public WebElement clickable(By by) { return wait.until(ExpectedConditions.elementToBeClickable(by)); }
    public void click(By by) { clickable(by).click(); }
    public void text(By by, String value) { WebElement e = visible(by); e.clear(); e.sendKeys(value); }
    public boolean present(By by) {
        try { return wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed(); }
        catch (TimeoutException e) { return false; }
    }
}
