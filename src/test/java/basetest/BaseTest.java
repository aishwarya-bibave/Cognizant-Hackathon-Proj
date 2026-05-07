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
import utilities.PropertiesUtil;
import utilities.WaitUtils;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        if(PropertiesUtil.fetchPropertyValue("browser").equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
//            chromeOptions.addArguments("--headless");
        }else if(PropertiesUtil.fetchPropertyValue("browser").equals("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new FirefoxDriver(firefoxOptions);
//            firefoxOptions.addArguments("--headless");
        }
        else if(PropertiesUtil.fetchPropertyValue("browser").equals("edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            driver = new EdgeDriver(edgeOptions);
//            edgeOptions.addArguments("--headless");
        }
        driver.get(PropertiesUtil.fetchPropertyValue("baseUrl").toString());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertiesUtil.fetchPropertyValue("implicitWaitSeconds").toString())));
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

