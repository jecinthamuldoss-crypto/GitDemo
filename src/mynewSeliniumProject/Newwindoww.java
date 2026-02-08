package mynewSeliniumProject;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newwindoww {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> mywin = driver.getWindowHandles();
		Iterator<String> it = mywin.iterator();
	    String myparentwindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		driver.get("https://rahulshettyacademy.com/");
		String text = driver.findElement(By.cssSelector("p.text-lg.text-lg.text-muted-foreground.leading-relaxed.max-w-2xl")).getText();
		System.out.println(text);
		driver.switchTo().window(myparentwindow);
		WebElement name =driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(text);
		
		//screenshot of the field 
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		System.out.println("I'm making the changes in the codeeeeee");
		System.out.println("I'm making the changes in the codeeeeee8737383838");
		System.out.println("I'm making the changes in the codeeeeee38373838");
		System.out.println("I'm making the changes in the codeeeeeemmmmmmmmmmmmmmmmmm");
		
		
		
		
		//height and width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
	
		
			
		
		

	}

}
