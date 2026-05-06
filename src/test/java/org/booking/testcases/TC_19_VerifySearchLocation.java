package org.booking.testcases;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import utilities.ExcelUtils;
import utilities.Log;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_19_VerifySearchLocation extends BaseTest {

    @Test
    public void verifyValidSearchLocation() throws IOException {
        HomePage hp = new HomePage(driver);
        Log.info("Starting test: Verify valid search location");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity(ExcelUtils.getCellData(1, 0));
        Log.info("Entered city: Nairobi");

        SoftAssert sa = new SoftAssert();
        boolean cityEnteredCorrectly = hp.isCityEnteredCorrectly("Nairobi");
        Log.info("City entered correctly: " + cityEnteredCorrectly);

        sa.assertTrue(cityEnteredCorrectly, "Search location is not valid");
        Log.info("Assertion completed: Search location validation");

        sa.assertAll();
        Log.info("Soft assertions executed");
        ScreenshotUtil.takeScreenshot(driver, "TC_19_VerifySearchLocation");
    }
}
