package org.booking.testcases;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import org.booking.pages.PropertyDetailsPage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_13_VerifyHolidayHomesTitleIsDisplayed extends BaseTest {

    @Test
    public void verifyHolidayHomeTitleDisplayed() throws IOException {
        Log.info("===== TEST STARTED: Verify Holiday Home Title Is Displayed =====");

        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);

        boolean isTitleExtractionSuccessful = true;

        Log.info("Closing popup if present");
        hp.closePop();

        Log.info("Entering city: Nairobi");
        hp.searchCity(ExcelUtils.getCellData(1, 0));

        Log.info("Selecting travel dates");
        hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));

        Log.info("Selecting number of adults");
        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));

        Log.info("Clicking Search");
        hp.search();

        Log.info("Applying filters: Hotels, Vacation Homes, Wonderful");
        hsp.clickHotelsOption();
        hsp.clickVacationHomesOption();
        hsp.clickWonderfulOption();

        Log.info("Entering Smart Filter: Elevator");
        hsp.enterSmartFilter(ExcelUtils.getCellData(1, 8));
        try {
            Log.info("Navigating to property details and extracting titles");
            pdp.extractHolidayHomeDetails();
            Log.info(" Holiday Home titles were successfully displayed and logged");
        } catch (Exception e) {
            isTitleExtractionSuccessful = false;
            Log.error(" Failed while extracting Holiday Home titles", e);
        }
        //  Added assertion
        Assert.assertTrue(
                isTitleExtractionSuccessful,
                "Holiday Home titles were not displayed or extracted successfully"
        );
        Log.info("===== TEST COMPLETED: Verify Holiday Home Title Is Displayed =====");
        ScreenshotUtil.takeScreenshot(driver, "TC_13_VerifyHolidayHomesTitleIsDisplayed");
    }
}