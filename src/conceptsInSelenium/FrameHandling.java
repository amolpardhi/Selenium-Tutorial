package conceptsInSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

    static WebDriver amol;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        amol = new ChromeDriver();
        amol.manage().window().maximize();
        amol.get("http://demo.automationtesting.in/Frames.html");
        amol.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
    }
}
