package conceptsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class DragAndDrop {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.switchTo().frame(0); //switch to frame if it is available.

        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).
                release().build().perform();

    }
}
