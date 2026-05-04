package org.booking.testcases.ranu;

// Test Case: Invalid Input in Smart Filters

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;

public class TC_03_InvalidInputInSmartFilters extends BaseTest {
    @Test
    public void enterSmartFilter(){
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        Assert.assertTrue(hp.startDate("4", "May", "2026"));
        hp.endDate("7", "May", "2026");
        hp.enterNumberOfAdults(4);
        hp.search();

        hsp.enterSmartFilter("XYZ");
        Assert.assertFalse(hsp.isSmartFilterApplied(), "Smart Filter Applied");
    }
}
