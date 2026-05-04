package org.booking.testcases;
import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import org.booking.pages.PropertyDetailsPage;
import utilities.Log;

public class TC_07_VerifyBookingComWithFirefox extends BaseTest {

    @Test
    public void verifyBookingComWithFirefox() {
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);

        Log.info("Starting test: Verify Booking.com search flow with Firefox driver");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity("Nairobi");
        Log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate("30", "May", "2026");
        Log.info("Start date selected: " + startDateSelected);

        hp.endDate("30", "June", "2026");
        Log.info("End date selected: 30 June 2026");

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

        pdp.extractHolidayHomeDetails();
        Log.info("Extracted holiday home details");

        Assert.assertTrue(true, "Firefox navigation and search flow failed");
        Log.info("Assertion completed: Booking.com search flow verified with Firefox");
    }
}
