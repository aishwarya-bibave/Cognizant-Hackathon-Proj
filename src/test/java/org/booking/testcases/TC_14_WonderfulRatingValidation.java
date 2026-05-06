package org.booking.testcases;
import basetest.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_14_WonderfulRatingValidation extends BaseTest {

    @Test
    public void verifyWonderfulFilterShowsOnlyWonderfulHotels() throws IOException, InterruptedException {

        Log.info("Test started: Verify Wonderful rating filter");
        HomePage hp = new HomePage(driver);

        Log.info("Closing popup");
        hp.closePop();

        Log.info("Searching city: Nairobi");
        hp.searchCity(ExcelUtils.getCellData(1, 0));

        Log.info("Selecting start date: 30 May 2026");
        hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));

        Log.info("Selecting end date: 30 June 2026");
        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));

        Log.info("Entering number of adults: 4");
        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));

        Log.info("Clicking search button");
        hp.search();

        HotelSearchPage hsp = new HotelSearchPage(driver);

        Log.info("Applying Vacation Homes filter");
        hsp.clickVacationHomesOption();

        Log.info("Applying Hotels filter");
        hsp.clickHotelsOption();

        Log.info("Applying Wonderful rating filter");
        hsp.clickWonderfulOption();
        SoftAssert softAssert = new SoftAssert();

        Log.info("Validating review labels shown on search results");
        for (WebElement label : hsp.getReviewLabels()) {
            Thread.sleep(2000);
            String text = label.getText();
            Log.info("Review label found: "+ text);
            softAssert.assertTrue(
                    text.contains("Wonderful") || text.contains("Exceptional"),
                    "FAIL: Other review filter displayed -> " + text
            );
        }
        softAssert.assertAll();
        Log.info("All review labels validated successfully");
        Log.info("Test completed");
        ScreenshotUtil.takeScreenshot(driver, "TC_14_WonderfulRatingValidation");
    }
}