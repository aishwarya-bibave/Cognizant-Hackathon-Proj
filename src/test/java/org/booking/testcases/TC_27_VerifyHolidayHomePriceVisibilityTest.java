package org.booking.testcases;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.PropertyDetailsPage;
import utilities.Log;

public class TC_27_VerifyHolidayHomePriceVisibilityTest extends BaseTest {
    @Test
    public void run(){
        PropertyDetailsPage page = new PropertyDetailsPage(driver);

        HomePage hp = new HomePage(driver);
        hp.closePop();
        hp.searchCity("Nairobi");
        hp.startDate("30", "May", "2026");
        hp.endDate("30", "June", "2026");
        hp.enterNumberOfAdults(4);
        hp.search();

        Assert.assertTrue(
                page.verifyPriceIsDisplayedForFirstFiveHomes(),
                "Price is not displayed for one or more holiday homes"
        );

        Log.info("Price is displayed for all first five holiday homes");
    }

}
