package mynewSeliniumProject;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calenderui {

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	//takes the input for the date/month/year
    	System.out.println("Please Enter the date (1-31): ");
    	String date = scan.nextLine();
    	System.out.println("Please Enter the full month name: ");
    	String month = scan.nextLine();
    	System.out.println("Please enter the year: ");
    	String year = scan.nextLine();
    	
    	//hits the browser and maximizes
    	ChromeDriver driver = new ChromeDriver();
    	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    	
    	//Select the calendar now, it needs to be generic.
    	driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
    	
    	while(true)
    	{
    		driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
    		
    		if(!driver.findElements(By.cssSelector("button.react-calendar__century-view__decades__decade")).isEmpty()) {
    			break;
    		}
    	
    		}
    		
    	while(true) {
    		String text = driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).getText();
    		 String[] parts = text.split("–");
    		 int blockstart = Integer.parseInt(parts[0].trim());
    		 int endblock = Integer.parseInt(parts[1].trim());
    		 int targetedyear = Integer.parseInt(year);
    		
    		 if(targetedyear >= blockstart && targetedyear <= endblock) {
    			 break;
    		 }
    		 if(targetedyear < blockstart) {
    			 
    			 driver.findElement(By.cssSelector("button.react-calendar__navigation__prev-button")).click();
    		
    		 }else {
    			 driver.findElement(By.cssSelector("button.react-calendar__navigation__next-button")).click();

    		 }
    	}
    		 //selecting the year's decade button
    		
    		int decade = (Integer.parseInt(year) / 10) * 10; 
    	            driver.findElement(By.xpath("//button[contains(., '" + decade + "') and contains(., '–')]")).click(); 
    		 
    	            // 5. Click the exact year
    	            driver.findElement(By.xpath("//button[normalize-space()='" + year + "']")).click();
    	
    	


    }
    
}