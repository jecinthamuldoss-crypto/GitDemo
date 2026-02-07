package mynewSeliniumProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sessioneleven {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//count of entire page
		System.out.println(driver.findElements(By.tagName("a")).size());  //count of entire page
		
		//excluding all the link counts and just grabbing the footer links count.
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size()); 
		
		//finding the count of the single column links present in footer
		WebElement column = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		
		//click on the each link in the column and check if its working properly
		for(int i=1; i<column.findElements(By.tagName("a")).size();i++) {
			
			//clicks all the links and opens new window in mac using cmnd+enter  in windows it is ctrl+enter.
			String ClicksLink = Keys.chord(Keys.COMMAND,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(ClicksLink);
			Thread.sleep(5000);
		}
			
			
			//get the title of each opened new tab
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			
			while(it.hasNext()) {
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
		}

	}


