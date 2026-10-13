
package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage {

    WebDriver driver;

    By pimMenu = By.xpath("//span[text()='PIM']");
    By addButton = By.xpath("//button[text()=' Add ']");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By saveButton = By.xpath("//button[@type='submit']");
    By employeeList = By.xpath("//a[text()='Employee List']");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addEmployee(String first, String last) {

        driver.findElement(pimMenu).click();

        driver.findElement(addButton).click();

        driver.findElement(firstName).sendKeys(first);

        driver.findElement(lastName).sendKeys(last);

        driver.findElement(saveButton).click();
    }
}