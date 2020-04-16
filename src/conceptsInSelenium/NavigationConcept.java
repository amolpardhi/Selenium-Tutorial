package conceptsInSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com");
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();

    }
}
