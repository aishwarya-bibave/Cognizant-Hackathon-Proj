package org.booking.testcases.ranu;

// Test case: Verify All filters are applied or not

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;

public class TC_02_VerifyAllFiltersApplied extends BaseTest {
    @Test
    public void verifyFiltersApplied(){
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        Assert.assertTrue(hp.startDate("4", "May", "2026"));
        hp.endDate("7", "May", "2026");
        hp.enterNumberOfAdults(4);
        hp.search();

        hsp.clickVacationHomesOption();
        hsp.clickHotelsOption();
        hsp.clickWonderfulOption();
        hsp.enterSmartFilter("Elevator");

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(hsp.isWonderfulFilterApplied(), "Wonderful filter is not applied");
        sa.assertTrue(hsp.isVacationHomesFilterApplied(), "Vacation Homes filter is not applied");
        sa.assertTrue(hsp.isHotelsFilterApplied(), "Hotels filter is not applied");
        sa.assertTrue(hsp.isElevatorFilterApplied(), "Elevator filter is not applied");
        sa.assertAll();
    }
}
