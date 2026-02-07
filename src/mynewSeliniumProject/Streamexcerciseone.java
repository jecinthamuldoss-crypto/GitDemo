package mynewSeliniumProject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Streamexcerciseone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the first column header to get it sorted
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//now collect the list from the entire column
		List<WebElement> Mylist = driver.findElements(By.xpath("//tr/td[1]"));
		
		//now get the list in a new list using stream
		List<String> Mytext = Mylist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//now sort the collected text and store in different name
		List<String> Mysortedlist = Mytext.stream().sorted().collect(Collectors.toList());
		
		//now compare the original list and the sorted list using assertion 
		Assert.assertTrue(Mytext.equals(Mysortedlist));
		List<String> Myprice;
		
		
		do {
			//now collect the list from the entire column
			List<WebElement> Mylists = driver.findElements(By.xpath("//tr/td[1]"));
			
		//list the price of the product in the table
		Myprice = Mylists.stream().filter(s->s.getText().contains("Rice"))
				.map(s->getmyprice(s)).collect(Collectors.toList());
		Myprice.forEach(a->System.out.println(a));
		if(Myprice.size()<1) {
			driver.findElement(By.cssSelector("a[aria-label=\"Next\"]")).click();
		}
		}while(Myprice.size()<1);
	}

	
	
	private static String getmyprice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
