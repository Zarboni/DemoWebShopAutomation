package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class to validate navigation functionality in the Demo Web Shop website.
 */
public class NavigationTest extends BaseTest {

    /**
     * Verifies that the user can navigate to the Desktops page from the homepage.
     */
    @Test
    public void testNavigateToDesktops() {
        // Open the Demo Web Shop homepage
        driver.get("https://demowebshop.tricentis.com/");

        // Initialize the HomePage object and perform navigation
        HomePage homePage = new HomePage(driver);
        homePage.clickComputersTab(); // Click on the "Computers" tab
        homePage.clickDesktopsLink(); // Click on the "Desktops" link

        // Verify the current URL contains "desktops" to ensure navigation was successful
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("desktops"), "Navigation to Desktops page failed!");
    }
}
