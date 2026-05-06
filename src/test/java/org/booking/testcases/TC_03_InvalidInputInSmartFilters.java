package org.booking.testcases;
// Test Case: Invalid Input in Smart Filters
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_03_InvalidInputInSmartFilters extends BaseTest {
    @Test
    public void enterSmartFilter() throws IOException {
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);

        Log.info("Starting test: Invalid input in Smart Filters");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity(ExcelUtils.getCellData(1, 0));
        Log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        Log.info("Start date selected: " + startDateSelected);

        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));
        Log.info("End date selected: 7 May 2026");

        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));
        Log.info("Entered number of adults: 4");

        hp.search();
        Log.info("Clicked search button");

        hsp.enterSmartFilter(ExcelUtils.getCellData(2, 8));
        Log.info("Entered invalid Smart Filter value: XYZ");

        boolean filterApplied = hsp.isSmartFilterApplied();
        Log.info("Smart filter applied status: " + filterApplied);

        Assert.assertFalse(filterApplied, "Smart Filter should not be applied for invalid input");
        Log.info("Assertion completed: Invalid Smart Filter was not applied");
        ScreenshotUtil.takeScreenshot(driver, "TC_03_InvalidInputInSmartFilters");
    }
}
