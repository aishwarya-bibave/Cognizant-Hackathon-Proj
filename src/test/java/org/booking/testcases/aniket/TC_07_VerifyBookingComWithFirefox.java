package org.booking.testcases.aniket;
import basetest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC_07_VerifyBookingComWithFirefox extends BaseTest {
    @Test
    public void verifyBookingComWithFirefox() {
        SoftAssert sa = new SoftAssert();

        // Wait until the title contains "Booking"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Booking"));

        String title = driver.getTitle();
        System.out.println("Page title: " + title);

        // More flexible check
        sa.assertTrue(title.toLowerCase().contains("booking"),
                "Unexpected page title: " + title);

        sa.assertAll();
    }
}
