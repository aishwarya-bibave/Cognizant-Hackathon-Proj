package org.booking.testcases;

import basetest.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.booking.pages.HomePage;
import org.booking.pages.HotelSearchPage;
import org.booking.pages.PropertyDetailsPage;

import java.util.List;

public class TC_28_HotelSelectedByPropertyRating extends BaseTest {

    private static final Logger log = LogManager.getLogger(TC_29_HotelsSortedByLowPrice.class);

    @Test
    public void verifyBookingComWithFirefox() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);
        PropertyDetailsPage pdp = new PropertyDetailsPage(driver);

        log.info("Starting test: Verify if Hotels option is selected");

        hp.closePop();
        log.info("Closed popup successfully");

        hp.searchCity("Nairobi");
        log.info("Entered city: Nairobi");

        boolean startDateSelected = hp.startDate("30", "May", "2026");
        log.info("Start date selected: " + startDateSelected);

        hp.endDate("30", "June", "2026");
        log.info("End date selected: 30 June 2026");

        hp.enterNumberOfAdults(4);
        log.info("Entered number of adults: 4");

        hp.search();
        log.info("Clicked search button");

        hsp.clickVacationHomesOption();
        log.info("Clicked Vacation Homes filter");

        hsp.clickHotelsOption();
        log.info("Clicked Hotels filter");


        hsp.enterSmartFilter("Elevator");
        log.info("Entered Elevator in Smart Filters");
        Thread.sleep(7000);
        hsp.topReviewedProperties();

        Thread.sleep(2000);

        List<Integer> rating = hsp.topReviewedProperties();

        int limit = Math.min(5, rating.size());


        for (int i = 0; i < limit - 1; i++) {
            Assert.assertTrue(
                    rating.get(i) >= rating.get(i + 1),
                    "Rating order incorrect in first five: " + rating.subList(0, limit)
            );


            log.info("Assertion completed: Hotels are sorted according to property rating properly");
        }
    }
}
