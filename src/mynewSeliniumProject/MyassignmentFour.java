package mynewSeliniumProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyassignmentFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		Set <String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);  //goes to child window
		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
		
		driver.switchTo().window(parentID);     //goes to parent window
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		

	}

}
