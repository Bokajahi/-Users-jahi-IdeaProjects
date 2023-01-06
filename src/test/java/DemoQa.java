import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class DemoQa {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http:https://demoqa.com/"); // .get() method to navigate to a

        // Click on the Element Menu
        By firstElement = new  By.ByCssSelector(".mt-4:first-child");
        WebElement element = driver.findElement(firstElement);
        element.click();


        //Click ont the logo to come to the home screen
        By logolocator = new By.ByCssSelector("header img");
        WebElement logo = driver.findElement(logolocator);
        logo.click();

        //Click on the form menu
        By formsLocator = new By.ByCssSelector(".mt-4:nth-child(2)");
        WebElement formes = driver.findElement(formsLocator);
        formes.click();


        //header = driver.findElement(headerLocator);
        //headerText = header.getText();
       // Assert.assertEquales(headerText, "Forms");

        //quitting the browser
        driver.quit();






    }







}
