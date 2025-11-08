package keralaTourismAutomationTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FormFieldValidation extends Base{

	@Parameters ("browser")
    @BeforeClass
    public void initializeDriver(String browser) {
       driver = new ChromeDriver();
        	        
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get(BASE_URL + "index.html");
        System.out.println("🌴 Browser launched and Kerala Tourism site loaded successfully.");
    }
	
	 @AfterClass
	    public void tearDownDriver() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("🧹 Browser closed successfully.");
	        }
	    }
	 
	 
	 @Test(groups = {"FormValidation"})
public void handle_Unexpected_Alert_If_Present() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println("✅ Handled unexpected alert before navigation.");
    } catch (Exception e) {
  
    }
}


	@Test(groups = {"FormValidation"})
	public void form_Validation_With_Empty_Email_Field_on_Login_Page() {
		handle_Unexpected_Alert_If_Present();
		
		driver.navigate().to(BASE_URL + "login.html");
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertMessageForEmptyEmailField = driver.switchTo().alert().getText();
		Assert.assertTrue(alertMessageForEmptyEmailField.contains("Email"));
		driver.switchTo().alert().accept();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertMessageForEmptyEmailField);
	}
	
	
	@Test(groups = {"FormValidation"})
	public void form_Validation_With_Empty_password_field_On_Login_Page() {
		handle_Unexpected_Alert_If_Present();

		driver.navigate().to(BASE_URL + "login.html");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).clear();	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertForEmptyPasswordField = driver.switchTo().alert().getText();
		Assert.assertTrue(alertForEmptyPasswordField.contains("Password"));
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertForEmptyPasswordField);
	}
	
	
	@Test(groups = {"FormValidation"})

	public void form_Validation_With_Both_Empty_Fields_on_Login_Page() {
		handle_Unexpected_Alert_If_Present();

		driver.navigate().to(BASE_URL + "login.html");
		driver.findElement(By.xpath("//input[@id='email']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).clear();	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertForEmptyFields = driver.switchTo().alert().getText();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertForEmptyFields);
	}
	
	
	@Test(groups = {"FormValidation"})
	public void form_Validation_With_Invalid_email_in_Login_Page() {
		handle_Unexpected_Alert_If_Present();
		
		driver.get(BASE_URL + "login.html");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Holmes_Sherlock@geemail");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertForInvalidEmailField = driver.switchTo().alert().getText();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertForInvalidEmailField); 
	}

	
	@Test(groups = {"FormValidation"})
	public void form_Validation_With_Invalid_Password_In_Login_Page() {
		handle_Unexpected_Alert_If_Present();
		driver.switchTo().alert().accept();
		driver.get(BASE_URL + "login.html");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("bakerstreet@london");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertForInvalidpasswordField = driver.switchTo().alert().getText();
		Assert.assertTrue(alertForInvalidpasswordField.contains("Password"));
		driver.switchTo().alert().accept();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertForInvalidpasswordField);
	}
	
	
	@Test(groups = {"FormValidation"})
	public void form_Validation_With_Password_Lesser_than_The_Minimum_Requirement() {
		handle_Unexpected_Alert_If_Present();
		driver.switchTo().alert().accept();
		driver.get(BASE_URL + "login.html");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Holmes_Sherlock@geemail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("PassworD");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertForPasswordBelowMinimalRequirement = driver.switchTo().alert().getText();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertForPasswordBelowMinimalRequirement);
	}

	@Test(groups = {"FormValidation"})
	public void form_Validation_With_Long_Password_Exceeding_The_Minimum_Requirement() {
		handle_Unexpected_Alert_If_Present();

		driver.get(BASE_URL + "login.html");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Holmes_Sherlock@geemail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("PassworD");	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertForlongPassword = driver.switchTo().alert().getText();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertForlongPassword);
	}
		
	
	@Test(groups = {"FormValidation"})

	public void form_Field_Validation_With_Empty_Name_Field_InSignUp() {
		handle_Unexpected_Alert_If_Present();

		driver.get(BASE_URL + "signup.html");
		
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='password2']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.switchTo().alert().accept();	
	}
	
	
	@Test(groups = {"FormValidation"})

	public void form_Field_Validation_With_Empty_Email_Field_In_SignUP() {
		handle_Unexpected_Alert_If_Present();

		driver.get(BASE_URL + "signup.html");
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='password2']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertTextforEmptyemailFieldInSignUp = driver.switchTo().alert().getText();
		Assert.assertTrue(alertTextforEmptyemailFieldInSignUp.contains("Email"));
		driver.switchTo().alert().accept();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertTextforEmptyemailFieldInSignUp);
	}
	
	@Test(groups = {"FormValidation"})
	public void form_Field_Validation_With_Empty_PhoneNumber_Field_In_SignUp() {
		handle_Unexpected_Alert_If_Present();

		driver.get(BASE_URL + "signup.html");
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='phone']")).clear();
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='password2']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertTextforEmptyPhoneNumberFieldInSignUp = driver.switchTo().alert().getText();
		Assert.assertTrue(alertTextforEmptyPhoneNumberFieldInSignUp.contains("phone number"));
		driver.switchTo().alert().accept();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertTextforEmptyPhoneNumberFieldInSignUp);
	}
	
	@Test(groups = {"FormValidation"})

	public void form_Field_Validation_With_Empty_Password1_Field_In_SignUp() {
		handle_Unexpected_Alert_If_Present();

		driver.get(BASE_URL + "signup.html");
				
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
				driver.findElement(By.xpath("//input[@id='password1']")).clear();
				driver.findElement(By.xpath("//input[@id='password2']")).sendKeys(password);
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				String alertTextforEmptyPassword1FieldInSignUp = driver.switchTo().alert().getText();
				Assert.assertTrue(alertTextforEmptyPassword1FieldInSignUp.contains("Password"));
				driver.switchTo().alert().accept();
				System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertTextforEmptyPassword1FieldInSignUp);
			}

	
	@Test(groups = {"FormValidation"})

	public void form_Field_Validation_With_Empty_Password2_Field_In_SignUp() {
		handle_Unexpected_Alert_If_Present();
driver.switchTo().alert().accept();

		driver.get(BASE_URL + "signup.html");
				
				driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
				driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
				driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
				driver.findElement(By.xpath("//input[@id='password2']")).clear();
				
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				
				String alertTextforEmptyPassword2FieldInSignUp = driver.switchTo().alert().getText();
				Assert.assertTrue(alertTextforEmptyPassword2FieldInSignUp.contains("Passwords Doesnt Match, Please Re-enter :"));
				driver.switchTo().alert().accept();
				System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertTextforEmptyPassword2FieldInSignUp);
	}
	
	@Test(groups = {"FormValidation"})
	public void form_Validation_with_Mismatch_Passwords_In_SignUp() {
		handle_Unexpected_Alert_If_Present();
		driver.switchTo().alert().accept();
		driver.get(BASE_URL + "signup.html");
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='password2']")).sendKeys("PASSword@1234");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String alertTextforMismatchPasswordInSignUp = driver.switchTo().alert().getText();
		Assert.assertTrue(alertTextforMismatchPasswordInSignUp.contains("Passwords"));
		driver.switchTo().alert().accept();
		System.out.println("Validation Failed. The website threw an validation error alert with :- " + alertTextforMismatchPasswordInSignUp);	
	}
}