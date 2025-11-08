package keralaTourismAutomationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2EuserJourney extends Base{

	    @Test(priority = 1, groups = {"E2E"})
	    public void verifyHomePageTitle() {
	        String title = driver.getTitle();
	        Assert.assertEquals(title, "Kerala Tourism", "❌ Homepage title mismatch!");
	        System.out.println("✅ Homepage title verified successfully!");
	    }
	    
	    
	    @Test(priority = 2, dependsOnMethods = "verifyHomePageTitle", groups = {"E2E"})
	    public void performSignUp() {
	        driver.findElement(By.xpath("//a[text()='Signup']")).click();
	        Assert.assertEquals(driver.getTitle().toLowerCase(), "signup", "❌ Signup page not opened!");

	        driver.findElement(By.name("name")).sendKeys("Sherlock Holmes");
	        driver.findElement(By.id("semail")).sendKeys("Holmes_Sherlock@geemail.com");
	        driver.findElement(By.id("phone")).sendKeys("1175225711");
	        driver.findElement(By.id("password1")).sendKeys(password);
	        driver.findElement(By.id("password2")).sendKeys(password);
	        driver.findElement(By.xpath("//button[@type='submit']")).click();

	        System.out.println("📝 Sign-up form submitted successfully!");
	        driver.switchTo().alert().accept();
	        wait.until(ExpectedConditions.urlContains("districts"));
	    }


	    @Test(priority = 3, dependsOnMethods = "performSignUp", groups = {"E2E"})
	    public void exploreDistricts() {
	        driver.findElement(By.xpath("//a[text()='read more..' and @href='palakkad.html']")).click();
	        Assert.assertEquals(driver.getTitle().toLowerCase(), "palakkad", "❌ Failed to open Palakkad page!");
	        System.out.println("✅ Navigated to Palakkad page");

	        driver.navigate().back();

	        driver.findElement(By.xpath("//a[text()='read more..' and @href='thrissur.html']")).click();
	        Assert.assertEquals(driver.getTitle().toLowerCase(), "thrissur", "❌ Failed to open Thrissur page!");
	        System.out.println("✅ Navigated to Thrissur page");

	        driver.navigate().back();
	        System.out.println("🌏 District navigation completed!");
	    }
	    }
