package conceptsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserPopupConcept {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.popuptest.com/goodpopups.html");

        driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #3')]")).click();
        Set<String> handler = driver.getWindowHandles();

        Iterator<String> it = handler.iterator();
        String parentWindowId = it.next();
        System.out.println(parentWindowId);

        String childWindowId = it.next();
        System.out.println(childWindowId);

        Thread.sleep(2000);

        driver.switchTo().window(childWindowId);
        System.out.println(driver.getTitle());

        driver.close();

        Thread.sleep(2000);

        driver.switchTo().window(parentWindowId);
        System.out.println(driver.getTitle());

        driver.close();

    }
}
