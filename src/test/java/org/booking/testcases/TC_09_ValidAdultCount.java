package org.booking.testcases;
import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_09_ValidAdultCount extends BaseTest {

    @Test
    public void verifyValidAdultCount_Positive() throws IOException {

        Log.info("Starting TC_09_ValidAdultCount");

        SoftAssert softAssert = new SoftAssert();
        HomePage hp = new HomePage(driver);

        hp.closePop();
        Log.info("Popup closed successfully");

        hp.searchCity(ExcelUtils.getCellData(1, 0));
        Log.info("City entered: Nairobi");

        hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
        Log.info("Start date selected: 30 May 2026");

        hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));
        Log.info("End date selected: 5 June 2026");

        int adults = 4;
        Log.info("Attempting to select adult count: "+ adults);

        softAssert.assertTrue(adults >= 1 && adults <= 30, " Adult count must be between 1 and 30");

        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));
        Log.info("Adult count selected successfully: "+ adults);

        softAssert.assertAll();
        Log.info(" TC_09_ValidAdultCount completed successfully");
        ScreenshotUtil.takeScreenshot(driver, "TC_09_ValidAdultCount");
    }
}