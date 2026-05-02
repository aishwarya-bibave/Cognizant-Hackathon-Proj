package org.booking.testcases.ranu;

import basetest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.zigwheels.pages.HomePage;

public class TC_01_EmptySearchCityInput extends BaseTest {
    @Test
    public void searchCity(){
        HomePage hp = new HomePage(driver);

        hp.closePop();
        hp.searchCity("");
        hp.search();

        Assert.assertTrue(hp.showSearchCityValidationMsg(), "City is entered");
    }
}
