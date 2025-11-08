package keralaTourismAutomationTestNG;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ResponsiveUITest extends Base {
	    
	    @DataProvider(name = "screenResolutions")
	    public Object[][] screenResolutions() {
	        return new Object[][]{
	            {1920, 1080, "Desktop"},
	            {1024, 768, "Tablet"},
	            {375, 667, "Mobile iPhone"},
	            {360, 800, "Mobile Android"}
	        };
	    }
	 
	    @Test(dataProvider = "screenResolutions", groups = {"Responsive"})
	    public void verifyResponsiveLayouts(int width, int height, String deviceType) {

	        System.out.println("\n📱 Checking layout for: " + deviceType + " (" + width + "x" + height + ")");
	        
	        driver.manage().window().setSize(new Dimension(width, height));
	        driver.navigate().refresh();

	        wait.until(ExpectedConditions.urlContains("index.html"));
	        
	        String pageTitle = driver.getTitle();
	        Assert.assertTrue(pageTitle.contains("Kerala Tourism"), "❌ Page title mismatch for " + deviceType);
	        
	        System.out.println("✅ " + deviceType + " layout loaded successfully (" + width + "x" + height + ")");
	    }
	}