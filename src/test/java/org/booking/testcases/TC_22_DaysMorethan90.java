package org.booking.testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import utilities.ExcelUtils;
import utilities.ScreenshotUtil;

import java.io.IOException;

public class TC_22_DaysMorethan90 extends BaseTest {

    @Test
    public void validateSearchButton() throws IOException {
        HomePage hp = new HomePage(driver);
        hp.closePop();
        hp.searchCity(ExcelUtils.getCellData(4, 0));
        Assert.assertTrue(hp.startDate(ExcelUtils.getCellData(4, 1), ExcelUtils.getCellData(4, 2), ExcelUtils.getCellData(4, 3)));
        hp.endDate(ExcelUtils.getCellData(4, 4), ExcelUtils.getCellData(4, 5), ExcelUtils.getCellData(4, 6));
        hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(4, 7)));
        hp.search();

        SoftAssert sa = new SoftAssert();
        sa.assertFalse(driver.getCurrentUrl().contains("searchresults"), "Search results are displayed after 90 days");
        sa.assertAll();
        ScreenshotUtil.takeScreenshot(driver, "TC_22_DaysMorethan90");
    }
}
