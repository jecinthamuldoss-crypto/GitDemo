package mynewSeliniumProject;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Relative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/inputs");
		WebElement title = driver.findElement(By.cssSelector("input[type='number']"));
		WebElement mypart = driver.findElement(with(By.tagName("p")).above(title));
		String mytext = mypart.getText();
		System.out.println(mytext);
		
		
	}

}
