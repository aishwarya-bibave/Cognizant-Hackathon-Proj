package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.Utility;
import utilities.WaitUtils;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        if(Utility.fetchPropertyValue("browser").equals("chrome")) {
            driver = new ChromeDriver();
//            ChromeOptions chromeOptions = new ChromeOptions();
//            chromeOptions.addArguments("--headless");
        }else if(Utility.fetchPropertyValue("browser").equals("firefox")){
            driver = new FirefoxDriver();
//            FirefoxOptions firefoxOptions = new FirefoxOptions();
//            firefoxOptions.addArguments("--headless");
        }
        else if(Utility.fetchPropertyValue("browser").equals("edge")){
            driver = new EdgeDriver();
//            EdgeOptions edgeOptions = new EdgeOptions();
//            edgeOptions.addArguments("--headless");
        }
        driver.get(Utility.fetchPropertyValue("baseUrl").toString());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Utility.fetchPropertyValue("implicitWaitSeconds").toString())));
        try{
            new WaitUtils(driver);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

