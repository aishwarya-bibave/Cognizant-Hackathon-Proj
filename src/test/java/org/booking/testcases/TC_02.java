package org.booking.testcases;
import org.testng.annotations.Test;


import basetest.BaseTest;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;
import utilities.WaitUtils;

public class TC_02 extends BaseTest {

        @Test
        public void verifySortByTopReview() throws InterruptedException {
            HomePage hp = new HomePage(driver);
            hp.closePop();
            Thread.sleep(1000);
            hp.searchCity("Nairobi");
            Thread.sleep(1000);
            hp.startDate("30", "May", "2026");
            Thread.sleep(1000);
            hp.endDate("30", "June", "2026");
            hp.enterNumberOfAdults(4);
            hp.search();
            // Create Page Object
            HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);

            // Click on Sort By
            hotelSearchPage.clickOnSortBy();
            WaitUtils.sleep(2000);

            // Click on Top Review
            hotelSearchPage.clickOnTopReview();
            WaitUtils.sleep(3000);
        }
}