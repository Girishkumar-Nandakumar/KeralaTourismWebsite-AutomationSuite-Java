package keralaTourismAutomationTestNG;

import org.openqa.selenium.*;
import org.testng.annotations.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkDetection extends Base{

	    @Test
	    public void verifyBrokenLinks() {
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        System.out.println("Total links found: " + links.size());

	        for (WebElement element : links) {
	            String url = element.getAttribute("href");
	            if (url == null || url.isEmpty()) continue;

	            try {
	                @SuppressWarnings("deprecation")
					HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
	                conn.setRequestMethod("HEAD");
	                conn.connect();
	                int responseCode = conn.getResponseCode();

	                if (responseCode >= 400) {
	                    System.out.println("❌ Broken link: " + url + " | Status: " + responseCode);
	                } else {
	                    System.out.println("✅ Valid link: " + url);
	                }
	            } catch (Exception e) {
	                System.out.println("⚠️ Error checking link: " + url + " | " + e.getMessage());
	            }
	        }
	    }
	}
