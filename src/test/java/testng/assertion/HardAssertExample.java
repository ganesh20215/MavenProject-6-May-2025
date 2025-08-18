package testng.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testng.retryfailscript.FailScriptExecution;

public class HardAssertExample {

   /* @Test(retryAnalyzer = FailScriptExecution.class)
    public void verifyHardAssert() throws InterruptedException {
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
        Assert.assertEquals(element, "products", "Products text should be displayed");
        Assert.assertTrue(swagElement.isDisplayed(), "Swag Element should Displayed.");

        Thread.sleep(2000);

        driver.close();
    }*/


   @Test
    public void verifyHardAssert_1() throws InterruptedException {
        Assert.assertTrue(false);
        System.out.println("Hello");
    }

   @Test
    public void verifyHardAssert_2() throws InterruptedException {
        System.out.println("Hello");
    }

   @Test
    public void verifyHardAssert_3() throws InterruptedException {
        System.out.println("How Are You?");
    }
}
