package keralaTourismAutomationTestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Base {

	  	protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected final String BASE_URL = "https://hashirakb.github.io/Kerala-Tourism-Website/";
	    protected final String password = "221B@BakeRStreeT";
	    protected final String email = "holmes_Sherlock@geemail.com";
	    protected final String name = "Sherlock Holmes";
	    protected final String phoneNumber = "1234567890";
	   

	    @Parameters ("browser")
	    @BeforeClass
	    public void initializeDriver(String browser) {
	      if (browser.equalsIgnoreCase("chrome")) {
	    	  driver = new ChromeDriver();
	      }else if(browser.equalsIgnoreCase("firefox")) {
	    	  driver = new FirefoxDriver();
	      }else if(browser.equalsIgnoreCase("edge")) {
	    	  driver =new EdgeDriver();
	      }else {
	    	  throw new IllegalArgumentException("Invalid BroserName");
	      }
	
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
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
	}

