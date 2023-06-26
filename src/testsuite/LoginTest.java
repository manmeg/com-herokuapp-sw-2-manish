package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter username
        driver.findElement(By.xpath("//input[@id= 'username']")).sendKeys("tomsmith");
        // Enter Password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on Login Button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        // Verify the text Secure Area
        driver.findElement(By.xpath("//h2[text()=' Secure Area']")).getText();

        String expectedText = "You logged into a secure area!\n" +
                "×";
        String actualText = driver.findElement(By.xpath("//div[contains(text(), 'secure area')]")).getText();
        Assert.assertEquals("Error text not displayed", expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        // Enter username
        driver.findElement(By.xpath("//input[@id= 'username']")).sendKeys("tomsmith1");
        // Enter Password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");

        //Click on Login Button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        //* Verify the error message “Your username is invalid!”

        driver.findElement(By.xpath("//div[@class='flash error']")).getText();


        // Verify Error text display
        String expectedText = "Your username is invalid!\n" +
                "×";
        String actualText = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Error text not displayed", expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter username
        driver.findElement(By.xpath("//input[@id= 'username']")).sendKeys("tomsmith");
        // Enter Password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword");

        //Click on Login Button
        driver.findElement(By.xpath("//i[text()=' Login']")).click();

        //* Verify the error message “Your password is invalid!”

        driver.findElement(By.xpath("//div[@class='flash error']")).getText();

        // Verify Error text display
        String expectedText = "Your password is invalid!\n" +
                "×";
        String actualText = driver.findElement(By.xpath("//div[@class='flash error']")).getText();
        Assert.assertEquals("Error text not displayed", expectedText, actualText);
    }

    @After
    public void closeDown(){
        closeBrowser();
    }
}
