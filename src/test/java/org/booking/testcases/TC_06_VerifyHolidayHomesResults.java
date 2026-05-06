package org.booking.testcases;
import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import org.booking.pages.PropertyDetailsPage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_06_VerifyHolidayHomesResults extends BaseTest {
    @Test
    public void verifyHolidayHomesResults() throws IOException {
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage bd = new PropertyDetailsPage(driver);

        Log.info("Starting test: Verify Holiday Homes results");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity(ExcelUtils.getCellData(1, 0));
        Log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        Log.info("Start date selected: " + startDateSelected);

        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));
        Log.info("End date selected: 7 May 2026");

        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(3, 7)));
        Log.info("Entered number of adults: 2");

        hp.search();
        Log.info("Clicked search button");

        hsp.clickVacationHomesOption();
        Log.info("Clicked Vacation Homes filter");

        SoftAssert sa = new SoftAssert();
        boolean propertiesDisplayed = bd.arePropertiesDisplayed();
        Log.info("Properties displayed: " + propertiesDisplayed);

        sa.assertTrue(propertiesDisplayed, "No properties displayed");

        boolean propertiesContainCity = bd.doPropertiesContainCity("Nairobi");
        Log.info("Properties contain city Nairobi: " + propertiesContainCity);

        sa.assertTrue(propertiesContainCity, "Holiday homes in Nairobi are not displayed for given dates");

        sa.assertAll();
        Log.info("Soft assertions executed");
        ScreenshotUtil.takeScreenshot(driver, "TC_06_VerifyHolidayHomesResults");
    }
}
