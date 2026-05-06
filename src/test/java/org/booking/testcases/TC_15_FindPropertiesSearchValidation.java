package org.booking.testcases;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_15_FindPropertiesSearchValidation extends BaseTest {

    @Test
    public void verifyFindPropertiesTriggersSearchResults() throws IOException {
        Log.info("Test started: Verify Find Properties triggers search results");

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

        Log.info("Clicking search (Find Properties)");
        hp.search();
        HotelSearchPage hsp = new HotelSearchPage(driver);

        Log.info("Applying Vacation Homes filter");
        hsp.clickVacationHomesOption();

        Log.info("Applying Hotels filter");
        hsp.clickHotelsOption();

        Log.info("Applying Wonderful rating filter");
        hsp.clickWonderfulOption();

        Log.info("Entering smart filter: Elevator");
        hsp.enterSmartFilter(ExcelUtils.getCellData(1, 8));

        String actualText = hsp.getElevatorLabel().getText();
        Log.info("Captured smart filter label text: "+ actualText);
        Assert.assertEquals(
                actualText,
                "Elevator",
                "Elevator filter failed to apply"
        );
        Log.info("Validation successful: Elevator filter applied correctly");
        Log.info("Test completed");
        ScreenshotUtil.takeScreenshot(driver, "TC_15_FindPropertiesSearchValidation");
    }
}