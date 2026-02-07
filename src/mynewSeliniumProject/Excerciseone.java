package mynewSeliniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Excerciseone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		// Selecting the country
		// Auto suggest drop down using Web element and option is the object
				driver.findElement(By.id("autosuggest")).sendKeys("IND");
				Thread.sleep(2000);

				List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

				for (WebElement option : options) {
					if (option.getText().equalsIgnoreCase("India")) {
						option.click();
						break;
					}
				}
				
				// selecting the from and too destination traveling

				driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
				driver.findElement(By.xpath("//a[@value='BHO']")).click();

				driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
				
				// Date selecting for the trip

				driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

				driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
				System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

				driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

				System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));

				if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {

					System.out.println("return date box is diplayed");
					Assert.assertTrue(true);
				} else {
					Assert.assertFalse(false);
				}
				//increasing the adults normal drop box

				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(2000);

				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				for (int i = 1; i < 5; i++) {
					driver.findElement(By.id("hrefIncAdt")).click();
				}

				driver.findElement(By.id("btnclosepaxoption")).click();

				Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		//static dropdown : select is the object for the static drop down.

				WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

				Select dropdown = new Select(staticdropdown);
				dropdown.selectByIndex(1);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByContainsVisibleText("USD");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByValue("AED");
				System.out.println(dropdown.getFirstSelectedOption().getText());

		//selecting the check box and knowing how many check box is present in the screen
				driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
				System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// click on the search button now 
				driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();




	}}