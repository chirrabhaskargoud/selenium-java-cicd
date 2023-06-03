package selenium_framework.selenium_framework;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
	WebDriver driver=null;
	
	@BeforeMethod
	public void initDriver() throws MalformedURLException {
		DesiredCapabilities dsCapabilities=new DesiredCapabilities();
		dsCapabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		
		driver=new RemoteWebDriver(new URL("http://localhost:4444/"), dsCapabilities);
	}
	
	@Test
	public void test2() {
		 // Navigate to Google homepage
        driver.get("https://www.google.com");

        // Find the search input element and enter a search query
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("OpenAI ChatGPT");

        // Submit the search query
        searchInput.submit();

        // Wait for the search results to load
        WebElement searchResults = driver.findElement(By.id("search"));

        // Print the page title and the number of search results
        String pageTitle = driver.getTitle();
        System.out.println("Page title: " + pageTitle);

        String searchResultStats = searchResults.findElement(By.id("result-stats")).getText();
        System.out.println("Search results: " + searchResultStats);
		
	}
	
	public void afterTest() {
		try {
			driver.close();;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
