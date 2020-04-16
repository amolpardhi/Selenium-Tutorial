package screenShotsConcepts;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class ScreenshotConcept {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);



    }
}
