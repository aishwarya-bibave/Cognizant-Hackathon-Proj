package org.booking.testcases.aniket;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;
import org.zigwheels.pages.PropertyDetailsPage;

public class TC_06_VerifyHolidayHomesResults extends BaseTest {
    @Test
    public void verifyHolidayHomesResults(){
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage bd = new PropertyDetailsPage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        hp.startDate("4", "May", "2026");
        hp.endDate("7", "May", "2026");
        hp.enterNumberOfAdults(2);
        hp.search();

        hsp.clickVacationHomesOption();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(bd.arePropertiesDisplayed(), "No properties displayed");
        sa.assertTrue(bd.doPropertiesContainCity("Nairobi"), "Holiday homes in Nairobi are not displayed for given dates");
        sa.assertAll();
    }
}
