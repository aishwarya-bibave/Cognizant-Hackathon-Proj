package org.booking.testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_20_ValidateSearchButtonFunctionality extends BaseTest {

    @Test
    public void validateSearchButton() throws IOException {
        HomePage hp = new HomePage(driver);
        Log.info("Starting test: Validate Search Button Functionality");

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

        SoftAssert sa = new SoftAssert();
        boolean resultsDisplayed = hp.isSearchResultsDisplayed();
        Log.info("Search results displayed: " + resultsDisplayed);

        sa.assertTrue(resultsDisplayed, "Search results are not displayed after clicking search button");
        Log.info("Assertion completed: Search results validation");

        sa.assertAll();
        Log.info("Soft assertions executed");
        ScreenshotUtil.takeScreenshot(driver, "TC_20_ValidateSearchButtonFunctionality");
    }
}
