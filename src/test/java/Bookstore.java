import Utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BookStorePage;
import pages.BookStorePage;
import pages.DemoQaHomePage;
public class Bookstore {
    WebDriver driver;
    DemoQaHomePage homePage;
    BookStorePage bookstorepage;
    JavascriptExecutor js;
    @BeforeClass
    void setup() {
        driver = DriverUtils.getWebDriver();
        //instantiating page objects
        homePage = new DemoQaHomePage();
        bookstorepage = new BookStorePage();
        driver.get(homePage.url);
        //driver.manage().window().maximize();
    }

    @Test (priority = 0)
    void bookstoreap() throws InterruptedException {

        //clicking bookstore application
       // DriverUtils.clickUsingJS(driver.findElement(homePage.BookStorAppEl));
        DriverUtils.clickUsingJS(homePage.BookStorAppEl);
        Thread.sleep(3000);

        //clicking login button
        DriverUtils.clickUsingJS(bookstorepage.loginSubEl);
        //bookstorepage.loginSubEl.click();
    }
    @Test(priority = 1)
    void loginbookstore() throws InterruptedException {

        //writedownusername
        Thread.sleep(1000);
        By username = new By.ByCssSelector("#userName");
        WebElement unEl = driver.findElement(username);
        unEl.sendKeys("halbro");
        Thread.sleep(1000);

        //writedownpassword
        By Password = new By.ByCssSelector("#password");
        WebElement passEl = driver.findElement(Password);
        passEl.sendKeys("Halbro@7780");

        //clicking login
        By submit = new By.ByCssSelector("[id='login']");
        WebElement submitEl = driver.findElement(submit);
        submitEl.click();

        //Assertion
        //String expectedtitle = "ToolsQA";
        //String actualtitle = driver.getTitle();
        //Assert.assertEquals(actualtitle,expectedtitle);

    }

    @Test(priority = 2)
    void booklist() throws InterruptedException {

        //adding book
        Thread.sleep(2000);
        By addBook = new By.ByCssSelector("[id='see-book-Git Pocket Guide']");
        WebElement addbokEl = driver.findElement(addBook);
        addbokEl.click();


        Thread.sleep(2000);
        By addtocollection = new By.ByCssSelector("div:last-child> #addNewRecordButton");
        WebElement addcolEl = driver.findElement(addtocollection);
        addcolEl.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();


        Thread.sleep(3000);
        By profile = new By.ByCssSelector(".element-group:nth-child(6) #item-3");
        WebElement proEl = driver.findElement(profile);
        proEl.click();

    }
        @Test(priority = 3)
        void booklocat() throws InterruptedException {

        By booklocator = new By.ByCssSelector(".mr-2 a");
        WebElement bookEl = driver.findElement(booklocator);
        bookEl.getText();
        Thread.sleep(2000);

        By delete = new By.ByCssSelector("#delete-record-undefined path");
        WebElement delEl = driver.findElement(delete);
        delEl.click();

        By buttonok = new By.ByCssSelector("#closeSmallModal-ok");
        WebElement butEl = driver.findElement(buttonok);
        butEl.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

    }

    @AfterClass
    void wrapUp(){
        //driver.quit();

    }

}
