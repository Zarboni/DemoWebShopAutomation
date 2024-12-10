package com.demowebshop.tests;

import com.demowebshop.base.BaseTest;
import com.demowebshop.pages.DesktopsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class DesktopSortingTest extends BaseTest {

    @Test
    public void testDesktopSortingByAllOptions() {
        driver.get("https://demowebshop.tricentis.com/desktops");
        DesktopsPage desktopsPage = new DesktopsPage(driver);

        // Define sorting options to test
        String[] sortingOptions = {
            "Name: A to Z",
            "Name: Z to A",
            "Price: Low to High",
            "Price: High to Low"
        };

        for (String option : sortingOptions) {
            desktopsPage.selectSortOption(option);

            // Capture item titles from the page
            List<WebElement> titleElements = desktopsPage.getItemTitles(); // Ensure getItemTitles() returns WebElement list
            List<String> itemTitles = titleElements.stream()
                    .map(WebElement::getText) // Extract text from each WebElement
                    .map(String::trim) // Trim whitespace
                    .collect(Collectors.toList());

            switch (option) {
                case "Name: A to Z":
                    // Validate sorting by Name: A to Z
                    List<String> sortedTitlesAtoZ = itemTitles.stream().sorted().collect(Collectors.toList());
                    assertEquals(itemTitles, sortedTitlesAtoZ, "Items are not sorted by Name: A to Z.");
                    break;

                case "Name: Z to A":
                    // Validate sorting by Name: Z to A
                    List<String> sortedTitlesZtoA = itemTitles.stream()
                            .sorted((a, b) -> b.compareTo(a))
                            .collect(Collectors.toList());
                    assertEquals(itemTitles, sortedTitlesZtoA, "Items are not sorted by Name: Z to A.");
                    break;

                case "Price: Low to High":
                    // Capture and validate prices sorted Low to High
                    List<Double> itemPricesLowToHigh = desktopsPage.getItemPrices();
                    List<Double> sortedPricesLowToHigh = itemPricesLowToHigh.stream().sorted().collect(Collectors.toList());
                    assertEquals(itemPricesLowToHigh, sortedPricesLowToHigh, "Items are not sorted by Price: Low to High.");
                    break;

                case "Price: High to Low":
                    // Capture and validate prices sorted High to Low
                    List<Double> itemPricesHighToLow = desktopsPage.getItemPrices();
                    List<Double> sortedPricesHighToLow = itemPricesHighToLow.stream()
                            .sorted((a, b) -> Double.compare(b, a))
                            .collect(Collectors.toList());
                    assertEquals(itemPricesHighToLow, sortedPricesHighToLow, "Items are not sorted by Price: High to Low.");
                    break;

                default:
                    throw new IllegalArgumentException("Unexpected sorting option: " + option);
            }
        }
    }
}
