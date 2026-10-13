
package com.orangehrm.tests;

import org.testng.annotations.Test;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.EmployeePage;

public class EmployeeTest extends BaseTest {

    @Test
    public void addEmployeeTest() {

        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");

        EmployeePage employee = new EmployeePage(driver);
        employee.addEmployee("John", "Peter");
    }
}