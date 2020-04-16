package conceptsInSelenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertPopUp {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver","browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput","true");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(29, TimeUnit.SECONDS);
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.xpath("//*[@class='signinbtn']")).click();

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        // if there is cancel is there then we use -- alert.dismiss();

        String text = alert.getText();
        if (text.equals("Please enter a valid user name")){
            System.out.println("correct message");
        } else {
            System.out.println("Incorrect message");
        }
        alert.accept();

        driver.findElement(By.xpath("//*[@name='login']")).sendKeys("amolpardhi9@gmail.com");
        driver.findElement(By.xpath("//*[@name='proceed']")).click();

        Thread.sleep(3000);

        System.out.println(alert.getText());

        String text1 = alert.getText();
        if (text1.equals("Please enter your password")){
            System.out.println("correct message");
        } else {
            System.out.println("Incorrect message");
        }
        alert.accept();

    }
}
