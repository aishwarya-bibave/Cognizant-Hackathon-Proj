package org.booking.testcases.aniket;

import basetest.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigwheels.pages.HomePage;

public class TC_04_ValidateSearchButtonFunctionality extends BaseTest {
    @Test
    public void validateSearchButton(){
        HomePage hp = new HomePage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        hp.startDate("4", "May", "2026");
        hp.endDate("7", "May", "2026");
        hp.enterNumberOfAdults(2);
        hp.search();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(hp.isSearchResultsDisplayed(), "Search results are not displayed after clicking search button");
        sa.assertAll();
    }
}
