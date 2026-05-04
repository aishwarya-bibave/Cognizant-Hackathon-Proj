package org.booking.testcases.aishwarya;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Log;

public class TC_11_MaxAdultLimitVerify extends BaseTest {

    @Test
    public void verifyMaxAdultLimit() {

        Log.info("Test started: Verify adult limit is not exceeded");

        HomePage hp = new HomePage(driver);

        Log.info("Closing popup");
        hp.closePop();

        Log.info("Searching city: Nairobi");
        hp.searchCity("Nairobi");

        Log.info("Selecting start date: 30 May 2026");
        hp.startDate("30", "May", "2026");

        Log.info("Selecting end date: 30 June 2026");
        hp.endDate("30", "June", "2026");

        Log.info("Entering number of adults: 4");
        boolean isLimitNotReached = hp.enterNumberOfAdults(4);

        Log.info("Is adult limit NOT reached: "+ isLimitNotReached);

        Assert.assertTrue(
                isLimitNotReached,
                "FAIL: Adult limit was unexpectedly reached for valid input"
        );

        Log.info("Validation successful: Adult limit not reached for valid number");
        Log.info("Test completed successfully");
    }
}