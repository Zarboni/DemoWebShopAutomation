package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriverWait wait;

    // Locators
    private By totalPrice = By.cssSelector("td.cart-total-right span.product-price.order-total > strong");
    private By agreeToTerms = By.id("termsofservice");
    private By checkoutButton = By.cssSelector("button[name='checkout']");

    public CartPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait with a 10-second timeout
    }

    public double getTotalPrice() {
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice));
        String priceText = totalElement.getText().trim();
        return Double.parseDouble(priceText);
    }

    public void agreeToTermsAndConditions() {
        wait.until(ExpectedConditions.elementToBeClickable(agreeToTerms)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
