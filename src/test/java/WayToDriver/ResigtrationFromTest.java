package WayToDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ResigtrationFromTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");
    }
    @Test
    void completeRegistration() throws InterruptedException {
        //locator for registraion menu
        By reglink = new By.ByCssSelector(".linkbox:nth-child(5) a");
        WebElement regLinkElement = driver.findElement(reglink);
        regLinkElement.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep( 3000);

        //Locator for first name
        By firstName = new By.ByCssSelector("fieldset:first-child p:first-child input");
        WebElement firstNameEl = driver.findElement(firstName);
        firstNameEl.sendKeys("Biden");

        //locate for last name
        By lastName = new By.ByCssSelector("fieldset:first-child p:last-child input");
        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Trump");

        //locate for single status
        By single = new By.ByCssSelector("fieldset:nth-child(2) :first-child [name='m_status']");
       WebElement singleRadio =  driver.findElement(single);
       singleRadio.click();


       //locate for hobbey of cricket
        By cricket = new By.ByCssSelector("label:nth-child(3) [name='hobby']");
        WebElement cricketradio = driver.findElement(cricket);
        cricketradio.click();

        //locate for dropBox of country
        By country = new By.ByCssSelector("fieldset:nth-child(4) select");
        Select countryselect = new Select(driver.findElement(country));
        countryselect.selectByVisibleText("India");

        //Locator for DOB
        By month = new By.ByCssSelector(".time_feild:nth-child(2) select");
        Select monthselect = new Select (driver.findElement(month));
        monthselect.selectByVisibleText("1");

        //lcator for Day
        By day = new By.ByCssSelector(".time_feild:nth-child(3) select");
        Select dayselect = new Select (driver.findElement(day));
        dayselect.selectByVisibleText("1");

        //locator for year
        By year = new By.ByCssSelector(".time_feild:nth-child(4) select");
        Select yearselect = new Select (driver.findElement(year));
        yearselect.selectByVisibleText("2014");

        //locator for phonenumber
        By Phonenumber = new By.ByCssSelector(".fieldset:nth-child(6) input");
        WebElement phonenumberEl = driver.findElement(Phonenumber);
        phonenumberEl.sendKeys("6777767068");

        //locator for choose file
        By picture = new By.ByCssSelector("fieldset [type='file']");
        WebElement pictureEl =  driver.findElement(picture);
        pictureEl.sendKeys("/Users/jahi/Desktop/download.png");

        //locator for password
        By password = new By.ByCssSelector(".fieldset:nth-child(11) input");
        WebElement passwordEl = driver.findElement(password);
        passwordEl.click();


        


        //Thread.sleep(3000);
        //Actions act = new Actions(driver);
       // act.moveToElement(regLinkElement).click().build().perform();




    }


    @AfterTest
    void wrapUp(){
        //driver.quit()


    }
}
