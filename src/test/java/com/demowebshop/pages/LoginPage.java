package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By loginButton = By.cssSelector("input[value='Log in']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enter the email address into the email input field.
     *
     * @param email The email address to be entered.
     */
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    /**
     * Enter the password into the password input field.
     *
     * @param password The password to be entered.
     */
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    /**
     * Click the login button to log in to the application.
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    /**
     * Perform login by entering email, password, and clicking the login button.
     *
     * @param email    The email address to be entered.
     * @param password The password to be entered.
     * @return HomePage instance after a successful login.
     */
    public HomePage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        return new HomePage(driver);
    }
}
