package mynewSeliniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmentseven {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");   //selects the whole window and scrolls
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); // selects the particular table in the window and scrolls.
		
		WebElement table = driver.findElement(By.id("product"));
		
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
		
		driver.findElement(By.id("autocomplete")).sendKeys("Ind");
		Thread.sleep(2000);
		
		List <WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item"));
		
		for(WebElement option:options) {
			if(option.getText().equalsIgnoreCase("India")) {
				option.click();
			break;
		}
		}
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); //to print the selected option which is displayed in the field.

	
		
	}
	

}
