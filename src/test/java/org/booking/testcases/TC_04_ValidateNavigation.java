package org.booking.testcases;
// Test Case: Verify navigation of driver happening properly or not.
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

public class TC_04_ValidateNavigation extends BaseTest {
    @Test
    public void verifyNavigationOfDriver() throws IOException {
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);

        Log.info("Starting test: Validate driver navigation");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity(ExcelUtils.getCellData(1, 0));
        Log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        Log.info("Start date selected: " + startDateSelected);

        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));
        Log.info("End date selected: 30 June 2026");

        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));
        Log.info("Entered number of adults: 4");

        hp.search();
        Log.info("Clicked search button");

        hsp.clickVacationHomesOption();
        Log.info("Clicked Vacation Homes filter");

        hsp.clickHotelsOption();
        Log.info("Clicked Hotels filter");

        hsp.clickWonderfulOption();
        Log.info("Clicked Wonderful filter");

        hsp.enterSmartFilter(ExcelUtils.getCellData(1, 8));
        Log.info("Entered Elevator in Smart Filters");

        pdp.extractHolidayHomeDetails();
        Log.info("Extracted holiday home details");

        Assert.assertTrue(hsp.checkPropertiesPageUrl(), "Invalid Navigation");
        Log.info("Assertion completed: Navigation to property details page verified");
        ScreenshotUtil.takeScreenshot(driver, "TC_04_ValidateNavigation");
    }
}
