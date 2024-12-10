package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DesktopsPage {

    private WebDriver driver;

    // Locators
    private By productTitles = By.cssSelector("h2.product-title > a");
    private By sortByDropdown = By.id("products-orderby");
    private By productPrices = By.cssSelector(".prices span");
    private By creationDates = By.cssSelector(".creation-date"); // Adjust selector if required

    public DesktopsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Click on an item by its name.
     *
     * @param itemName Name of the item to click.
     */
    public void clickOnItemByName(String itemName) {
        List<WebElement> items = driver.findElements(productTitles);
        for (WebElement item : items) {
            if (item.getText().trim().equalsIgnoreCase(itemName)) {
                item.click();
                return;
            }
        }
        throw new RuntimeException("Item with name '" + itemName + "' not found.");
    }

    /**
     * Get a list of item names displayed on the page.
     *
     * @return List of item names.
     */
    public List<WebElement> getItemTitles() {
        return driver.findElements(productTitles);
    }

    /**
     * Selects a sorting option from the Sort By dropdown.
     *
     * @param option The sorting option to select (e.g., "Name: A to Z").
     */
    public void selectSortOption(String option) {
        WebElement dropdown = driver.findElement(sortByDropdown);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }

    /**
     * Retrieves the prices of all desktop items on the page.
     *
     * @return A list of Doubles representing the item prices.
     */
    public List<Double> getItemPrices() {
        return driver.findElements(productPrices).stream()
                .map(element -> Double.parseDouble(element.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the creation dates of desktop items (if available).
     *
     * @return A list of Strings representing the item creation dates.
     */
    public List<String> getItemCreationDates() {
        return driver.findElements(creationDates)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
