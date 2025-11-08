package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public static void ScreenshotOf(WebDriver driver, String filepath) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\GIRISH\\OneDrive\\Pictures\\Screenshots\\Capstone Project screenshots\\screenshot" + System.currentTimeMillis() + ".png"));
	}

}
