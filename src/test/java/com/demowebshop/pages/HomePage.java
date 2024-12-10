package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By computersTab = By.linkText("Computers");
    private By desktopsLink = By.linkText("Desktops");
    private By shoppingCartLink = By.cssSelector("a[href='/cart']");
    private By loginLink = By.cssSelector("a.ico-login");
    private By registerLink = By.cssSelector("a.ico-register");
    private By userEmailDisplay = By.cssSelector("a.account");
    private By homeLogo = By.cssSelector(".header-logo");
    private By barNotification = By.id("bar-notification");
    private By customerOrdersLink = By.linkText("Orders");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click the "Computers" tab in the navigation menu.
     */
    public void clickComputersTab() {
        driver.findElement(computersTab).click();
    }

    /**
     * Click the "Desktops" link under the Computers category.
     */
    public void clickDesktopsLink() {
        driver.findElement(desktopsLink).click();
    }

    /**
     * Click the "Shopping Cart" link in the header.
     */
    public void clickShoppingCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the bar-notification to disappear if it exists
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(barNotification));
        } catch (Exception e) {
            System.out.println("Notification did not disappear in time, proceeding to click.");
        }

        driver.findElement(shoppingCartLink).click();
    }

    /**
     * Click the "Login" link in the navigation bar.
     *
     * @return LoginPage instance for chaining further actions.
     */
    public LoginPage clickLogin() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
    }

    /**
     * Click the "Register" link in the navigation bar.
     */
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    /**
     * Check if the user is logged in by verifying the presence of the user email display.
     *
     * @return True if the user is logged in, otherwise false.
     */
    public boolean isUserLoggedIn() {
        try {
            return driver.findElement(userEmailDisplay).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if the home page is displayed by verifying the presence of the logo.
     *
     * @return True if the home page is displayed, otherwise false.
     */
    public boolean isHomePageDisplayed() {
        return driver.findElement(homeLogo).isDisplayed();
    }

    /**
     * Click on the account button to navigate to the customer info page.
     */
    public void clickAccountButton() {
        driver.findElement(userEmailDisplay).click();
    }

    /**
     * Verify if the customer info page is displayed.
     *
     * @return True if the page is displayed, otherwise false.
     */
    public boolean isCustomerInfoPageDisplayed() {
        return driver.getCurrentUrl().contains("/customer/info");
    }

    /**
     * Click the "Orders" link in the customer info page.
     */
    public void clickOrdersLink() {
        driver.findElement(customerOrdersLink).click();
    }
}
