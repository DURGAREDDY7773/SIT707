package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFunctionalTest {

    private WebDriver driver;
    private final String BASE_URL = "http://127.0.0.1:8081";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/durgareddy/Downloads/chromedriver-mac-arm64/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void login() throws InterruptedException {
        driver.get(BASE_URL + "/login");
        Thread.sleep(1000);

        driver.findElement(By.id("username")).sendKeys("ahsan");
        driver.findElement(By.id("passwd")).sendKeys("ahsan_pass");
        driver.findElement(By.id("dob")).sendKeys("2000-01-01");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testFullCorrectGamePath() throws InterruptedException {
        login();

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));

        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("result")).sendKeys("3");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q2"));

        driver.findElement(By.id("number1")).sendKeys("10");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q3"));

        driver.findElement(By.id("number1")).sendKeys("4");
        driver.findElement(By.id("number2")).sendKeys("5");
        driver.findElement(By.id("result")).sendKeys("20");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/finished"));
    }

    @Test
    public void testWrongAnswerStaysOnSameQuestion() throws InterruptedException {
        login();

        driver.findElement(By.id("number1")).sendKeys("1");
        driver.findElement(By.id("number2")).sendKeys("2");
        driver.findElement(By.id("result")).sendKeys("5");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @Test
    public void testEmptyInputShowsErrorMessage() throws InterruptedException {
        login();

        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("/q1"));
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}