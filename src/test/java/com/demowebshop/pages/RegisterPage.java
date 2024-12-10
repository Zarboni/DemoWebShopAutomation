package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // Locators
    private By firstNameInput = By.id("FirstName");
    private By lastNameInput = By.id("LastName");
    private By emailInput = By.id("Email");
    private By passwordInput = By.id("Password");
    private By confirmPasswordInput = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By registrationSuccessMessage = By.cssSelector("div.result");
    private By continueButton = By.cssSelector("input.button-1.register-continue-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(confirmPassword);
        driver.findElement(registerButton).click();
    }

    public String getRegistrationSuccessMessage() {
        return driver.findElement(registrationSuccessMessage).getText();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}
