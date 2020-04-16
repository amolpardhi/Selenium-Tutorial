package conceptsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MouseMovementConcept {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get("https://book.spicejet.com/");

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='highlight-addons']"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'Hot Meals')]")).click();
        

    }
}
