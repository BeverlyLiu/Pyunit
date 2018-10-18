
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testAmazonSearchResult() {
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("selenium webdriver");
		WebElement searchIcon =driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input"));
		
		searchIcon.click();
		WebElement status = driver.findElement(By.id("s-result-count"));
		String text = "1-16 of 136 results for \"selenium webdriver\"";
		assertEquals(text, status.getText());
	}
}
