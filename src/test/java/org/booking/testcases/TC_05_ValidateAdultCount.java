package org.booking.testcases;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_05_ValidateAdultCount extends BaseTest {

    @Test
    public void validateAdults() throws IOException {
        HomePage hp = new HomePage(driver);

        Log.info("Starting test: Validate adult count");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity(ExcelUtils.getCellData(1, 0));
        Log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        Log.info("Start date selected: " + startDateSelected);

        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));
        Log.info("End date selected: 7 May 2026");

        boolean adultCountValid = hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(2, 7)));
        Log.info("Adult count valid: " + adultCountValid);

        Assert.assertFalse(adultCountValid, "Adult count should not be valid when set to 0");
        Log.info("Assertion completed: Adult count validation passed");
        ScreenshotUtil.takeScreenshot(driver, "TC_05_ValidateAdultCount");
    }
}
