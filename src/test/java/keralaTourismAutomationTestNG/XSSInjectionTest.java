package keralaTourismAutomationTestNG;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ScreenshotUtility;


public class XSSInjectionTest extends Base{

	@Test
    public void test_Signup_XSS_Injection() throws IOException {
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/signup.html");
       
        driver.findElement(By.name("name")).sendKeys("<script>alert('XSS')</script>");
        driver.findElement(By.id("semail")).sendKeys("xss@demo.com");
        driver.findElement(By.id("phone")).sendKeys("1234567890");
        driver.findElement(By.id("password1")).sendKeys("Test@123");
        driver.findElement(By.id("password2")).sendKeys("Test@123");

       
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        ScreenshotUtility.ScreenshotOf(driver, "C:\\Users\\GIRISH\\OneDrive\\Pictures\\Screenshots\\Capstone Project screenshots\\screenshotOfXSSInjection.png");
       
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("XSS Alert Detected: " + alert.getText());
            alert.accept();
            Assert.fail("XSS vulnerability detected in signup form.");
        } catch (NoAlertPresentException e) {
            System.out.println("No XSS vulnerability detected in signup form.");
        }
    }

    @Test
    public void test_Login_XSS_Injection() throws IOException {
        driver.get("https://hashirakb.github.io/Kerala-Tourism-Website/login.html");

        driver.findElement(By.id("email")).sendKeys("<script>alert('XSS')</script>");
        driver.findElement(By.id("password")).sendKeys("<script>alert('XSS')</script>");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("XSS Alert Detected: " + alert.getText());
            alert.accept();
            Assert.fail("XSS vulnerability detected in login form.");
        } catch (NoAlertPresentException e) {
            System.out.println("No XSS vulnerability detected in login form.");
        }
        ScreenshotUtility.ScreenshotOf(driver, "C:\\Users\\GIRISH\\OneDrive\\Pictures\\Screenshots\\Capstone Project screenshots\\screenshot" + System.currentTimeMillis() + ".png");
    }
}
