package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomerOrdersPage {
    private WebDriver driver; // Keep for consistency
    private WebDriverWait wait;

    // Locators
    private By orderTable = By.cssSelector(".order-list");
    private By orderNumber = By.cssSelector(".order-list .order-number");

    public CustomerOrdersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Check if the orders table is displayed on the page.
     *
     * @return true if the order table exists, otherwise false
     */
    public boolean isOrderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderTable)).isDisplayed();
    }

    /**
     * Get the latest order number from the orders page.
     *
     * @return String of the latest order number.
     */
    public String getLatestOrderNumber() {
        List<WebElement> orderNumbers = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orderNumber));
        return orderNumbers.get(0).getText().trim();
    }
}
