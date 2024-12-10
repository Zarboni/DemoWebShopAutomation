package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {

    private WebDriver driver;

    private By addToCartButton = By.cssSelector("input[value='Add to cart']");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void selectHDD(String hddOptionLabel) {
        driver.findElement(By.xpath("//label[contains(text(),'" + hddOptionLabel + "')]/preceding-sibling::input")).click();
    }

    public void selectProcessor(String processorOptionLabel) {
        driver.findElement(By.xpath("//label[contains(text(),'" + processorOptionLabel + "')]/preceding-sibling::input")).click();
    }
}
