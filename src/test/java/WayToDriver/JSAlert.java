package WayToDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class JSAlert {
    WebDriver driver;

    @BeforeClass
    void setup() {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.way2automation.com/way2auto_jquery/automation-practice-site.html");

        //By alertMenuLocator = new By.ByCssSelector("");
        // WebElement alertMenu = driver.findElement(alertMenuLocator);
        //alertMenu.click();

        //
        // ArrayList<string> tabs = new ArrayList<string>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
    }

    @Test
    void test_Alert() throws InterruptedException {
        By alertButtonLocator = new By.ByCssSelector(".row:first-child button");
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }
    @Test
    void test_Alert2() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By alertButtonLocator = new By.ByCssSelector("#timerAlertButton");
        WebElement alertButton = driver.findElement(alertButtonLocator);
        alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }
    @Test
    void test_Alert3() throws InterruptedException {
        Thread.sleep(3000);
        By alertButtonLocator = new By.ByCssSelector("#confirmResult");
        WebElement alertButton = driver.findElement(alertButtonLocator);

        //clicking ok
        alertButton.click();
        driver.switchTo().alert().accept();

        //confirm is the right text shows up
        By resultlocator = new By.ByCssSelector("#confirmResult");
        WebElement resultEl = driver.findElement(resultlocator);

        //click ok
        String result = resultEl.getText();
        Assert.assertTrue(result.contains("Ok"));

        //clicking cancel
        alertButton.click();
        driver.switchTo().alert().dismiss();

        //confirm is the right text shows up
        result = resultEl.getText();
        Assert.assertTrue(result.contains("Cancel"));
    }
        @Test
         void testAlert4() throws InterruptedException {
            By promplocator = new By.ByCssSelector("#prompButton");
            WebElement prompButton = driver.findElement(promplocator);


            //negative test
            prompButton.click();
            driver.switchTo().alert().sendKeys("gfhghh");
            Thread.sleep(1000);
            driver.switchTo().alert().dismiss();

            By resultSelector = new By.ByCssSelector("#prompButton");
            Assert.assertThrows( () -> driver.findElement(resultSelector));

            //Assert.assertThrows( () -> System.out.println(5/0));


            //Positive test
            prompButton.click();
            driver.switchTo().alert().sendKeys("gfhghh");
            Thread.sleep(1000);
            driver.switchTo().alert().accept();

            WebElement resultEl = driver.findElement(resultSelector);
            String resulText = resultEl.getText();
            Assert.assertTrue(resulText.contains("hghghhb"));

        }

    @AfterTest
    void wrapUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();


    }


}
