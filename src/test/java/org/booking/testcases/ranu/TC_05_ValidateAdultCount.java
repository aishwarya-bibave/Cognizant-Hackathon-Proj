package org.booking.testcases.ranu;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.HomePage;

public class TC_05_ValidateAdultCount extends BaseTest {
    @Test
    public void validateAdults(){
        HomePage hp = new HomePage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        Assert.assertTrue(hp.startDate("4", "May", "2026"));
        hp.endDate("7", "May", "2026");
        Assert.assertFalse(hp.enterNumberOfAdults(0), "Adult Count is within the range");
    }
}
