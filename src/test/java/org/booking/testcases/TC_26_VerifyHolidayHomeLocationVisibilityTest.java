package org.booking.testcases;


import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.PropertyDetailsPage;
import utilities.Log;

public class TC_26_VerifyHolidayHomeLocationVisibilityTest extends BaseTest {

    @Test
    public void verifyHolidayHomeLocationForFirstFiveHomes() {

        Log.info("Test Case: Verify that the Holiday Home location is displayed for first five homes");


        PropertyDetailsPage propertyDetailsPage =
                new PropertyDetailsPage(driver);

        HomePage hp = new HomePage(driver);
        hp.closePop();
        hp.searchCity("Nairobi");
        hp.startDate("30", "May", "2026");
        hp.endDate("30", "June", "2026");
        hp.enterNumberOfAdults(4);
        hp.search();


        boolean isLocationDisplayed =
                propertyDetailsPage.verifyLocationDisplayedForFirstFiveHolidayHomes();


        Assert.assertTrue(
                isLocationDisplayed,
                "Location is not displayed for one or more of the first five holiday homes"
        );

        Log.info("Location displayed for all first five holiday homes");

    }
}
