package org.booking.testcases.aniket;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.booking.pages.HomePage;
import utilities.Log;

public class TC_03_VerifySearchLocation extends BaseTest {

    @Test
    public void verifyValidSearchLocation(){
        HomePage hp = new HomePage(driver);

        Log.info("Starting test: Verify valid search location");

        hp.closePop();
        Log.info("Closed popup successfully");

        hp.searchCity("Nairobi");
        Log.info("Entered city: Nairobi");

        SoftAssert sa = new SoftAssert();
        boolean cityEnteredCorrectly = hp.isCityEnteredCorrectly("Nairobi");
        Log.info("City entered correctly: " + cityEnteredCorrectly);

        sa.assertTrue(cityEnteredCorrectly, "Search location is not valid");
        Log.info("Assertion completed: Search location validation");

        sa.assertAll();
        Log.info("Soft assertions executed");
    }
}
