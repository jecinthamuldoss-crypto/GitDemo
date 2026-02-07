package mynewSeliniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scrollll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");   //selects the whole window and scrolls
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); // selects the particular table in the window and scrolls.
		
		//add all the numbers from the table which is present in fourth column.
		//List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		List<WebElement> values = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum = 0;
		
		for(int i=0; i<values.size(); i++) {
			
			sum = sum+ (Integer.parseInt(values.get(i).getText()));
			
		}
		
		System.out.println(sum);
		
		//int Totalnumber = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		//System.out.println(Totalnumber);
		//Assert.assertEquals(Totalnumber, sum );
	}

}
