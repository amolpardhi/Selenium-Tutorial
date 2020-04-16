package conceptsInSelenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorConcept {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "browsers/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://ui.cogmento.com/");

        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("amolpardhi9@gmail.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("Ganesh@28");
        //driver.findElement(By.xpath("(//*[contains(text(),'Login')])[1]")).click();

        //executeScript -- to execute JavaScript code

        WebElement loginBtn = driver.findElement(By.xpath("(//*[contains(text(),'Login')])[1]"));

        flash(loginBtn, driver); //highlight the element

        drawBorder(loginBtn, driver); //draw a border

        //Take screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src , new File("src/screenShotsConcepts/element.png"));

        //generate Alert
        //generateAlert(driver,"There is an issue on login button" );

        //click on button
        clickElementByJS(loginBtn, driver);

        //refresh by JavaScript
        refreshByJS(driver);

        //get title of te Page by Js
        System.out.println(pageTitleByJS(driver));

        //get the page text
        System.out.println(getPageInnerText(driver));

        //scroll page Down
        scrollPageDown(driver);

        WebElement signUpLink = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
        scrollIntoView(signUpLink, driver);
    }

    public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        for (int i = 0; i <  20; i++) {
            changeColor("rgb(0,200,0)", element,driver);//1
            changeColor(bgcolor, element,driver);//2
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
    }

    public static void drawBorder(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border = '3px solid red'", element);
    }

    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('"+message+"')");
    }

    public static void clickElementByJS(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    public static void refreshByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }

    public static String pageTitleByJS(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static String getPageInnerText(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }


    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public static void scrollIntoView(WebElement element, WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);" , element);
    }
}
