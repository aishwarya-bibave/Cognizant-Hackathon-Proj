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

public class TC_11_VerifyNewWindowOpens extends BaseTest {

    @Test
    public void verifySeeAvailabilityClickWorks() {

        SoftAssert softAssert = new SoftAssert();
        boolean isPropertyDetailsOpened = true;

        Log.info("===== TEST STARTED: Verify See Availability Opens Property Details =====");

        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);
        try {
            Log.info("Closing popup if present");
            hp.closePop();

            Log.info("Entering city: Nairobi");
            hp.searchCity(ExcelUtils.getCellData(1, 0));

            Log.info("Selecting travel dates");
            hp.startDate(ExcelUtils.getCellData(1, 1), ExcelUtils.getCellData(1, 2), ExcelUtils.getCellData(1, 3));
            hp.endDate(ExcelUtils.getCellData(1, 4), ExcelUtils.getCellData(1, 5), ExcelUtils.getCellData(1, 6));

            Log.info("Selecting number of adults");
            hp.enterNumberOfAdults(Integer.parseInt(ExcelUtils.getCellData(1, 7)));

            Log.info("Clicking search button");
            hp.search();

            Log.info("Applying Hotels filter");
            hsp.clickHotelsOption();

            Log.info("Applying Vacation Homes filter");
            hsp.clickVacationHomesOption();

            Log.info("Applying Wonderful filter");
            hsp.clickWonderfulOption();

            Log.info("Applying Smart Filter: Elevator");
            hsp.enterSmartFilter(ExcelUtils.getCellData(1, 8));

            Log.info("Clicking 'See Availability' and opening property details");
            pdp.extractHolidayHomeDetails();

            Log.info(" See Availability click worked and property details were opened");
        } catch (Exception e) {
            isPropertyDetailsOpened = false;
            Log.error(" Failed while clicking See Availability or opening property details", e);
        }
        //  Soft assertion based on EXECUTION SUCCESS
        softAssert.assertTrue(
                isPropertyDetailsOpened,
                "See Availability click failed or property details did not open"
        );
        Log.info("===== TEST COMPLETED: Verify See Availability Opens Property Details =====");
        softAssert.assertAll();
        ScreenshotUtil.takeScreenshot(driver, "TC_11_VerifyNewWindowOpens");
    }
}