package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static void main (String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
	
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.clear();
		input.sendKeys("Selenium webdriver");
		WebElement searchIcon =driver.findElement(By.cssSelector("#nav-search > form > div.nav-right > div > input"));
		searchIcon.click();
		
		List<WebElement> books = driver.findElements(By.cssSelector("#s-results-list-atf > li"));
		System.out.println("Number of books listed in the first result page: " + books.size());
		
		for (WebElement book : books) {
			System.out.println();
			WebElement title = book.findElement(By.tagName("h2"));
			System.out.println(title.getAttribute("innerText"));
			
			try {
				WebElement prices = book.findElement(By.xpath(".//h3[text()='Paperback']/../../following-sibling::div[1]"));
				
				try {
					WebElement price = prices.findElement(By.cssSelector(".sx-price"));
					List<WebElement> money = price.findElements(By.xpath("./*"));
					System.out.println('$' + money.get(1).getText() + "." + money.get(2).getText());
					continue;
					
				} 
				catch (NoSuchElementException e) {}
			}
			catch (NoSuchElementException e) {}
		
			System.out.println("No Paperback price");
			
		}
	}
}
