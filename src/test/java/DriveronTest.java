import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DriveronTest {
    //declare and initialize driver
    WebDriver driver;

    @BeforeClass
    void preparation() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/"); // .get() method to navigate to a
    }

    @Test
            void testingElement(){

    By firstElement = new By.ByCssSelector(".mt-4:first-child");
    WebElement element = driver.findElement(firstElement);
        element.click();}

    @Test
            void testingLogo(){

    By logolocator = new By.ByCssSelector("header img");
    WebElement logo = driver.findElement(logolocator);
        logo.click();}

        @Test
                void testingFormes(){


        By formsLocator = new By.ByCssSelector(".mt-4:nth-child(2)");
    WebElement formes = driver.findElement(formsLocator);
        formes.click();}


        @AfterTest
    void wrapUp(){

        }






}
