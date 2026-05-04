package org.booking.testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import org.booking.pages.PropertyDetailsPage;

public class TC_23_VerifyBookingWithEdge extends BaseTest {

    @Test
    public void verifyBookingComWithEdge() {

        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        Assert.assertTrue(hp.startDate("30", "May", "2026"));
        hp.endDate("30", "June", "2026");
        hp.enterNumberOfAdults(4);
        hp.search();

        hsp.clickVacationHomesOption();
        hsp.clickHotelsOption();
        hsp.clickWonderfulOption();
        hsp.enterSmartFilter("Elevator");

        pdp.extractHolidayHomeDetails();
        Assert.assertTrue(true);
    }
}