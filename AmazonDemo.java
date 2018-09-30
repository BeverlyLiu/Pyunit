import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonDemo {

	public static void main(String[] args) {
		System.setProperty(
				"webdriver.chrome.driver",
				"./drivers/chromedriver"
		);
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");
		
		// I am in Amazon homepage.
		// I need to find the search input box to type the keyword.
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("selenium webdriver");
		WebElement searchIcon =driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input"));
		
		searchIcon.click();
		
		// I am in the result page now!
		WebElement status = driver.findElement(By.id("s-result-count"));
		System.out.println(status.getText());
		driver.quit();
		}
	}
