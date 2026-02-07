package mynewSeliniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignmentsix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//step1
		driver.findElement(By.id("checkBoxOption2")).click();
		String Myoption = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println(Myoption);
		
		//step2
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		
		Select s = new Select(dropdown); 
		s.selectByContainsVisibleText(Myoption);
		System.out.println(s.getFirstSelectedOption().getText());
		
		//step3
		driver.findElement(By.id("name")).sendKeys(Myoption);
		driver.findElement(By.id("alertbtn")).click();
		
		String AlrtText = driver.switchTo().alert().getText();
				
		if(AlrtText.contains(Myoption)) {
			
			System.out.println("Step3 " + Myoption);
			
		}
		
	   
	    
			
			

	}

}
