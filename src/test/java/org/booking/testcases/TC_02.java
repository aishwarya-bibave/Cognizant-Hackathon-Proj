package org.booking.testcases;
import org.testng.annotations.Test;


import basetest.BaseTest;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;
import utilities.WaitUtils;

public class TC_02 extends BaseTest {

        @Test
        public void verifySortByTopReview(){
            HomePage hp = new HomePage(driver);
            hp.closePop();
            hp.searchCity("Nairobi");
            hp.startDate("30", "May", "2026");
            hp.endDate("30", "June", "2026");
            hp.enterNumberOfAdults(4);
            hp.search();
            HotelSearchPage hotelSearchPage = new HotelSearchPage(driver);
            hotelSearchPage.clickOnSortByDropDown();
            hotelSearchPage.clickOnTopReviewsOption();
        }
}