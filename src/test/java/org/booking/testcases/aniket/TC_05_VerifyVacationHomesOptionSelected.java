package org.booking.testcases.aniket;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.zigwheels.pages.HomePage;
import org.zigwheels.pages.HotelSearchPage;

import java.time.Duration;

public class TC_05_VerifyVacationHomesOptionSelected extends BaseTest {
    @Test
    public void verifyVacationHomesFilter() {
        HomePage hp = new HomePage(driver);
        HotelSearchPage hsp = new HotelSearchPage(driver);

        hp.closePop();
        hp.searchCity("Nairobi");
        Assert.assertTrue(hp.startDate("4", "May", "2026"));
        hp.endDate("7", "May", "2026");
        hp.enterNumberOfAdults(2);
        hp.search();

        hsp.clickVacationHomesOption();

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(hsp.isVacationHomesFilterApplied(), "Vacation Homes option is not selected");
        sa.assertAll();
    }
}