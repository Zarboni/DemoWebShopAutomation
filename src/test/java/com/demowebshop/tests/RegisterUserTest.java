package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class RegisterUserTest extends BaseTest {

    @Test
    public void testUserRegistration() {
        // Generate a unique email
        String randomEmail = "testuser_" + UUID.randomUUID() + "@example.com";

        // Navigate to the website
        driver.get("https://demowebshop.tricentis.com/");
        
        // Navigate to the registration page
        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        // Complete the registration
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("Test", "User", randomEmail, "Password123", "Password123");

        // Assert that the registration was successful by checking the success message
        String expectedSuccessMessage = "Your registration completed";
        String actualSuccessMessage = registerPage.getRegistrationSuccessMessage();
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Registration success message is incorrect!");

        // Click the "Continue" button
        registerPage.clickContinueButton();

        // Assert that the user is redirected to the home page
        Assert.assertTrue(homePage.isHomePageDisplayed(), "Failed to redirect to the home page after registration!");

        // Optional: Print the email for debugging purposes
        System.out.println("Successfully registered with email: " + randomEmail);
    }
}
