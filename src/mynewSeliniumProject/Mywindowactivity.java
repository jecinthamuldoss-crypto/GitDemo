package mynewSeliniumProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mywindowactivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		
		
		Set <String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();      //parent and child window is accessed from 
		String parentid = it.next();                   // stays in the parentwindow
		String childid = it.next();                    // stays in child window
		driver.switchTo().window(childid);             // now the window completly changes to child window.
		
		
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		
		String username = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("@")[1].split("\\.")[0];
		
		System.out.println(username);
		
		
		driver.switchTo().window(parentid);
		driver.findElement(By.id("username")).sendKeys(username);
		
		String password = driver.findElement(By.cssSelector("p.text-center.text-white")).getText().split("Password is ")[1].split("\\)")[0];
		System.out.println(password);
		driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='user']")).click();
		
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-body")));

		driver.findElement(By.id("okayBtn")).click();
		
		//static drop down select option 
		WebElement staticdropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByVisibleText("Consultant");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		

	}

}

