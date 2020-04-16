package conceptsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandleFileUploadPopUp {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(29, TimeUnit.SECONDS);
        driver.get("https://html.com/input-type-file/");
        driver.findElement(By.xpath("//a[@class='pm-cta pm-cancel-btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("D:\\Images\\Wallpaper Images\\aston_martin.jpg");

    }
}
