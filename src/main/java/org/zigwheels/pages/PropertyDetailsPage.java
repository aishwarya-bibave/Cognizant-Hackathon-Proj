package org.zigwheels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyDetailsPage {
    private WebDriver driver;

    @FindBy (xpath = "//span[normalize-space()='Sort by:']")
    private WebElement sortButton;

    @FindBy (xpath = "//span[normalize-space()='Top reviewed']")
    private WebElement topReview;

    @FindBy(xpath = "//div[normalize-space()='East of Eden']")
    private WebElement Hotel;

    public PropertyDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void goToHotel() throws InterruptedException {
        sortButton.click();
        Thread.sleep(1000);
        topReview.click();
        Hotel.click();
    }
}
