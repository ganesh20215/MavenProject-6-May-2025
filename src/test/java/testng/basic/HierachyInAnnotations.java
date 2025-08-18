package testng.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HierachyInAnnotations {

    public static WebDriver driver;

    @BeforeMethod
    public void preCondition(){
        driver = new ChromeDriver();
    }

    @Test
    public void testCase1(){
        driver.get("https://www.infosys.com/");
    }

    @Test
    public void testCase2(){
        driver.get("https://www.flipkart.com");
    }

    @AfterMethod
    public void postCondition(){
        driver.close();
    }
}
