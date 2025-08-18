package testng.basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnGroupsExample {

    @Test(groups = {"smoke"})
    public void verifyLogin() {
        Assert.assertTrue(false);
        System.out.println("Verify Login");
    }

    @Test(dependsOnGroups = "smoke")
    public void verifyHomePage() {
        System.out.println("Verify Home Page");
    }

    @Test
    public void verifyAccountCreation() {
        System.out.println("Verify Account Creation");
    }
}
