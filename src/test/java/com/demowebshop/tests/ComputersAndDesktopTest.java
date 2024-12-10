package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputersAndDesktopTest extends BaseTest {

    /**
     * Test to verify navigation to the Desktops page.
     */
    @Test
    public void testNavigateToDesktops() {
        // Navigate to the Demo Web Shop homepage
        driver.get("https://demowebshop.tricentis.com/");

        // Initialize HomePage
        HomePage homePage = new HomePage(driver);

        // Click on the "Computers" tab in the navigation bar
        homePage.clickComputersTab();

        // Click on the "Desktops" link under the Computers category
        homePage.clickDesktopsLink();

        // Verify that the user is successfully navigated to the Desktops page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("desktops"), "Navigation to Desktops failed!");
    }
}
