package org.zigwheels.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

public class HotelSearchPage {

    private static final Logger log =
            LogManager.getLogger(HotelSearchPage.class);

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(),'Sort by')]")
    WebElement sortByOption;

    @FindBy(xpath = "//span[text()='Top reviewed']")
    WebElement topReviewOption;

    // Constructor
    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click on Sort By
    public void clickOnSortBy() {
        try {
            WaitUtils.waitForElementToBeClickable(driver, sortByOption);
            sortByOption.click();
            log.info("Clicked on Sort By option successfully");
        } catch (Exception e) {
            log.warn("Normal click failed for Sort By. Trying JavaScript click.", e);
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", sortByOption);
                log.info("Clicked on Sort By using JavaScript");
            } catch (Exception ex) {
                log.error("Unable to click Sort By option", ex);
            }
        }
    }

    // Click on Top Review
    public void clickOnTopReview() {
        try {
            WaitUtils.waitForElementToBeClickable(driver, topReviewOption);
            topReviewOption.click();
            log.info("Clicked on Top Review option successfully");
        } catch (Exception e) {
            log.warn("Normal click failed for Top Review. Trying JavaScript click.", e);
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", topReviewOption);
                log.info("Clicked on Top Review using JavaScript");
            } catch (Exception ex) {
                log.error("Unable to click Top Review option", ex);
            }
        }
    }
}
