package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By billingAddressContinueButton = By.cssSelector("input.button-1.new-address-next-step-button[onclick='Billing.save()']");
    private By shippingAddressContinueButton = By.cssSelector("input.button-1.new-address-next-step-button[onclick='Shipping.save()']");
    private By shippingMethodContinueButton = By.cssSelector("input.button-1.shipping-method-next-step-button");
    private By paymentMethodContinueButton = By.cssSelector("input.button-1.payment-method-next-step-button");
    private By paymentInformationContinueButton = By.cssSelector("input.button-1.payment-info-next-step-button");
    private By confirmOrderButton = By.cssSelector("input.button-1.confirm-order-next-step-button");
    private By orderConfirmationMessage = By.cssSelector(".section.order-completed .title strong");
    private By orderNumber = By.cssSelector(".order-completed .order-number");
    private By continueButton = By.cssSelector(".order-completed-continue-button");
    private By paymentInfoText = By.cssSelector(".payment-info");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickContinueBillingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(billingAddressContinueButton)).click();
    }

    public void clickContinueShippingAddress() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingAddressContinueButton)).click();
    }

    public void selectShippingMethod(String method) {
        WebElement shippingOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'" + method + "')]/preceding-sibling::input")));
        shippingOption.click();
    }

    public void clickContinueShippingMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinueButton)).click();
    }

    public void selectPaymentMethod(String method) {
        WebElement paymentOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'" + method + "')]/preceding-sibling::input")));
        paymentOption.click();
    }

    public void clickContinuePaymentMethod() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinueButton)).click();
    }

    public String getPaymentInformation() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentInfoText)).getText();
    }

    public void clickContinuePaymentInformation() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentInformationContinueButton)).click();
    }

    public void confirmOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderButton)).click();
    }

    public String getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderConfirmationMessage)).getText();
    }

    public String getOrderNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber)).getText().trim();
    }

    public void clickContinue() {
        try {
            System.out.println("Attempting to click the Continue button using Selenium...");
            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
            System.out.println("Continue button clicked successfully using Selenium.");
        } catch (Exception e) {
            System.out.println("Selenium click failed. Using JavaScript as a fallback...");
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(continueButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            System.out.println("Continue button clicked using JavaScript.");
        }
    }
}
