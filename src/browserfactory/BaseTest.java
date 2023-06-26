package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest
{
    String baseUrl = "http://the-internet.herokuapp.com/login";
    public static WebDriver driver;

    public void openBrowser() {
        // Launch the Chrome Browser
        driver = new ChromeDriver();

        // Open the URL into Browser
        driver.get(baseUrl);

        //Maximise Browser
        driver.manage().window().maximize();

        // We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {

        driver.quit();
    }
}