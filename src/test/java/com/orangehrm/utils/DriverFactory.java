package com.orangehrm.utils;

import com.orangehrm.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public final class DriverFactory {
    private static WebDriver driver;
    private DriverFactory() {}
    public static WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-notifications");
        if (Config.headless()) options.addArguments("--headless=new", "--window-size=1440,1000");
        driver = new ChromeDriver(options); // Selenium Manager resolves the driver automatically.
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        return driver;
    }
    public static WebDriver getDriver() { return driver; }
    public static void quitDriver() { if (driver != null) { driver.quit(); driver = null; } }
}
