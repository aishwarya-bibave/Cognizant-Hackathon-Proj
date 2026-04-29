package org.zigwheels.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage{
    WebDriver driver;
    JavascriptExecutor js;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='e1e158e66b afdff78c97 ce103e449e fe169dc72b']")
    WebElement closePopupBtn;

    @FindBy(xpath="//input[@placeholder='Where are you going?']")
    WebElement searchCity;

    @FindBy(xpath="//button[@data-testid='searchbox-dates-container']")
    WebElement clickDateElement;

    @FindBy(xpath="(//div[@data-testid = 'searchbox-datepicker-calendar']//following::h3)[1]")
    WebElement currentMonthAndYear;

    @FindBy(xpath="//span[@class='ecb788f3b7 c0b8f1e8f8 d9382a910a']//span")
    WebElement currentDay;

    @FindBy(xpath="//button[@aria-label='Next month']")
    WebElement nextMonthBtn;

    @FindBy(xpath="//button[@data-testid='occupancy-config']")
    WebElement guestSelector;

    @FindBy(xpath="(//span[@class='e32aa465fd'])[1]")
    WebElement checkAdultCount;

    @FindBy(xpath="(//button[@tabindex = '-1'])[2]")
    WebElement adultPlusBtn;

    @FindBy(xpath="(//div[@class='e301a14002']//button)[1]")
    WebElement adultMinusBtn;

    @FindBy(xpath="//span[normalize-space()='Done']")
    WebElement applyBtn;

    @FindBy(xpath="//span[text()='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "//span[contains(text(),'Sort by')]")
    WebElement sortByOption;

    @FindBy(xpath = "//span[text()='Top reviewed']")
    WebElement topReviewOption;


    public void closePop(){
        try{
            closePopupBtn.click();
        }catch(ElementClickInterceptedException e){
            js.executeScript("arguments[0].click()", closePopupBtn);
        }
    }

    public void searchCity(String enterCity){
        searchCity.sendKeys(enterCity);
        searchCity.sendKeys(Keys.TAB);
    }

    public void startDate(String startDay, String startMonth, String startYear){
        try{
            clickDateElement.click();
        }catch(ElementClickInterceptedException e){
            js.executeScript("arguments[0].click()", clickDateElement);
        }
        String[] currentMonthYear = currentMonthAndYear.getText().split(" ");
        String currentMonth = "";
        String currentYear = "";
        try{
            currentMonth = currentMonthYear[0];
            currentYear = currentMonthYear[1];
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        }
        String currentDayStr = currentDay.getText();
        int currentDayInt = Integer.parseInt(currentDayStr);
        int startDayInt = Integer.parseInt(startDay);
        while(!currentYear.equals(startYear)){
            try{
                nextMonthBtn.click();
            }catch(ElementClickInterceptedException e){
                js.executeScript("arguments[0].click()", nextMonthBtn);
            }
            currentMonthYear = currentMonthAndYear.getText().split(" ");
            currentMonth = currentMonthYear[0];
            currentYear = currentMonthYear[1];
        }
        while(!currentMonth.equals(startMonth)){
            try{
                nextMonthBtn.click();
            }catch(ElementClickInterceptedException e){
                js.executeScript("arguments[0].click()", nextMonthBtn);
            }
            currentMonthYear = currentMonthAndYear.getText().split(" ");
            currentMonth = currentMonthYear[0];
        }
        if(startDayInt >= currentDayInt){
            driver.findElement(By.xpath("(//span[text()='"+startDay+"'])[1]")).click();
        } else {
            System.out.println("Expected day is before current day, cannot select.");
        }
    }

    public void endDate(String endDay, String endMonth, String endYear){
        String[] currentMonthYear = currentMonthAndYear.getText().split(" ");
        String currentMonth = "";
        String currentYear = "";
        try{
            currentMonth = currentMonthYear[0];
            currentYear = currentMonthYear[1];
        }catch(IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return;
        }
        while(!currentYear.equals(endYear)){
            try{
                nextMonthBtn.click();
            }catch(ElementClickInterceptedException e){
                js.executeScript("arguments[0].click()", nextMonthBtn);
            }
            currentMonthYear = currentMonthAndYear.getText().split(" ");
            currentMonth = currentMonthYear[0];
            currentYear = currentMonthYear[1];
        }
        while(!currentMonth.equals(endMonth)){
            try{
                nextMonthBtn.click();
            }catch(ElementClickInterceptedException e){
                js.executeScript("arguments[0].click()", nextMonthBtn);
            }
            currentMonthYear = currentMonthAndYear.getText().split(" ");
            currentMonth = currentMonthYear[0];
        }

        driver.findElement(By.xpath("(//span[text()='"+endDay+"'])[1]")).click();
        clickDateElement.sendKeys(Keys.TAB);
    }

    public void enterNumberOfAdults(int targetAdults){
        try{
            guestSelector.click();
        }catch(ElementClickInterceptedException e){
            js.executeScript("arguments[0].click()", guestSelector);
        }
        int currentAdultsSelected = Integer.parseInt(checkAdultCount.getText());
        while(currentAdultsSelected < targetAdults){
            try{
                adultPlusBtn.click();
            }catch(ElementClickInterceptedException e){
                js.executeScript("arguments[0].click()", adultPlusBtn);
            }
            currentAdultsSelected = Integer.parseInt(checkAdultCount.getText());
        }
        while(currentAdultsSelected > targetAdults){
            try{
                adultMinusBtn.click();
            }catch(ElementClickInterceptedException e){
                js.executeScript("arguments[0].click()", adultMinusBtn);
            }
            currentAdultsSelected = Integer.parseInt(checkAdultCount.getText());
        }
        try{
            applyBtn.click();
        }catch(ElementClickInterceptedException e){
            js.executeScript("arguments[0].click()", applyBtn);
        }

    }

    public void search(){
        try{
            searchBtn.click();
        }catch(ElementClickInterceptedException e){
            js.executeScript("arguments[0].click()", searchBtn);
        }
    }
}