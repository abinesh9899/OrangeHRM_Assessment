
package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        LoginPage login = new LoginPage(driver);

        login.login("Admin", "admin123");

        Assert.assertTrue(
            login.isDashboardVisible(),
            "Dashboard is not displayed"
        );
    }
}