package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class WaitUtils {
    public static WebDriverWait wait;

    public WaitUtils(WebDriver driver) throws IOException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(Utility.fetchPropertyValue("explicitWaitSeconds").toString())));
    }

    public static WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}