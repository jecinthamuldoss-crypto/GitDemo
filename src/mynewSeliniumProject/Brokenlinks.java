package mynewSeliniumProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.mastercard.ie/en-ie.html");
		driver.manage().window().maximize();
		
	
		SoftAssert a = new SoftAssert();
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//finding all the links in the page works or not.
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links) {
			
			String url = link.getAttribute("href");
			
			if (url == null || url.isEmpty()) {
                continue;    // ← This is the ONLY difference from pure Rahul style
            }
			 
			HttpURLConnection conn= (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respcode = conn.getResponseCode();
			System.out.println(link.getText() + respcode);
			a.assertTrue(respcode<400, "the broken link is:  "+ link.getText() + respcode);
			
			
		}
		a.assertAll();
		}
		
		
		
		


	}


