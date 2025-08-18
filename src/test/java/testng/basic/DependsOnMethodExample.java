package testng.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodExample {

    @Test(description = "Verify Login with valid username and valid password")
    public void verifyLogin() {
        Assert.assertTrue(false);
        System.out.println("Verify Login");
    }

    @Test(dependsOnMethods = "verifyLogin")
    public void verifyHomePage() {
        System.out.println("Verify Home Page");
    }

    @Test
    public void verifyAccountCreation() {
        System.out.println("Verify Account Creation");
    }
}
