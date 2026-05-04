package org.booking.testcases.ranu;

// Test Case: Verify navigation of driver happening properly or not.

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;
import org.zigwheels.pages.PropertyDetailsPage;

public class TC_04_ValidateNavigation extends BaseTest {
    @Test
    public void verifyNavigationOfDriver(){
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        Assert.assertTrue(hp.startDate("4", "May", "2026"));
        hp.endDate("30", "June", "2026");
        hp.enterNumberOfAdults(4);
        hp.search();

        hsp.clickVacationHomesOption();
        hsp.clickHotelsOption();
        hsp.clickWonderfulOption();
        hsp.enterSmartFilter("Elevator");

        pdp.extractHolidayHomeDetails();
        Assert.assertTrue(hsp.checkPropertiesPageUrl(), "Invalid Navigation");
    }
}
