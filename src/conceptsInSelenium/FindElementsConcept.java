package conceptsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElementsConcept {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.get("https://www.ebay.com/");
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //1. get the count of links on the page
        //2. get the text of each link on the page.

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        for (int i=0; i<links.size(); i++){
            String linkText = links.get(i).getText();
            System.out.println(linkText);
        }
    }
}
