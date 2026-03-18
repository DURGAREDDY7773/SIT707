package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/durgareddy/Downloads/chromedriver-mac-arm64/chromedriver");

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();
			driver.get(url);
			sleep(3);

			driver.findElement(By.id("firstname")).sendKeys("Durga");
			driver.findElement(By.id("lastname")).sendKeys("Kankanala");
			driver.findElement(By.id("phoneNumber")).sendKeys("0422337336");
			driver.findElement(By.id("email")).sendKeys("reddydurga636@gmail.com");

			// Keep weak password for Officeworks so it fails as required
			driver.findElement(By.id("password")).sendKeys("12345");

			sleep(2);

			driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();

			sleep(4);

			takeScreenshot(driver, "officeworks.png");
			System.out.println("Officeworks screenshot saved");

		} catch (Exception e) {
			System.out.println("Officeworks error: " + e.getMessage());
		} finally {
			driver.quit();
		}
	}

	public static void onepagecrm_registration_page(String url) {
		System.setProperty("webdriver.chrome.driver", "/Users/durgareddy/Downloads/chromedriver-mac-arm64/chromedriver");

		WebDriver driver = new ChromeDriver();

		try {
			driver.manage().window().maximize();
			driver.get(url);
			sleep(4);

			// Email
			driver.findElement(By.xpath("//input[@type='email' or contains(@name,'email') or contains(@id,'email')]"))
					.sendKeys("reddydurga636@gmail.com");

			// Password
			driver.findElement(By.xpath("//input[@type='password' or contains(@name,'password') or contains(@id,'password')]"))
					.sendKeys("Dhruv@0900");

			sleep(2);

			// Sign up button
			driver.findElement(By.xpath("//button[contains(.,'Sign up with email') or contains(.,'Sign up')]"))
					.click();

			sleep(4);

			takeScreenshot(driver, "onepagecrm.png");
			System.out.println("OnePageCRM screenshot saved");

		} catch (Exception e) {
			System.out.println("OnePageCRM error: " + e.getMessage());
			takeScreenshot(driver, "onepagecrm_error.png");
			System.out.println("OnePageCRM error screenshot saved");
		} finally {
			driver.quit();
		}
	}

	public static void takeScreenshot(WebDriver driver, String fileName) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(fileName);
			FileHandler.copy(src, dest);
			System.out.println("Screenshot saved: " + fileName);
		} catch (IOException e) {
			System.out.println("Screenshot save error: " + e.getMessage());
		}
	}
}
