package keralaTourismAutomationTestNG;

import org.testng.annotations.Test;

public class Performance_PageLoadTime extends Base{

	
	@Test
	public void measurePageLoadTime() {
	    String[] pages = {
	        "https://hashirakb.github.io/Kerala-Tourism-Website/index.html",
	        "https://hashirakb.github.io/Kerala-Tourism-Website/destinations.html",
	        "https://hashirakb.github.io/Kerala-Tourism-Website/contact.html"
	    };

	    for (String page : pages) {
	        long start = System.currentTimeMillis();
	        driver.get(page);
	        long finish = System.currentTimeMillis();
	        long totalTime = finish - start;
	        System.out.println("⏱️ Load time for " + page + " = " + totalTime + " ms");
	        if (totalTime > 3000) {
	            System.out.println("⚠️ Page load time exceeded 3 seconds: " + page);
	        } else {
	            System.out.println("✅ Page loaded within acceptable time: " + page);
	        }	        
	    }
	}	
}
