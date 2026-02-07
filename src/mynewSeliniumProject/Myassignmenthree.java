package mynewSeliniumProject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myassignmenthree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); // Extra safety
        options.setExperimentalOption("prefs", Map.of(
            "credentials_enable_service", false,
            "profile.password_manager_enabled", false,
            "profile.password_manager_leak_detection", false
        ));
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
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
		
		
		
		//explicit wait 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='my-4']")));
		
		
		String[] phonetoAdd= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
		List<String> phoneList = Arrays.asList(phonetoAdd);
		
		List<WebElement> prodname = driver.findElements(By.cssSelector("h4.card-title"));
		
		int j =0;
	
		for(int i = 0; i<prodname.size();i++) {
			
			String productnames = prodname.get(i).getText().trim();
			
			if(phoneList.contains(productnames)) {
				j++;
				
				driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();
				
				if(j == phonetoAdd.length) {
					break;
				}
			}
		}
		
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
		
		
	}
		
		
		

	}

//driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
//
//driver.findElement(By.id("password")).sendKeys("learning");
//
//driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
//
////Thread.sleep(3000);
//
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));
//
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
//
//driver.findElement(By.id("okayBtn")).click();
//
//WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));
//
//Select dropdown = new Select(options);
//
//dropdown.selectByValue("consult");
//
//driver.findElement(By.id("signInBtn")).click();
//
//
//
//
//
//
//
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));
//
//List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
//
//for(int i =0;i<products.size();i++)
//
//{
//
//products.get(i).click();
//
//}
//
//driver.findElement(By.partialLinkText("Checkout")).click();}
//
//
//
//
//
//
//
//}
