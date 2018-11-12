package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment2 {
	public static void main (String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.expedia.com/");
	
		//click the flights tab
		WebElement flights = driver.findElement(By.id("tab-flight-tab-hp"));
		flights.click();
		
		//type in flying from input
		WebElement from_input = driver.findElement(By.id("flight-origin-hp-flight"));
		from_input.clear();
		from_input.sendKeys("sfo");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("typeaheadDataPlain")));
		
		from_input.sendKeys(Keys.ARROW_DOWN);
		from_input.sendKeys(Keys.ENTER);
		
		//type in flying to input
		WebElement to_input = driver.findElement(By.id("flight-destination-hp-flight"));
		to_input.clear();
		to_input.sendKeys("n");
		to_input.clear();
		to_input.sendKeys("nyc");
		
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("typeaheadDataPlain")));
		
		to_input.sendKeys(Keys.ARROW_DOWN);
		to_input.sendKeys(Keys.ENTER);
		
		//choose departing date
		WebElement departing_date = driver.findElement(By.id("flight-departing-hp-flight"));
		departing_date.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("datepicker-cal")));
		
		WebElement next_month = driver.findElement(By.cssSelector(".datepicker-cal .datepicker-cal-month:last-child"));
		WebElement day15 = next_month.findElement(By.xpath(".//button[contains(text(), '15')]"));
		day15.click();
		
		//click search button
		WebElement search_btn = driver.findElement(By.cssSelector("label.search-btn-col button[type='submit']"));
		search_btn.click();
		
		//next page
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pi-interstitial")));
		
		List<WebElement> results = driver.findElements(By.cssSelector("#flightModuleList > li.flight-module"));
		System.out.println("\nDeparture Time   "  + "Arrival Time  "  + "Price\n" );
		
		for (WebElement entry : results) {
			
			WebElement departure_time = entry.findElement(By.cssSelector("*[data-test-id='departure-time']"));
			
			
			WebElement arrival_time = entry.findElement(By.cssSelector("*[data-test-id='arrival-time']"));
			
			
			WebElement price = entry.findElement(By.cssSelector("*[data-test-id='listing-price-dollars']"));
			
			
			System.out.println( departure_time.getText() + "           " + arrival_time.getText() + "         " + price.getText());
			
		}
	}
}
