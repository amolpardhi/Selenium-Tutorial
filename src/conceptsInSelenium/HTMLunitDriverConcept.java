package conceptsInSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLunitDriverConcept {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/browsers/chromedriver.exe");
        driver = new HtmlUnitDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
    }
}
