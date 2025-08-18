package testng.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BasicOfTestNG {

    @Test
    public void testCase1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.edso.in");
		driver.close();
    }

    @Test(groups = {"p0"})
    public void testCase2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in");
        driver.close();
    }
}
