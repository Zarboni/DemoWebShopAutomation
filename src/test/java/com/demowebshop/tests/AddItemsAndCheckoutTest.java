package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemsAndCheckoutTest extends BaseTest {

    @Test
    public void testAddItemsAndCompleteCheckout() {
        driver.get("https://demowebshop.tricentis.com/");
        HomePage homePage = new HomePage(driver);

        // Login
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(properties.getProperty("email"), properties.getProperty("password"));

        Assert.assertTrue(homePage.isUserLoggedIn(), "Login failed!");

        // Navigate to Desktops and add the items
        homePage.clickComputersTab();
        homePage.clickDesktopsLink();

        DesktopsPage desktopsPage = new DesktopsPage(driver);
        desktopsPage.clickOnItemByName("Build your own cheap computer");
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCart();
        driver.navigate().back();

        desktopsPage.clickOnItemByName("Build your own computer");
        itemPage.selectHDD("320 GB");
        itemPage.clickAddToCart();
        driver.navigate().back();

        desktopsPage.clickOnItemByName("Build your own expensive computer");
        itemPage.clickAddToCart();
        driver.navigate().back();

        desktopsPage.clickOnItemByName("Simple Computer");
        itemPage.selectProcessor("Slow");
        itemPage.clickAddToCart();

        // Check the cart total
        homePage.clickShoppingCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getTotalPrice(), 4695.00, "Cart total mismatch!");

        // Proceed to checkout
        cartPage.agreeToTermsAndConditions();
        cartPage.proceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.clickContinueBillingAddress();
        checkoutPage.clickContinueShippingAddress();
        checkoutPage.selectShippingMethod("Ground");
        checkoutPage.clickContinueShippingMethod();
        checkoutPage.selectPaymentMethod("Cash On Delivery");
        checkoutPage.clickContinuePaymentMethod();

        Assert.assertTrue(checkoutPage.getPaymentInformation().contains("You will pay by COD"), "Incorrect payment info!");

        checkoutPage.clickContinuePaymentInformation();
        checkoutPage.confirmOrder();

        // Capture order number
        Assert.assertTrue(checkoutPage.getOrderConfirmationMessage().contains("successfully processed"), "Order failed!");
        String expectedOrderNumber = checkoutPage.getOrderNumber();
        checkoutPage.clickContinue();

        Assert.assertTrue(homePage.isHomePageDisplayed(), "Home page navigation failed!");

        // Validate the order on the Customer Orders page
        homePage.clickAccountButton();
        homePage.clickOrdersLink();

        CustomerOrdersPage customerOrdersPage = new CustomerOrdersPage(driver);
        Assert.assertTrue(customerOrdersPage.isOrderDisplayed(), "Orders not displayed!");
        Assert.assertEquals(customerOrdersPage.getLatestOrderNumber(), expectedOrderNumber, "Order number mismatch!");
    }
}
