package org.booking.testcases;
// Test case: Verify All filters are applied or not
import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import utilities.Log;

public class TC_02_VerifyAllFiltersApplied extends BaseTest {

    @Test
    public void verifyFiltersApplied(){
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);

        Log.info("Starting test: Verify all filters applied");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity("Nairobi");
        Log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate("4", "May", "2026");
        Log.info("Start date selected: " + startDateSelected);

        hp.endDate("7", "May", "2026");
        Log.info("End date selected: 7 May 2026");

        hp.enterNumberOfAdults(4);
        Log.info("Entered number of adults: 4");

        hp.search();
        Log.info("Clicked search button");

        hsp.clickVacationHomesOption();
        Log.info("Clicked Vacation Homes filter");

        hsp.clickHotelsOption();
        Log.info("Clicked Hotels filter");

        hsp.clickWonderfulOption();
        Log.info("Clicked Wonderful filter");

        hsp.enterSmartFilter("Elevator");
        Log.info("Entered Elevator in Smart Filters");

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(hsp.isWonderfulFilterApplied(), "Wonderful filter is not applied");
        sa.assertTrue(hsp.isVacationHomesFilterApplied(), "Vacation Homes filter is not applied");
        sa.assertTrue(hsp.isHotelsFilterApplied(), "Hotels filter is not applied");
        sa.assertTrue(hsp.isElevatorFilterApplied(), "Elevator filter is not applied");
        sa.assertAll();

        Log.info("All filter assertions completed");
    }
}
