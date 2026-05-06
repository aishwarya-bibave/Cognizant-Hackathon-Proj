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

public class TC_10_HotelOptionIsSelected extends BaseTest {

    @Test
    public void verifyHotelsOptionIsSelected() throws IOException {

        Log.info("===== TEST STARTED: Verify Hotels Option Selection =====");

        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);

        Log.info("Closing popup if present");
        hp.closePop();

        Log.info("Entering city: Nairobi");
        hp.searchCity(ExcelUtils.getCellData(1, 0));

        Log.info("Selecting travel dates");
        hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));

        Log.info("Selecting number of adults");
        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));

        Log.info("Clicking Search button");
        hp.search();

        Log.info("Attempting to select 'Hotels' filter option");
        hsp.clickHotelsOption();

        //  Hard assertion with log
        Assert.assertTrue(
                hsp.checkHotelsOption.isEnabled(),
                " Hotels option is NOT enabled or could not be selected"
        );
        Log.info(" Hotels option is enabled and successfully selected");
        Log.info("===== TEST COMPLETED: Verify Hotels Option Selection =====");
        ScreenshotUtil.takeScreenshot(driver, "TC_10_HotelOptionIsSelected");
    }
}