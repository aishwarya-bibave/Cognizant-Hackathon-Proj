package org.booking.testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;

import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_16_MaxAdultLimitVerify extends BaseTest {

    @Test
    public void verifyMaxAdultLimit() throws IOException {

        Log.info("Test started: Verify adult limit is not exceeded");
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
        boolean isLimitNotReached = hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));
        Log.info("Is adult limit NOT reached: "+ isLimitNotReached);
        Assert.assertTrue(
                isLimitNotReached,
                "FAIL: Adult limit was unexpectedly reached for valid input"
        );
        Log.info("Validation successful: Adult limit not reached for valid number");
        Log.info("Test completed successfully");
        ScreenshotUtil.takeScreenshot(driver, "TC_16_MaxAdultLimitVerify");
    }
}