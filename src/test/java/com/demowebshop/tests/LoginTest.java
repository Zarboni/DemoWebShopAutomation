package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    @Test
    public void testUserLogin() {
        // Navigate to the Demo Web Shop homepage
        driver.get("https://demowebshop.tricentis.com/");

        // Initialize the HomePage and click the Login link
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        // Initialize the LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Retrieve email and password from the config properties file
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");

        // Enter the email and password in the login form
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        // Click the Login button to submit the form
        loginPage.clickLoginButton();

        // Verify that the user is logged in by checking the displayed email
        String loggedInUser = driver.findElement(By.cssSelector("a.account")).getText();
        Assert.assertEquals(loggedInUser, email, "Login failed or incorrect user displayed.");
    }
}
