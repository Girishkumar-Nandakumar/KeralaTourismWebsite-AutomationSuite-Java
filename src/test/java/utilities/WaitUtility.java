package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtility {

	public void WaitUntil(WebDriver driver) {
		WebDriverWait waitUntil = new WebDriverWait(driver, Duration.ofSeconds(5)); 
	}
}
