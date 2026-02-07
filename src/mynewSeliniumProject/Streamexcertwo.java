package mynewSeliniumProject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streamexcertwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the filter box and pass some veggie name
		driver.findElement(By.id("search-field")).sendKeys("apple");
		//store the listed veggies in the webelement
		List<WebElement> veggie = driver.findElements(By.xpath("//tr/td[1]"));
		
		//now convert this veggie in stream and get the text
		List<WebElement> veg = veggie.stream().filter(s->s.getText().contains("apple")).collect(Collectors.toList());
		
		//assert now both elements are equal
		Assert.assertEquals(veggie.size(), veg.size());
		

	}

}
