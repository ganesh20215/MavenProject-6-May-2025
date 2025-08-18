package testng.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void verifySoftAssert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();

        String element = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        WebElement swagElement = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        SoftAssert sf = new SoftAssert();
        sf.assertEquals(element, "Products", "Products text should be displayed");
        sf.assertTrue(swagElement.isDisplayed(), "Swag Element should Displayed.");

        Thread.sleep(2000);

        sf.assertAll();

        driver.close();
    }
}
