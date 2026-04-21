package web.service;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class LoginServiceTest {

    private WebDriver driver;

    private final String driverPath = "/Users/durgareddy/Downloads/chromedriver-mac-arm64/chromedriver";

    private final String loginPagePath =
            "file:///Users/durgareddy/Desktop/SIT707/7.1P-resources/pages/login.html";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void performLogin(String username, String password, String dob) {

        try {
            driver.navigate().to(loginPagePath);

            WebElement ele = driver.findElement(By.id("username"));
            ele.clear();
            ele.sendKeys(username);

            ele = driver.findElement(By.id("passwd"));
            ele.clear();
            ele.sendKeys(password);


            ((JavascriptExecutor) driver)
                    .executeScript("document.getElementById('dob').value='" + dob + "'");
            Thread.sleep(1000);
            ele = driver.findElement(By.cssSelector("[type=submit]"));
            ele.submit();

            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLoginSuccess() {
        performLogin("ahsan", "ahsan_pass", "2000-01-01");
        assertEquals("success", driver.getTitle());
    }

    @Test
    public void testLoginFailWrongUsername() {
        performLogin("wronguser", "ahsan_pass", "2000-01-01");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFailWrongPassword() {
        performLogin("ahsan", "wrongpass", "2000-01-01");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFailWrongDob() {
        performLogin("ahsan", "ahsan_pass", "1999-01-01");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFailEmptyUsername() {
        performLogin("", "ahsan_pass", "2000-01-01");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFailEmptyPassword() {
        performLogin("ahsan", "", "2000-01-01");
        assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testLoginFailEmptyDob() {
        performLogin("ahsan", "ahsan_pass", "");
        assertEquals("fail", driver.getTitle());
    }
}