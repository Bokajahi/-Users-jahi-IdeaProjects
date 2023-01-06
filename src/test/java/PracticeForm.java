import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeForm {
    WebDriver driver;
    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }
    @Test
    void name(){
        By firstName = new By.ByCssSelector("#userName-wrapper :nth-child(2) input");
        By lastName = new By.ByCssSelector("#userName-wrapper :nth-child(4) input");
        By email = new By.ByCssSelector("#userEmail-wrapper :nth-child(2) input");
        By genderM = new By.ByCssSelector("[for=\"gender-radio-1\"]");
        By phone = new By.ByCssSelector("#userNumber-wrapper");


        WebElement firstNameEl = driver.findElement(firstName);
        firstNameEl.sendKeys("Halstead");

        WebElement lastNameEl = driver.findElement(lastName);
        lastNameEl.sendKeys("Broadway");

        WebElement webEl = driver.findElement(email);
        webEl.sendKeys("secretoflife@live.com");

        WebElement genderMEl = driver.findElement(genderM);
        genderMEl.click();

        WebElement phoneEl = driver.findElement(phone);
        phoneEl.sendKeys("2345679807");


        // 12/28/1993
        //select on the DOB data picker
        By DOB = new By.ByCssSelector("#dateOfBirthInput");
        WebElement dobEl = driver.findElement(DOB);
        dobEl.click();

        //yearlocator
        By yearlocator = new By.ByCssSelector(".react-datepicker__year select");
        Select yearSelect = new Select(driver.findElement(yearlocator));
        yearSelect.selectByVisibleText("1993");

        //motnhlocator
        By monthlocator = new By.ByCssSelector(".react-datepicker__month--select");
        Select monthSelect = new Select(driver.findElement(monthlocator));
        monthSelect.selectByVisibleText("December");

        //datelocator
        By date = new By.ByXPath("//div[contains(text(), '28')]");
        WebElement dateEl = driver.findElement(date);
        dateEl.click();




    }

    @AfterClass
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();


    }

}
