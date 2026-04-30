package org.zigwheels.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
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
    JavascriptExecutor js;

    public HotelSearchPage(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Sort by')]")
    WebElement sortByOption;

    @FindBy(xpath = "//span[text()='Top reviewed']")
    WebElement topReviewOption;

    public void clickOnSortByDropDown() {
        try {
            WaitUtils.waitForElementToBeClickable(sortByOption);
            try{
                sortByOption.click();
                log.info("Clicked on Sort By option successfully");
            }catch(ElementClickInterceptedException e1){
                log.warn("Normal click failed for Sort By. Trying JavaScript click.", e1);
                js.executeScript("arguments[0].click();", sortByOption);
                log.info("Clicked on Sort By using JavaScript");
            }
        } catch (Exception e2) {
            log.error("Unable to click Sort By option", e2);
        }
    }

    public void clickOnTopReviewsOption() {
        try {
            WaitUtils.waitForElementToBeVisible(topReviewOption);
            WaitUtils.waitForElementToBeClickable(topReviewOption);
            try{
                topReviewOption.click();
                log.info("Clicked on Top Review option successfully");
            }catch(ElementClickInterceptedException e1){
                log.warn("Normal click failed for Top Review. Trying JavaScript click.", e1);
                js.executeScript("arguments[0].click();", sortByOption);
                log.info("Clicked on Sort By using JavaScript");
            }
        } catch (Exception e2) {
            log.error("Unable to click Top Review option", e2);
        }
    }
}
