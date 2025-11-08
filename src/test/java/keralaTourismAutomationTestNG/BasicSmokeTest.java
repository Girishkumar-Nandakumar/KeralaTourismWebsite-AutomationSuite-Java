package keralaTourismAutomationTestNG;

	import java.io.IOException;
import java.util.List;

	import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ScreenshotUtility;

	public class BasicSmokeTest extends Base {
		
		    @Test(priority = 1, groups = {"Smoke"})
		    public void verifyHomePageTitle() {
		    	
		    	driver.get(BASE_URL + "index.html");
		        String currentUrl = driver.getCurrentUrl();
		        Assert.assertTrue(currentUrl.contains("index"), "❌ Homepage URL does not contain 'index'");
		        System.out.println("✅ URL validation of home page passed!");

		        String title = driver.getTitle();
		        Assert.assertTrue(title.contains("Kerala"), "❌ Homepage title does not contain 'Kerala'");
		        System.out.println("✅ Title validation of home page passed!");
		    }

		  
		    @Test(priority = 2, groups = {"Smoke"})
		    public void basicNavigationThroughMainMenu() {

		     
		        List<WebElement> initialMenuItems = driver.findElements(By.xpath("//nav[@id='tm-main-nav']//a"));
		        int menuCount = initialMenuItems.size();

		        for (int i = 0; i < menuCount; i++) {
		            try {
		                
		                WebElement navBar = driver.findElement(By.xpath("//nav[@id='tm-main-nav']"));
		                List<WebElement> menuItems = navBar.findElements(By.tagName("a"));

		                WebElement currentItem = menuItems.get(i);
		                String optionText = currentItem.getText();
		                System.out.println("➡️ Clicking on: " + optionText);

		                currentItem.click();

		                System.out.println("Current Page Title: " + driver.getTitle());

		                driver.navigate().back();
		                
		                wait.until(ExpectedConditions.urlContains("index"));

		            } catch (StaleElementReferenceException e) {
		                System.out.println("🔁 StaleElementReferenceException occurred, retrying...");
		                i--; 
		            } catch (Exception e) {
		                System.out.println("⚠️ Unexpected error while navigating menu: " + e.getMessage());
		            }
		        }

		        System.out.println("✅ Navigation through main menu passed successfully!");
		    }

		    
		    
		    /*  @Test(priority = 2, groups = {"Smoke"})
		    public void basicNavigationThroughMainMenu() {
		        WebElement navBar = driver.findElement(By.xpath("//nav[@id='tm-main-nav']"));
		        List<WebElement> menuItems = navBar.findElements(By.tagName("a"));

		        for (WebElement item : menuItems) {
		            String optionText = item.getText();
		            System.out.println("➡️ Clicking on: " + optionText);
		            item.click();

		            System.out.println("Current Page Title: " + driver.getTitle());

		            driver.navigate().back();
		            wait.until(ExpectedConditions.urlContains("index"));

		            // Re-locate navigation bar after navigating back
		            navBar = driver.findElement(By.xpath("//nav[@id='tm-main-nav']"));
		            menuItems = navBar.findElements(By.tagName("a"));
		        }

		        System.out.println("✅ Navigation through main menu passed successfully!");
		    }*/

		    @Test(priority = 3, groups = {"Smoke"})
		    public void validatingExplorePage() {
		        driver.navigate().to(BASE_URL + "about.html");
		        wait.until(ExpectedConditions.urlContains("about"));

		        Assert.assertEquals(driver.getCurrentUrl(),
		                BASE_URL + "about.html",
		                "❌ Explore page URL mismatch!");
		        System.out.println("✅ URL validation of Explore page passed!");

		        Assert.assertEquals(driver.getTitle(), "At a glance", "❌ Explore page title mismatch!");
		        System.out.println("✅ Title validation of Explore page passed!");
		    }

		    @Test(priority = 4, groups = {"Smoke"})
		    public void validatingLoginPage() {
		        driver.navigate().to(BASE_URL + "login.html");
		        wait.until(ExpectedConditions.titleContains("Login"));

		        Assert.assertTrue(driver.getTitle().contains("Login"), "❌ Login page title mismatch!");
		        System.out.println("✅ Login page title validation passed!");
		    }

		    @Test(priority = 5, groups = {"Smoke"})
		    public void validatingSignupPage() {
		        driver.navigate().to( BASE_URL + "signup.html");
		        wait.until(ExpectedConditions.titleContains("Signup"));

		        Assert.assertTrue(driver.getTitle().contains("Signup"), "❌ Signup page title mismatch!");
		        System.out.println("✅ Signup page title validation passed!");
		    }
		    
		 
			@Test
			public void navigating_through_districts_page() throws IOException {
			
			driver.get(BASE_URL + "about.html");
				
			driver.findElement(By.xpath("//a[text()='Places To Visit']")).click();
			
			String current_URL_of_Districts_page = driver.getCurrentUrl();
			Assert.assertTrue(current_URL_of_Districts_page.equalsIgnoreCase("https://hashirakb.github.io/Kerala-Tourism-Website/districts.html"));
			System.out.println("✅ URL validation of districts page passed!");
			
			String current_page_title_of_districts_page = driver.getTitle();
			Assert.assertTrue(current_page_title_of_districts_page.contains("Districts"));
			System.out.println("✅ Title validation of districts page passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/palakkad.html");
			String current_title_of_Palakkad_page = driver.getTitle();
			Assert.assertTrue(current_title_of_Palakkad_page.equalsIgnoreCase("palakkad"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/thrissur.html");
			String current_title_of_Thrissur_page = driver.getTitle();
			Assert.assertTrue(current_title_of_Thrissur_page.equalsIgnoreCase("thrissur"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/malappuram.html");
			String current_title_of_Malappuram_page = driver.getTitle();
			Assert.assertTrue(current_title_of_Malappuram_page.equalsIgnoreCase("malappuram"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/trivandrum.html");
			String current_title_of_Thiruvananthapuram_page = driver.getTitle();
			Assert.assertTrue(current_title_of_Thiruvananthapuram_page.equalsIgnoreCase("trivandrum"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/kollam.html");
			String current_title_of_Kollam = driver.getTitle();
			Assert.assertTrue(current_title_of_Kollam.toLowerCase().equalsIgnoreCase("kollam"), "This Page doesn't have a page title");
			ScreenshotUtility.ScreenshotOf(driver, current_title_of_Kollam);
			System.out.println("✅ Title validation passed!");
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/kozhikode.html");
			String current_title_of_Kozhikode = driver.getTitle();
			Assert.assertTrue(current_title_of_Kozhikode.equalsIgnoreCase("kozhikode"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/pathanamthitta.html");
			String current_title_of_Pathanamthitta = driver.getTitle();
			Assert.assertTrue(current_title_of_Pathanamthitta.equalsIgnoreCase("pathanamthitta"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/wayanad.html");
			String current_title_of_Wayanad = driver.getTitle();
			Assert.assertTrue(current_title_of_Wayanad.equalsIgnoreCase("wayanad"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/alappuzha.html");
			String current_title_of_Alappuzha = driver.getTitle();
			Assert.assertTrue(current_title_of_Alappuzha.equalsIgnoreCase("alappuzha"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/kannur.html");
			String current_title_of_Kannur = driver.getTitle();
			Assert.assertTrue(current_title_of_Kannur.equalsIgnoreCase("kannur"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/kottayam.html");
			String current_title_of_Kottayam = driver.getTitle();
			Assert.assertTrue(current_title_of_Kottayam.equalsIgnoreCase("kottayam"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/iduki.html");
			String current_title_of_Idukki = driver.getTitle();
			Assert.assertEquals(current_title_of_Idukki.toLowerCase(), "idukki", "Spelling error in Idukki page title");
			ScreenshotUtility.ScreenshotOf(driver, current_title_of_Idukki);
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/ernakulam.html");
			String current_title_of_Ernakulam = driver.getTitle();
			Assert.assertTrue(current_title_of_Ernakulam.equalsIgnoreCase("ernakulam"));
			System.out.println("✅ Title validation passed!"); 
			
			
			driver.navigate().to("https://hashirakb.github.io/Kerala-Tourism-Website/kasargod.html");
			String current_title_of_Kasargod = driver.getTitle();
			Assert.assertTrue(current_title_of_Kasargod.equalsIgnoreCase("kasargod"));
			System.out.println("✅ Title validation passed!"); 
		
			}
		    
		 /*   @DataProvider(name = "districtPages")
		    public Object[][] getDistrictPages() {
		        return new Object[][] {
		           
		            {"palakkad.html", "palakkad"},
		            {"thrissur.html", "thrissur"},
		            {"malappuram.html", "malappuram"},
		            {"trivandrum.html", "trivandrum"},
		            {"kollam.html", "kollam"},
		            {"kozhikode.html", "kozhikode"},
		            {"pathanamthitta.html", "pathanamthitta"},
		            {"wayanad.html", "wayanad"},
		            {"alappuzha.html", "alappuzha"},
		            {"kannur.html", "kannur"},
		            {"kottayam.html", "kottayam"},
		            {"iduki.html", "iduki"}, 
		            {"ernakulam.html", "ernakulam"},
		            {"kasargod.html", "kasargod"}
		        };
		    }

		    @Test(dataProvider = "districtPages", groups = {"Smoke"}, priority = 7)
		    public void validateIndividualDistrictPages(String path, String expectedTitle) {
		        driver.navigate().to(BASE_URL + path);
		        String currentTitle = driver.getTitle();
		        
		        Assert.assertEquals(currentTitle.toLowerCase(), expectedTitle.toLowerCase(), 
		                            "❌ Title mismatch for page: " + path);
		        System.out.println("✅ Title validation for " + expectedTitle + " page passed!");
		    }*/
		    }