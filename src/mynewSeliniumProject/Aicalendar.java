package mynewSeliniumProject;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class Aicalendar {

	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);

        System.out.print("Enter Day (1-31)      : ");
        String day = scan.nextLine().trim();

        System.out.print("Enter Month (e.g. April): ");
        String month = scan.nextLine().trim();

        System.out.print("Enter Year             : ");
        String year = scan.nextLine().trim();

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // OPEN CALENDAR
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

        // STEP 1: GO TO CENTURY VIEW (where you see "1991 – 2000" blocks)
        while (true) {
            driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
            if (!driver.findElements(By.cssSelector("button.react-calendar__century-view__decades__decade")).isEmpty()) {
                break;
            }
        }

        // STEP 2: NAVIGATE TO THE CORRECT CENTURY BLOCK USING ARROWS
        while (true) {
            String rangeText = driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).getText();
            String[] parts = rangeText.split("–");
            int blockStart = Integer.parseInt(parts[0].trim());
            int blockEnd   = Integer.parseInt(parts[1].trim());
            int targetYear = Integer.parseInt(year);

            if (targetYear >= blockStart && targetYear <= blockEnd) {
                break;
            }

            if (targetYear < blockStart) {
                driver.findElement(By.cssSelector("button.react-calendar__navigation__prev-button")).click();
            } else {
                driver.findElement(By.cssSelector("button.react-calendar__navigation__next-button")).click();
            }
        }

        // STEP 3: CLICK THE CORRECT DECADE BLOCK (e.g., "1991 – 2000")
        int decade = (Integer.parseInt(year) / 10) * 10;  // 1998 → 1990
        driver.findElement(By.xpath("//button[contains(., '" + decade + "') and contains(., '–')]")).click();

        // STEP 4: CLICK THE EXACT YEAR
        driver.findElement(By.xpath("//span[text()='" + year + "']/parent::button")).click();

        // STEP 5: CLICK MONTH (first 3 letters)
        driver.findElement(By.xpath("//abbr[text()='" + month.substring(0, 3) + "']")).click();

        // STEP 6: CLICK DAY
        driver.findElement(By.xpath("//abbr[text()='" + Integer.parseInt(day) + "']")).click();

        System.out.println("SUCCESS → " + day + " " + month + " " + year + " SELECTED!");

        try { Thread.sleep(5000); } catch (Exception e) {}
        driver.quit();
        scan.close();
    }


		
	}

